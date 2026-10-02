# Copyright (C) 2025 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

# ===========================
# ABSOLUTE MINIMAL CONFIGURATION
# ===========================

# Dalvik VM Configuration
$(call inherit-product, frameworks/native/build/phone-xhdpi-4096-dalvik-heap.mk)

# Essential for A/B updates
$(call inherit-product, $(SRC_TARGET_DIR)/product/virtual_ab_ota/launch_with_vendor_ramdisk.mk)

# Core product (add these)
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/aosp_base_telephony.mk)


PRODUCT_OTA_ENFORCE_VINTF_KERNEL_REQUIREMENTS := false


PRODUCT_PACKAGES += lib_android_keymaster_keymint_utils


PRODUCT_SHIPPING_API_LEVEL := 33
PRODUCT_USE_DYNAMIC_PARTITIONS := true

# Soong Configuration
SOONG_CONFIG_NAMESPACES += freeyond_M5A
SOONG_CONFIG_freeyond_M5A += use_vendor_bp
SOONG_CONFIG_freeyond_M5A_use_vendor_bp := true

PRODUCT_SOONG_NAMESPACES += \
    device/freeyond/M5A \
    vendor/freeyond/M5A \


# disable usb temp for debug
# PRODUCT_PROPERTY_OVERRIDES += \
    persist.vendor.sys.usb.config=adb \
    sys.usb.configfs=0 \
    ro.vendor.usb.use_configfs=0


# Enable root access
# PRODUCT_SYSTEM_DEFAULT_PROPERTIES += \
    ro.secure=0 \
    ro.adb.secure=0

PRODUCT_PACKAGES += lib_android_keymaster_keymint_utils



PRODUCT_PACKAGES += \
    sprd_brightness_fix


# =============================================
# BOOT & A/B UPDATE PACKAGES
# =============================================
PRODUCT_PACKAGES += \
    android.hardware.boot@1.2-impl \
    android.hardware.boot@1.2-impl.recovery \
    android.hardware.boot@1.2-service
    

# =============================================
# HEALTH HAL
# =============================================
PRODUCT_PACKAGES += \
    android.hardware.health@2.1-impl \
    android.hardware.health-service.example

# =============================================
# A/B UPDATE ENGINE
# =============================================
PRODUCT_PACKAGES += \
    update_engine \
    update_engine_sideload \
    update_verifier \
    checkpoint_gc \
    otapreopt_script

# =============================================
# FASTBOOT
# =============================================
PRODUCT_PACKAGES += \
    android.hardware.fastboot@1.1-impl-mock \
    fastbootd

PRODUCT_PACKAGES += \
    ims
    #unisoc-ims-common 

# ===========================
# MINIMAL STORAGE FIX - ADD ONLY THESE 4 LINES
# ===========================
PRODUCT_PROPERTY_OVERRIDES += \
    persist.sys.usb.config=mtp,adb


# ===========================
# gapps deps
# ===========================
PRODUCT_OPTIONAL_USES_LIBRARIES += \
    org.apache.http.legacy \
    androidx.window.extensions \
    androidx.window.sidecar

PRODUCT_BROKEN_VERIFY_USES_LIBRARIES := true




# Unisoc telephony framework integration
# PRODUCT_VENDOR_BOOT_JARS += \
    radio_interactor_common \
    unisoc_ims_common \
    unisoc-services \
    unisoc-framework \
    com.unisoc.sdk.common \
    uni-telephony-common


# ===========================
# VINTF CONFIGURATION - MINIMAL
# ===========================
DEVICE_MANIFEST_FILE += device/freeyond/M5A/manifest.xml
PRODUCT_ENFORCE_VINTF_MANIFEST := true

# KEEP ONLY WORKING MANIFESTS - REMOVE FAILING ONES
# 10-11-25 DEVICE_MANIFEST_FILE += \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.drm-service.clearkey.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.wifi.hostapd.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.wifi.supplicant.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/lights.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/vibrator.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.gatekeeper@1.0-service.trusty.xml\
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.health-service.example.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/vendor-power-default.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.security.keymint@2.0-unisoc.service.trusty.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/vendor.sprd.hardware.boot@1.2.xml \
    vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.thermal@2.0-service.xml  


  #  vendor/freeyond/M5A/proprietary/vendor/etc/vintf/manifest/android.hardware.biometrics.fingerprint@2.1-service.xml \


# ===========================
# RECOVERY CONFIGURATION
# ===========================
PRODUCT_PACKAGES += \
    adbd.recovery \
    android.hardware.fastboot@1.0-impl-mock \
    fastbootd

