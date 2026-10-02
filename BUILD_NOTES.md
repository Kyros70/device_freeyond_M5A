# FreeYond M5A – LineageOS 20 build: everything we changed

All paths are inside /work/lineage unless stated. Backups of edited files are in /work/*.bak*.

Result: build completed successfully. Output: `out/target/product/M5A/lineage-20.0-20260930-UNOFFICIAL-M5A.zip` (1.5 GB). The build variant in the target-files name is `eng`. Untested on hardware.

## 1. Environment

- Namespace instance: `nsc create --machine_type 32x64 --duration 12h --volume persistent:build:/work:400GB` (server OS is Wolfi, no apt, no wget; curl works).
- Build runs in Docker ubuntu:22.04 with /work mounted. Image saved as `m5a-image` (docker commit).
- Extra packages added to the image: libncurses5, libtinfo5 (old RenderScript clang needs them).
- `build-m5a.sh` changed: source dir /work/lineage, `repo sync -j8`, `CCACHE_DIR=/work/ccache`.
- `/work/build-only.sh` = envsetup + `lunch lineage_M5A-userdebug` + `mka bacon` (no re-sync, so edits are not overwritten). Always use this, not build-m5a.sh.
- Build command:

```
docker rm build
docker run -d --name build --ulimit nofile=65535:65535 -e TZ=UTC \
  -v /work:/work -w /work m5a-image bash /work/build-only.sh
docker logs -f build
```

- Local manifest (.repo/local_manifests/m5a.xml): device/freeyond/M5A, vendor/freeyond/M5A, kernel/freeyond/M5A from github.com/Kyros70.

## 2. Vendor tree: vendor/freeyond/M5A/M5A-vendor.mk

Android 13 rejects these in PRODUCT_COPY_FILES.

- **VINTF (odm):** deleted lines 183-184 (odm/etc/vintf/manifest.xml, odm/etc/vintf/manifest/manifest_kernel.xml). Appended `ODM_MANIFEST_FILES += .../odm/etc/vintf/manifest.xml`. manifest_kernel.xml was dropped. Backup M5A-vendor.mk.bak.
- **VINTF (rest):** deleted every remaining line containing `etc/vintf/` (product compat matrix, system_ext manifest, vendor compat matrix, vendor manifest, all vendor/etc/vintf/manifest/*.xml fragments). These were re-declared in BoardConfig.mk (section 3). Backup M5A-vendor.mk.bak2.
- **Prebuilt APKs:** deleted every line matching `.apk:` (stock apps and overlays, e.g. DreamCamera2, SetupWizard, CaptivePortalLoginFrameworkOverlay). Three .apk.prof lines remain (harmless). Backup .bak3.
- **Symlinks:** deleted 12 lines whose sources are symlinks (build can't copy them): odm/lib/npidevice/libcamcalitest.so, DreamCamera2 libjni_sprd_srlite.so, USCPhotosProvider libjni_sprd_facedetector_provider.so, AIEngineService libtensorflowlite_jni_prebuilt.so / libtextclassifier_hash_prebuilt.so / libtflite_prebuilt.so, ims libn3am_jni.so, vendor/firmware/tsx_data (-> /mnt/vendor/productinfo/wcn/tsx_bt_data.txt), vendor/lib/modules (-> /vendor_dlkm/lib/modules), vendor/lib/npidevice/libnpi_rtc.so, libsensornpi.so, vendor/odm (-> /odm). Backup .bak4. List saved in /work/vendor-check.txt.

## 3. device/freeyond/M5A/BoardConfig.mk

- Appended VINTF declarations: ODM_MANIFEST_FILES, DEVICE_PRODUCT_COMPATIBILITY_MATRIX_FILE, DEVICE_MATRIX_FILE, DEVICE_MANIFEST_FILE (vendor manifest.xml plus one line per fragment in vendor/etc/vintf/manifest/).
- `BOARD_VENDORIMAGE_PARTITION_SIZE`: 805306368 -> 1073741824 (vendor image was 16 MB too big).
- `BOARD_AVB_ENABLE`: true -> false (AVB is already off on the phone).
- `AB_OTA_PARTITIONS`: removed vbmeta, vbmeta_system, vbmeta_vendor, vbmeta_odm, vbmeta_product, vbmeta_system_ext (lines 59-64) and the trailing `\` on the last remaining entry.
- `TARGET_KERNEL_CLANG_VERSION` stays r416183b (kernel needs it). If you ever changed it to r450784d, change it back.
- **VINTF duplicate fix 1 (CAS):** the HAL android.hardware.cas was declared in both /vendor/etc/vintf/manifest.xml and the fragment android.hardware.cas@1.2-service.xml. Deleted the `DEVICE_MANIFEST_FILE += .../manifest/android.hardware.cas@1.2-service.xml` line (line 242). Backup /work/BoardConfig.mk.bak5. A scan of all other fragments against the main manifest found no other duplicate HAL names.
- **VINTF duplicate fix 2 (vendor-ndk):** the build failed with "Duplicated manifest.vendor-ndk.version 33" in /system_ext/etc/vintf/manifest.xml. The stock system_ext manifest contains only a `<vendor-ndk><version>33</version></vendor-ndk>` block, which the build already provides itself. Deleted the `SYSTEM_EXT_MANIFEST_FILES` line from BoardConfig.mk. Backup /work/BoardConfig.mk.bak6.
- Backups of earlier edits: BoardConfig.mk.bak2/3/4.

## 4. device/freeyond/M5A/device.mk, manifest.xml and recovery files

- Deleted the copy line for android.hardware.health@2.0-impl-default.so (file exists nowhere, not on the phone either) and the trailing `\` on the line above. Backup /work/device.mk.bak.
- Created missing files (copied from vendor proprietary lib64) into both recoveryx/ramdisk/system/lib64/ and recoveryx/recovery/system/lib64/: vendor.sprd.hardware.boot@1.2.so, vendor.sprd.hardware.production@1.0.so, and in hw/: android.hardware.boot@1.0-impl-1.2.so.
- **VINTF fix 3 (OPPO engineering HAL):** the build failed with "vendor.oppo.engnative.engineer@1.0::IEngineer/default not declared in FCM <= level 7". device.mk line 133 adds `device/freeyond/M5A/manifest.xml` to DEVICE_MANIFEST_FILE, and that file declared the HAL. Deleted lines 73-77 of device/freeyond/M5A/manifest.xml (the whole `<hal format="hidl">` block for `vendor.oppo.engnative.engineer`). Backup /work/device-manifest.bak2. The proprietary vendor manifest never contained it.

## 5. vendor/freeyond/M5A/Android.bp

`certificate: "PRESIGNED",` -> `presigned: true,` in all 46 android_app_import blocks. Backup /work/Android.bp.bak.

## 6. device/freeyond/M5A/product.prop

Deleted duplicate props: ro.config.alarm_alert, ro.config.notification_sound, ro.config.ringtone (lines 14-16). Backup /work/product.prop.bak.

## 7. Kernel side

- Clang r416183b: cloned LineageOS/android_prebuilts_clang_kernel_linux-x86_clang-r416183b to prebuilts/clang/host/linux-x86/clang-r416183b.
- Kernel toolchain: cloned kyros70/proton-12 (Proton Clang 12.0.0) and placed its contents at kernel/freeyond/M5A/toolchain/ (bin, lib, ...). This folder is in .gitignore and not pushed; recreate it from that repo.
- Kernel Makefile: deleted the line with `Clang with Android --target detected` (the CLANG_TRIPLE check). Backup /work/kernel-Makefile.bak.
- Kernel module builds disabled: renamed 6 files Android.mk -> Android.mk.off under kernel/freeyond/M5A/kernel_modules/ (adaptive-ts, focaltech_spi, adaptive_ts_transsion, synaptics_dsx_td4310, common/camera/vdsp/Ceva, gator/daemon). They wrote .ko files into the read-only kernel source.
- LineageOS file edited: vendor/lineage/build/soong/Android.bp line 24: headers_install command now ends with `&& rm -rf $(genDir)/usr/include/asm $(genDir)/usr/include/asm-generic $(genDir)/usr/include/linux` so 32-bit code uses bionic's own headers. Backup /work/lineage-soong-Android.bp.bak. A repo sync will overwrite this file. Saved as `lineage-soong-headers.patch` in the device repo (apply with `git apply` inside vendor/lineage).

## 8. Known trade-offs (test on the phone)

- Stock apps/overlays from the vendor list are not in the ROM (LineageOS supplies its own camera/setup).
- Symlinked libraries and tsx_data (Bluetooth calibration) not copied: check camera and Bluetooth.
- Kernel modules are not built from source: check touchscreen and other drivers.
- Recovery ramdisk lacks the health HAL (charging screen in recovery).
- odm kernel manifest fragment dropped.
- AVB and all vbmeta images are off.
- Default notification/alarm/ringtone are LineageOS's.
- OPPO engineering HAL (vendor.oppo.engnative.engineer) removed from the device manifest.
- Stock system_ext manifest not used (only carried vendor-ndk 33, which the build supplies).
- CAS fragment (android.hardware.cas@1.2-service) not declared separately; the main vendor manifest declares CAS. If DRM or media playback misbehaves, check the CAS version declared there.
- Target-files name says `eng` although lunch used userdebug.

## 9. Where it stands

Build completed successfully (03:34 for the last incremental run). Package: `out/target/product/M5A/lineage-20.0-20260930-UNOFFICIAL-M5A.zip`, 1.5 GB.

Order of VINTF errors hit and fixed in the final stretch: CAS declared twice, then vendor-ndk 33 duplicated in system_ext, then oppo.engnative HAL missing from the framework matrix.

## 10. Where everything is published

- Release (zip and .sha256): https://github.com/Kyros70/device_freeyond_M5A/releases/tag/v20260930
- Device tree: github.com/Kyros70/device_freeyond_M5A, branch `lineage-20-working` (remote `origin`)
- Vendor tree: github.com/Kyros70/vendor_freeyond_M5A, branch `lineage-20-working` (remote `kyros`)
- Kernel: github.com/Kyros70/android_kernel_ums9230, branch `lineage-20-working` (remote `kyros`)

## 11. Rebuilding from scratch

1. Create the instance and Docker image (section 1), then `repo sync` with the local manifest.
2. Check out branch `lineage-20-working` in the device, vendor and kernel repos.
3. Put Proton Clang 12 from kyros70/proton-12 into kernel/freeyond/M5A/toolchain/, and clang r416183b into prebuilts/clang/host/linux-x86/.
4. Apply lineage-soong-headers.patch inside vendor/lineage.
5. Run `/work/build-only.sh` inside the container.


## 13. Cleanup pass

- Fixed `BOARD_KERNEL_CMDLINE`: the first line lacked the trailing `\`, so `androidboot.hardware=ums9230_1h10`, `androidboot.dtbo_idx=1`, `androidboot.selinux=permissive`, `loop.max_part=7`, `swiotlb=1` were parsed as a junk make variable and never reached the boot image.
- Removed the inert `BOARD_AVB_*` chain (AVB is disabled).
- Removed unreferenced C53 / other-SKU leftovers: rootdir init, bin and system dirs, `unisoc-ims` (disabled Android.bk), `vintf/`, `product/`, old sepolicy copies, unused `prebuilts/*modules*`, `recoveryx/ramdisk/system/{bin,etc}` and `system_old`, RMX3624/hulk/nico ueventd and fstab files, `avb_keys/`, the aospdtgen extract/setup scripts, `proprietary-files.txt` and `releasetools.py`.
- Kept: `rootdir/vendor/etc/fstab.ums9230_1h10` (installed via device.mk) and `fstab.M5A`.
- `.gitignore` reduced to `out/`, editor files.
