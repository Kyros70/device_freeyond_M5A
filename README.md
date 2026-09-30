# LineageOS Device Tree for FreeYond M5A

Forked from [cooked71's RE58C2 (Realme C53)](https://github.com/cooked71/device_RE58C2_WORKING) device tree and adapted for the FreeYond M5A (Unisoc UMS9230 / T606).

## Device Specs
- **SoC:** Unisoc UMS9230 (T606)
- **RAM:** 8GB
- **Storage:** 256GB
- **Display:** 1612x720 IPS
- **Bootloader:** Unisoc proprietary (U-Boot)
- **Recovery:** TWRP/OFRP By Kyros70
- **Partitioning:** A/B with Virtual A/B

## Build Prerequisites
- Linux environment (Ubuntu 20.04+ recommended)
- AOSP/LineageOS build tools
- M5A vendor blobs (extract from stock ROM or device)
- M5A stable kernel from [android_kernel_ums9230](https://github.com/Kyros70/android_kernel_ums9230)

## Setup
```bash
# In your AOSP/LineageOS source tree:
git clone https://github.com/Kyros70/device_freeyond_M5A device/freeyond/M5A
git clone https://github.com/Kyros70/android_kernel_ums9230 kernel/freeyond/M5A

# Extract vendor blobs
cd device/freeyond/M5A
./extract-files.sh <path-to-M5A-rom-or-device>
```

## Build
```bash
source build/envsetup.sh
lunch lineage_M5A-userdebug
m -j$(nproc)
```

## Notes
- **Kernel:** Uses M5A stable 5.4.254 with ReSukiSU/KernelSU support
- **AVB:** Per-partition vbmeta chain (system+system_ext, vendor, odm, product, system_ext→vendor_dlkm)
- **Recovery:** Dual CPIO init_boot + recovery in vendor_boot v4
- **VINTF:** Requires vendor compatibility matrix; CONFIG_SYSVIPC must be unset in kernel

## Credits
- [cooked71](https://github.com/cooked71) — RE58C2 device tree and TWRP recovery
- Unisoc/Sprd community — kernel and hardware enablement
- LineageOS project

## License
Apache License 2.0 (see LICENSE file)