# ===========================
# ADB & Fastboot Configuration
# ===========================
# PRODUCT_SYSTEM_PROPERTIES += \
    persist.sys.usb.config=adb \
    sys.usb.controller=ffs-umc \
    sys.usb.configfs=1 \
    sys.usb.ffs.ready=1



PRODUCT_PACKAGES += \
    update_engine \
    update_engine_sideload \
    update_verifier

AB_OTA_POSTINSTALL_CONFIG += \
    RUN_POSTINSTALL_system=true \
    POSTINSTALL_PATH_system=system/bin/otapreopt_script \
    FILESYSTEM_TYPE_system=ext4 \
    POSTINSTALL_OPTIONAL_system=true

AB_OTA_POSTINSTALL_CONFIG += \
    RUN_POSTINSTALL_vendor=true \
    POSTINSTALL_PATH_vendor=bin/checkpoint_gc \
    FILESYSTEM_TYPE_vendor=ext4 \
    POSTINSTALL_OPTIONAL_vendor=true

PRODUCT_PACKAGES += \
    checkpoint_gc \
    otapreopt_script

# ===========================
# VENDOR BLOBS + gapps
# ===========================
$(call inherit-product, vendor/freeyond/M5A/M5A-vendor.mk)
#$(call inherit-product, vendor/gapps/arm64/arm64-vendor.mk)


# ===========================
# DEVICE TREE BLOBS
# ===========================
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/prebuilts/dtb.img:$(TARGET_COPY_OUT)/dtb.img

# ===========================
# PLATFORM CONFIGURATION
# ===========================
ifneq ($(TARGET_BOARD_PLATFORM),)
PRODUCT_PLATFORM := ums9230
endif


# ===========================
# TEMPORARY SELINUX PERMISSIVE
# ===========================
BOARD_KERNEL_CMDLINE += androidboot.selinux=permissive
PRODUCT_PROPERTY_OVERRIDES += ro.boot.selinux=permissive


# Rootdir: init scripts, fstabs and scripts come from the stock vendor image (vendor_freeyond_M5A)

# Live-verified fstab for ums9230_1h10 (no FBE on /data), replaces the stock one from the vendor repo
PRODUCT_COPY_FILES += \
    $(LOCAL_PATH)/rootdir/vendor/etc/fstab.ums9230_1h10:$(TARGET_COPY_OUT_VENDOR)/etc/fstab.ums9230_1h10



#$(call inherit-product, vendor/gapps/arm64/arm64-vendor.mk)

# ==================================================
# GApps Configuration
# ==================================================

# Filter out AOSP packages that conflict with GApps
# PRODUCT_PACKAGES := $(filter-out Provision,$(PRODUCT_PACKAGES))
# PRODUCT_PACKAGES := $(filter-out CalendarProvider,$(PRODUCT_PACKAGES))
# PRODUCT_PACKAGES := $(filter-out ContactsProvider,$(PRODUCT_PACKAGES))
# PRODUCT_PACKAGES := $(filter-out ExtServices,$(PRODUCT_PACKAGES))
# PRODUCT_PACKAGES := $(filter-out Markup,$(PRODUCT_PACKAGES))
# PRODUCT_PACKAGES := $(filter-out QuickSearchBox,$(PRODUCT_PACKAGES))
# PRODUCT_PACKAGES := $(filter-out SetupWizard,$(PRODUCT_PACKAGES))  


# GApps properties
#PRODUCT_SYSTEM_DEFAULT_PROPERTIES += \
    ro.com.google.gmsversion=13 \
    ro.media.extensionprovider=google \
    ro.config.media_provider=google \
    ro.setupwizard.require_network=any \
    ro.setupwizard.mode=OPTIONAL



# ===========================
# Files for NORMAL boot (ramdisk.cpio)
# ===========================

# ===========================
# VENDOR RAMDISK - COMPLETE SETUP
# ===========================

# Copy entire system folder with all files
PRODUCT_COPY_FILES += \
    $(call find-copy-subdir-files,*,device/freeyond/M5A/recoveryx/ramdisk/system,$(TARGET_COPY_OUT_VENDOR_RAMDISK)/system)


# Vendor HALs for normal boot
PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/ramdisk/system/lib64/vendor.sprd.hardware.boot@1.2.so:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/system/lib64/vendor.sprd.hardware.boot@1.2.so \
      $(LOCAL_PATH)/recoveryx/ramdisk/system/lib64/vendor.sprd.hardware.production@1.0.so:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/system/lib64/vendor.sprd.hardware.production@1.0.so \
      $(LOCAL_PATH)/recoveryx/ramdisk/system/lib64/hw/android.hardware.boot@1.0-impl-1.2.so:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/system/lib64/hw/android.hardware.boot@1.0-impl-1.2.so

