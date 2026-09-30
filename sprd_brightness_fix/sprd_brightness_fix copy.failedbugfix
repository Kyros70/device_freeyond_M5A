// sprd_brightness_fix.c - FINAL VERSION
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define BACKLIGHT_PATH "/sys/class/backlight/sprd_backlight/brightness"
#define LIGHT_SENSOR_PATH "/sys/class/sprd_sensorhub/sensor_hub/raw_data_als"
#define POLL_DELAY_MS 50

// ==================== KERNEL BUG WORKAROUND ====================
// Kernel mapping discovered from tests:
// 0 → 3452 (BUG!)           - Never write 0!
// 1-240 → value × 16        - Gets multiplied
// 260-4095 → value × 1      - Direct mapping
// 241-259 → ???             - Transition zone, avoid!
// ==============================================================

int workaround_kernel_bug(int target_brightness) {
    // target_brightness: desired kernel brightness (0-4095)
    // Returns: what to actually write to /sys/class/backlight/sprd_backlight/brightness
    
    if (target_brightness == 0) {
        return 1;  // Never write 0 due to kernel bug
    }
    
    if (target_brightness <= 3840) {  // 240 × 16
        // In ×16 range: write target/16
        int write_val = (target_brightness + 8) / 16;  // Round to nearest
        if (write_val > 240) write_val = 240;  // Clamp to max ×16 range
        return write_val;
    }
    else if (target_brightness < 260) {
        // Avoid transition zone (241-259)
        // Jump to safe 1:1 range
        return 260;
    }
    else {
        // In 1:1 range
        if (target_brightness > 4095) target_brightness = 4095;
        return target_brightness;
    }
}

// ==================== SCALING FUNCTIONS ====================
int android_to_target(int android_val) {
    // Android 0-255 → Desired kernel brightness 0-4095
    if (android_val == 0) return 0;
    if (android_val == 255) return 4095;
    return (android_val * 4095) / 255;
}

int target_to_android(int kernel_val) {
    // Kernel brightness 0-4095 → Android 0-255
    if (kernel_val == 0) return 0;
    if (kernel_val == 4095) return 255;
    return (kernel_val * 255) / 4095;
}

// ==================== AUTO-BRIGHTNESS ====================
int lux_to_android(int lux) {
    // Convert lux to Android brightness (0-255)
    if (lux < 10) return 20;
    if (lux < 50) return 40;
    if (lux < 100) return 60;
    if (lux < 200) return 80;
    if (lux < 500) return 120;
    if (lux < 1000) return 160;
    if (lux < 3000) return 200;
    return 255;
}

// ==================== SLIDE DETECTION ====================
typedef struct {
    int last_value;
    int last_change_time;
    int is_sliding;
    int slide_timeout;
} SlideDetector;

void init_slide_detector(SlideDetector *det) {
    memset(det, 0, sizeof(SlideDetector));
    det->last_value = -1;
}

int update_slide_detector(SlideDetector *det, int current_value) {
    struct timespec ts;
    clock_gettime(CLOCK_MONOTONIC, &ts);
    int now_ms = ts.tv_sec * 1000 + ts.tv_nsec / 1000000;
    
    if (det->last_value != -1) {
        int diff = abs(current_value - det->last_value);
        int time_diff = now_ms - det->last_change_time;
        
        // Rapid changes = user sliding
        if (diff > 5 && time_diff < 300) {
            det->is_sliding = 1;
            det->slide_timeout = 40;  // 1.2 seconds
        }
        
        if (diff > 0) {
            det->last_change_time = now_ms;
        }
    }
    
    det->last_value = current_value;
    
    if (det->is_sliding) {
        det->slide_timeout--;
        if (det->slide_timeout <= 0) {
            det->is_sliding = 0;
            return 0; // Slide ended
        }
        return 1; // Still sliding
    }
    
    return 0; // Not sliding
}

// ==================== MAIN ====================
int main() {
    char buf[64];
    SlideDetector slider;
    int auto_mode = 0;
    int last_written = -1;
    int stable_count = 0;
    
    init_slide_detector(&slider);
    
    // Initial safe brightness
    system("settings put system screen_brightness 128");
    system("settings put system screen_brightness_mode 0");
    
    while (1) {
        // ========== CHECK AUTO/MANUAL MODE ==========
        FILE *fp = popen("settings get system screen_brightness_mode", "r");
        if (fp) {
            fgets(buf, sizeof(buf), fp);
            auto_mode = atoi(buf);
            pclose(fp);
        }
        
        if (auto_mode == 1) {
            // ========== AUTO-BRIGHTNESS MODE ==========
            int lux_fd = open(LIGHT_SENSOR_PATH, O_RDONLY);
            if (lux_fd >= 0) {
                memset(buf, 0, sizeof(buf));
                read(lux_fd, buf, sizeof(buf)-1);
                close(lux_fd);
                
                int lux = atoi(buf);
                int android_brightness = lux_to_android(lux);
                int target = android_to_target(android_brightness);
                int write_val = workaround_kernel_bug(target);
                
                // Write to kernel
                if (write_val != last_written) {
                    int fd = open(BACKLIGHT_PATH, O_WRONLY);
                    if (fd >= 0) {
                        snprintf(buf, sizeof(buf), "%d\n", write_val);
                        write(fd, buf, strlen(buf));
                        close(fd);
                        last_written = write_val;
                    }
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
                    
                    // If value is in Android range (0-255), process it
                    if (current >= 0 && current <= 255) {
                        int target = android_to_target(current);
                        int write_val = workaround_kernel_bug(target);
                        
                        // Check if user is sliding
                        int is_sliding = update_slide_detector(&slider, current);
                        
                        if (is_sliding) {
                            // During slide: write immediately for responsiveness
                            stable_count = 0;
                        } else {
                            // Not sliding: debounce
                            if (write_val == last_written) {
                                stable_count++;
                            } else {
                                stable_count = 0;
                            }
                        }
                        
                        // Write if sliding OR stable for 200ms
                        if (is_sliding || stable_count >= 4) {
                            if (write_val != last_written) {
                                fd = open(BACKLIGHT_PATH, O_WRONLY);
                                if (fd >= 0) {
                                    snprintf(buf, sizeof(buf), "%d\n", write_val);
                                    write(fd, buf, strlen(buf));
                                    close(fd);
                                    last_written = write_val;
                                }
                            }
                            if (!is_sliding) stable_count = 0;
                        }
                    }
                }
            }
        }
        
        usleep(POLL_DELAY_MS * 1000);
    }
    
    return 0;
}