
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define BACKLIGHT_PATH "/sys/class/backlight/sprd_backlight/brightness"
#define LIGHT_SENSOR_PATH "/sys/class/sprd_sensorhub/sensor_hub/raw_data_als"
#define SETTINGS_CMD "settings get system screen_brightness_mode"
#define POLL_DELAY_MS 30  // 30ms polling (smooth)

// ==================== BRIGHTNESS SCALING ====================
int scale_brightness(int android_val) {
    if (android_val == 0) return 1;
    if (android_val == 255) return 4095;
    return 1 + (android_val * 4094) / 255;
}

// ==================== AUTO-BRIGHTNESS MAPPING ====================
int lux_to_brightness(int lux) {
    // Smooth logarithmic mapping for better UX
    if (lux < 5) return 10;      // Pitch black
    if (lux < 20) return 30;     // Very dark
    if (lux < 50) return 50;     // Dark room
    if (lux < 100) return 70;    // Dim room
    if (lux < 200) return 100;   // Normal indoor
    if (lux < 500) return 140;   // Bright indoor
    if (lux < 1000) return 180;  // Very bright
    if (lux < 3000) return 220;  // Daylight
    return 255;                  // Direct sun
}

// ==================== SLIDE DETECTION ====================
typedef struct {
    int last_value;
    int last_change_time;
    int is_sliding;
    int slide_timeout;
    int change_count;
    int last_written;
} SlideDetector;

void init_slide_detector(SlideDetector *det) {
    memset(det, 0, sizeof(SlideDetector));
    det->last_value = -1;
    det->last_written = -1;
}

int update_slide_detector(SlideDetector *det, int current_value) {
    struct timespec ts;
    clock_gettime(CLOCK_MONOTONIC, &ts);
    int now_ms = ts.tv_sec * 1000 + ts.tv_nsec / 1000000;
    
    if (det->last_value != -1) {
        int diff = abs(current_value - det->last_value);
        int time_diff = now_ms - det->last_change_time;
        
        // Detect rapid changes = user sliding
        if (diff > 5 && time_diff < 300) {  // >5 change within 300ms
            det->change_count++;
            if (det->change_count > 2) {  // Multiple rapid changes
                det->is_sliding = 1;
                det->slide_timeout = 40;  // 1.2 seconds (40 * 30ms)
            }
        } else {
            det->change_count = 0;
        }
        
        if (diff > 0) {
            det->last_change_time = now_ms;
        }
    }
    
    det->last_value = current_value;
    
    // Update sliding state
    if (det->is_sliding) {
        det->slide_timeout--;
        if (det->slide_timeout <= 0) {
            det->is_sliding = 0;
            det->change_count = 0;
            return 0; // Slide ended
        }
        return 1; // Still sliding
    }
    
    return 0; // Not sliding
}

// ==================== SMOOTH WRITER ====================
typedef struct {
    int target_value;
    int current_value;
    int step;
    int last_update;
} SmoothWriter;

void init_smooth_writer(SmoothWriter *writer) {
    memset(writer, 0, sizeof(SmoothWriter));
}

void set_smooth_target(SmoothWriter *writer, int target, int immediate) {
    writer->target_value = target;
    if (immediate) {
        writer->current_value = target;
        writer->step = 0;
    } else {
        // Calculate smooth step (15 steps over 500ms)
        int diff = target - writer->current_value;
        writer->step = diff / 15;
        if (writer->step == 0 && diff != 0) {
            writer->step = (diff > 0) ? 1 : -1;
        }
    }
}

