    #
    # Copyright (C) 2025 The LineageOS Project
    #
    # SPDX-License-Identifier: Apache-2.0
    #

    # =============================================
    # INHERITANCE (MOST SPECIFIC FIRST)
    # =============================================

    # 1. Inherit from device FIRST (most specific)
    $(call inherit-product, device/freeyond/M5A/device.mk)

    # 2. Inherit core Android components
    $(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
    #$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

    # 3. Enable updating of APEXes
    $(call inherit-product, $(SRC_TARGET_DIR)/product/updatable_apex.mk)

    # 4. A/B partitioning
    $(call inherit-product, $(SRC_TARGET_DIR)/product/virtual_ab_ota.mk)
    $(call inherit-product, $(SRC_TARGET_DIR)/product/virtual_ab_ota/launch_with_vendor_ramdisk.mk)

    # 5. Inherit common LineageOS configurations (LEAST specific)
    $(call inherit-product, vendor/lineage/config/common_full_phone.mk)

    # 1. Inherit from device FIRST (most specific)
    $(call inherit-product, device/freeyond/M5A/device.mk)


    # =============================================
    # Force super image generation despite LineageOS patch
    # =============================================

    PRODUCT_BUILD_SUPER_PARTITION := true
    OVERRIDE_TARGET_FLATTEN_APEX := true


    # =============================================
    # DEVICE-SPECIFIC PROPERTIES (MUST COME AFTER ALL INHERITANCE)
    # =============================================

    # PRODUCT IDENTIFICATION (DEFINE HERE ONLY - REMOVE FROM device.mk)
    PRODUCT_DEVICE := M5A
    PRODUCT_NAME := lineage_M5A
    PRODUCT_BRAND := FreeYond
    PRODUCT_MODEL := 2305003M
    PRODUCT_MANUFACTURER := Chinoe

    # HARDWARE PLATFORM (DEFINE HERE ONLY - REMOVE FROM device.mk)
    TARGET_BOARD_PLATFORM := ums9230
    TARGET_BOOTLOADER_BOARD_NAME := ums9230_1h10

    # GMS CONFIGURATION
    PRODUCT_GMS_CLIENTID_BASE := android-unisoc

    # BUILD FINGERPRINT (CRITICAL FOR BOOT - MUST MATCH EXACTLY)
    PRODUCT_BUILD_PROP_OVERRIDES += \
        PRIVATE_BUILD_DESC="M5A_EEA-user 13 TP1A.220624.014 24443 release-keys"

    BUILD_FINGERPRINT := FreeYond/M5A_EEA/M5A:13/TP1A.220624.014/24443:user/release-keys