# Essential modules for normal boot
NORMAL_MODULES := $(wildcard   $(LOCAL_PATH)/recoveryx/ramdisk/lib/modules/*.ko)
PRODUCT_COPY_FILES += $(foreach file,$(NORMAL_MODULES),\
    $(file):$(TARGET_COPY_OUT_VENDOR_RAMDISK)/lib/modules/$(notdir $(file)))

PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/ramdisk/lib/modules/modules.alias:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/lib/modules/modules.alias \
      $(LOCAL_PATH)/recoveryx/ramdisk/lib/modules/modules.dep:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/lib/modules/modules.dep \
      $(LOCAL_PATH)/recoveryx/ramdisk/lib/modules/modules.load:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/lib/modules/modules.load \


# All ueventd files for ramdisk.cpio
PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.module.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.module.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.M5A.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.M5A.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_1h10.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_1h10.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_1h10_go.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_1h10_go.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_4h10.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_4h10.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_4h10_go.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_4h10_go.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_6h10.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_6h10.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_7h10.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_7h10.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_haps.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_haps.rc \
      $(LOCAL_PATH)/recoveryx/ramdisk/ueventd.ums9230_zebu.rc:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/ueventd.ums9230_zebu.rc

# All fstab files for first stage ramdisk
PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.module:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.module \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.M5A:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.M5A \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_1h10:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_1h10 \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_1h10_go:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_1h10_go \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_4h10:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_4h10 \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_4h10_go:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_4h10_go \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_6h10:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_6h10 \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_7h10:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_7h10 \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_haps:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_haps \
      $(LOCAL_PATH)/recoveryx/ramdisk/first_stage_ramdisk/fstab.ums9230_zebu:$(TARGET_COPY_OUT_VENDOR_RAMDISK)/first_stage_ramdisk/fstab.ums9230_zebu

# ===========================
# Files for RECOVERY boot (recovery.cpio)
# ===========================
# Recovery init script


PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/recovery/lib/modules/modules.alias:$(TARGET_COPY_OUT_RECOVERY)/root/lib/modules/modules.alias \
      $(LOCAL_PATH)/recoveryx/recovery/lib/modules/modules.dep:$(TARGET_COPY_OUT_RECOVERY)/root/lib/modules/modules.dep \
      $(LOCAL_PATH)/recoveryx/recovery/lib/modules/modules.load:$(TARGET_COPY_OUT_RECOVERY)/root/lib/modules/modules.load \
      $(LOCAL_PATH)/recoveryx/recovery/lib/modules/modules.load.recovery:$(TARGET_COPY_OUT_RECOVERY)/root/lib/modules/modules.load.recovery \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.module.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.module.rc

# Vendor HALs for recovery
PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/recovery/system/lib64/vendor.sprd.hardware.boot@1.2.so:$(TARGET_COPY_OUT_RECOVERY)/root/system/lib64/vendor.sprd.hardware.boot@1.2.so \
      $(LOCAL_PATH)/recoveryx/recovery/system/lib64/vendor.sprd.hardware.production@1.0.so:$(TARGET_COPY_OUT_RECOVERY)/root/system/lib64/vendor.sprd.hardware.production@1.0.so \
      $(LOCAL_PATH)/recoveryx/recovery/system/lib64/hw/android.hardware.boot@1.0-impl-1.2.so:$(TARGET_COPY_OUT_RECOVERY)/root/system/lib64/hw/android.hardware.boot@1.0-impl-1.2.so

# All modules for recovery
RECOVERY_MODULES := $(wildcard   $(LOCAL_PATH)/recoveryx/recovery/lib/modules/*.ko)
PRODUCT_COPY_FILES += $(foreach file,$(RECOVERY_MODULES),\
    $(file):$(TARGET_COPY_OUT_RECOVERY)/root/lib/modules/$(notdir $(file)))


PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/recovery/init.recovery.common.rc:$(TARGET_COPY_OUT_RECOVERY)/root/init.recovery.common.rc \

# All ueventd files for recovery.cpio
PRODUCT_COPY_FILES += \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.module.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.module.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.M5A.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.M5A.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_1h10.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_1h10.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_1h10_go.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_1h10_go.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_4h10.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_4h10.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_4h10_go.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_4h10_go.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_6h10.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_6h10.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_7h10.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_7h10.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_haps.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_haps.rc \
      $(LOCAL_PATH)/recoveryx/recovery/ueventd.ums9230_zebu.rc:$(TARGET_COPY_OUT_RECOVERY)/root/ueventd.ums9230_zebu.rc



