#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/inotify.h>

#define BACKLIGHT_PATH "/sys/class/backlight/sprd_backlight/brightness"
#define LOG_TAG "SPRD-Brightness-Fix"

// Scale 0-255 → 1-4095
static int scale_brightness(int android_val) {
    if (android_val == 0) return 1;
    if (android_val == 255) return 4095;
    return 1 + (android_val * 4094) / 255;
}

int main() {
    int fd;
    char buf[32];
    
    // Fix initial brightness
    fd = open(BACKLIGHT_PATH, O_RDONLY);
    if (fd >= 0) {
        read(fd, buf, sizeof(buf));
        close(fd);
        
        int current = atoi(buf);
        if (current <= 255) {
            int scaled = scale_brightness(current);
            fd = open(BACKLIGHT_PATH, O_WRONLY);
            if (fd >= 0) {
                snprintf(buf, sizeof(buf), "%d\n", scaled);
                write(fd, buf, strlen(buf));
                close(fd);
            }
        }
    }
    
    // Monitor forever
    while (1) {
        fd = open(BACKLIGHT_PATH, O_RDONLY);
        if (fd >= 0) {
            memset(buf, 0, sizeof(buf));
            read(fd, buf, sizeof(buf)-1);
            close(fd);
            
            int current = atoi(buf);
            if (current <= 255 && current >= 0) {
                int scaled = scale_brightness(current);
                if (current != scaled) {
                    fd = open(BACKLIGHT_PATH, O_WRONLY);
                    if (fd >= 0) {
                        snprintf(buf, sizeof(buf), "%d\n", scaled);
                        write(fd, buf, strlen(buf));
                        close(fd);
                    }
                }
            }
        }
        usleep(10000); // 10ms polling
    }
    
    return 0;
}