int update_smooth_writer(SmoothWriter *writer) {
    if (writer->current_value == writer->target_value) {
        return writer->current_value;
    }
    
    struct timespec ts;
    clock_gettime(CLOCK_MONOTONIC, &ts);
    int now_ms = ts.tv_sec * 1000 + ts.tv_nsec / 1000000;
    
    // Update every 33ms (30fps smooth animation)
    if (now_ms - writer->last_update >= 33) {
        writer->current_value += writer->step;
        
        // Clamp to target
        if ((writer->step > 0 && writer->current_value > writer->target_value) ||
            (writer->step < 0 && writer->current_value < writer->target_value)) {
            writer->current_value = writer->target_value;
        }
        
        writer->last_update = now_ms;
    }
    
    return writer->current_value;
}

// ==================== MAIN ====================
int main() {
    char buf[64];
    SlideDetector slider;
    SmoothWriter writer;
    int auto_mode = 0;
    int last_lux = -1;
    int lux_stable_count = 0;
    
    init_slide_detector(&slider);
    init_smooth_writer(&writer);
    
    // Force manual mode on start (safety)
    system("settings put system screen_brightness_mode 0");
    system("settings put system screen_brightness 128");
    
    while (1) {
        // ========== CHECK AUTO/MANUAL MODE ==========
        FILE *fp = popen(SETTINGS_CMD, "r");
        if (fp) {
            fgets(buf, sizeof(buf), fp);
            int new_auto_mode = atoi(buf);
            pclose(fp);
            
            if (new_auto_mode != auto_mode) {
                auto_mode = new_auto_mode;
                if (auto_mode) {
                    // Switched to auto: read current brightness as baseline
                    int fd = open(BACKLIGHT_PATH, O_RDONLY);
                    if (fd >= 0) {
                        read(fd, buf, sizeof(buf));
                        close(fd);
                        int current = atoi(buf);
                        if (current <= 255) {
                            set_smooth_target(&writer, scale_brightness(current), 1);
                        }
                    }
                }
            }
        }
        
        if (auto_mode == 1) {
            // ========== AUTO-BRIGHTNESS MODE ==========
            int lux_fd = open(LIGHT_SENSOR_PATH, O_RDONLY);
            if (lux_fd >= 0) {
                memset(buf, 0, sizeof(buf));
                read(lux_fd, buf, sizeof(buf)-1);
                close(lux_fd);
                
                int lux = atoi(buf);
                
                // Debounce lux readings
                if (lux == last_lux) {
                    lux_stable_count++;
                } else {
                    lux_stable_count = 0;
                    last_lux = lux;
                }
                
                // Only adjust after stable reading
                if (lux_stable_count >= 10) { // 300ms stable
                    int target_brightness = lux_to_brightness(lux);
                    int target_scaled = scale_brightness(target_brightness);
                    set_smooth_target(&writer, target_scaled, 0);
                }
            }
        } else {
            // ========== MANUAL MODE ==========
            int fd = open(BACKLIGHT_PATH, O_RDONLY);
            if (fd >= 0) {
                memset(buf, 0, sizeof(buf));
                ssize_t bytes = read(fd, buf, sizeof(buf)-1);
                close(fd);
                
                if (bytes > 0) {
                    int current = atoi(buf);
                    
                    if (current >= 0 && current <= 255) {
                        int scaled = scale_brightness(current);
                        int is_sliding = update_slide_detector(&slider, current);
                        
                        if (is_sliding) {
                            // User is sliding: immediate response
                            set_smooth_target(&writer, scaled, 1);
                        } else {
                            // Stable: smooth transition to target
                            set_smooth_target(&writer, scaled, 0);
                        }
                    }
                }
            }
        }
        
        // ========== APPLY BRIGHTNESS ==========
        int output_value = update_smooth_writer(&writer);
        
        // Only write if changed
        if (output_value != slider.last_written) {
            int fd = open(BACKLIGHT_PATH, O_WRONLY);
            if (fd >= 0) {
                snprintf(buf, sizeof(buf), "%d\n", output_value);
                write(fd, buf, strlen(buf));
                close(fd);
                slider.last_written = output_value;
            }
        }
        
        usleep(POLL_DELAY_MS * 1000);
    }
    
    return 0;
}
