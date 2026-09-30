package com.android.ims.internal;

import android.R;
import android.content.Context;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.UniCarrierConfigManager;
import android.util.Log;
import com.android.ims.internal.IImsServiceEx;
import com.android.ims.internal.IImsUtEx;

/* loaded from: classes.dex */
public class ImsManagerEx {
    public static final String EVENT_IMS_VIDEO_CALL_SCREEN_INTERACTION = "event_ims_video_call_screen_interaction";
    public static final String EXTRA_IMS_CONFERENCE_PARTICIPANTS = "android.intent.extra.IMS_CONFERENCE_PARTICIPANTS";
    public static final String EXTRA_IMS_CONFERENCE_REQUEST = "android.intent.extra.IMS_CONFERENCE_REQUEST";
    public static final int HANDOVER_CANCELED = 3;
    public static final int HANDOVER_COMPLETED = 1;
    public static final int HANDOVER_FAILED = 2;
    public static final int HANDOVER_STARTED = 0;
    public static final int IMS_CALL_EVENT = 200;
    public static final int IMS_CALL_EVENT_CONF_CANT_INVITE = 215;
    public static final int IMS_CALL_EVENT_CONF_CANT_MERGE_MORE = 219;
    public static final int IMS_CALL_EVENT_CONF_CONNECT_TIME_OUT = 207;
    public static final int IMS_CALL_EVENT_CONF_DISCONNECT = 208;
    public static final int IMS_CALL_EVENT_CONF_FINISHED = 209;
    public static final int IMS_CALL_EVENT_CONF_INVITE_FAILED = 211;
    public static final int IMS_CALL_EVENT_CONF_INVITE_REQUEST_FAILED = 210;
    public static final int IMS_CALL_EVENT_CONF_NONE_PARTICIPANT = 213;
    public static final int IMS_CALL_EVENT_CONF_NOT_SUPPORT = 214;
    public static final int IMS_CALL_EVENT_CONF_PARTICIPANT_REMOVE_FAILED = 212;
    public static final int IMS_CALL_EVENT_CONF_VOWIFI_CALL_FAILED = 217;
    public static final int IMS_CALL_EVENT_CONF_VOWIFI_CALL_RETRY = 216;
    public static final int IMS_CALL_EVENT_RTT_CALL_DOWNGRADE = 218;
    public static final int IMS_CALL_EVENT_SHOW_LOW_BATTERY_DIALOG = 206;
    public static final int IMS_CALL_EVENT_UPGRADE_REQUEST_ACCEPTED = 202;
    public static final int IMS_CALL_EVENT_UPGRADE_REQUEST_REJECTED = 203;
    public static final int IMS_CALL_EVENT_UPGRADE_REQUEST_TIME_OUT = 201;
    public static final int IMS_CALL_EVENT_VIDEO_CAMERA_OPEN_FAILED = 205;
    public static final int IMS_CALL_EVENT_VIDEO_DOWNGRADE = 204;
    public static final String IMS_CALL_EXTRA_CALL_INDEX = "ims_call_index";
    public static final String IMS_CALL_EXTRA_CALL_RTT_CPS = "ims_call_rtt_cps";
    public static final String IMS_CALL_EXTRA_CVAT_VIDEO = "ims_call_extra_cvat_video";
    public static final String IMS_CALL_EXTRA_CVAT_VOICE = "ims_call_extra_cvat_voice";
    public static final String IMS_CALL_EXTRA_CVRS_VIDEO = "ims_call_extra_cvrs_video";
    public static final String IMS_CALL_EXTRA_CVRS_VOICE = "ims_call_extra_cvrs_voice";
    public static final String IMS_CALL_EXTRA_DIGITS = "ims_call_extra_digits";
    public static final int IMS_CALL_EXTRA_EVENT_MOVE = 2;
    public static final int IMS_CALL_EXTRA_EVENT_TOUCH = 1;
    public static final String IMS_CALL_EXTRA_EVENT_TYPE = "ims_call_extra_event_type";
    public static final String IMS_CALL_EXTRA_FUNCTION_FLAG = "ims_call_extra_function_flag";
    public static final String IMS_CALL_EXTRA_MT_CONFERENCE = "ims_mt_conf";
    public static final String IMS_CALL_EXTRA_NOTIFY_TYPE = "ims_call_extra_notify_type";
    public static final String IMS_CALL_EXTRA_REJECT_REASON = "ims_call_extra_reject_reason";
    public static final String IMS_CALL_EXTRA_REJECT_TEXT = "ims_call_extra_reject_text";
    public static final String IMS_CALL_EXTRA_SCREEN_INTERACTION_CAP = "ims_call_extra_screen_interaction_cap";
    public static final String IMS_CALL_EXTRA_SCREEN_INTERACTION_CAP_ACK = "ims_call_extra_screen_interaction_cap_ack";
    public static final String IMS_CALL_EXTRA_SCREEN_SHARE_SURFACE = "ims_call_extra_screen_share_surface";
    public static final String IMS_CALL_EXTRA_TOUCH_DURATION = "ims_call_extra_touch_duration";
    public static final String IMS_DOZE_MANAGER = "ims_doze_manager";
    public static final int IMS_PDN_ACTIVE_FAILED = 0;
    public static final int IMS_PDN_READY = 1;
    public static final int IMS_PDN_START = 2;
    public static final int IMS_REGISTERED = 1;
    public static final int IMS_REGISTER_EVENT = 100;
    public static final int IMS_REGISTER_EVENT_DISMISS_VOWIFI_NOTIFICATION = 103;
    public static final int IMS_REGISTER_EVENT_RTT_OPERATE_FAILED_NOTIFICATION = 104;
    public static final int IMS_REGISTER_EVENT_SHOW_VOWIFI_NOTIFICATION = 101;
    public static final int IMS_REGISTER_EVENT_VOWIFI_HANDOVER_TO_VOLTE = 102;
    public static final String IMS_SERVICE_EX = "ims_ex";
    public static final int IMS_SS_EVENT = 300;
    public static final int IMS_UNREGISTERED = 0;
    public static final String IMS_UT_EX = "ims_ut_ex";
    private static final String LTE_LTE_4M = "TL_LF_W_G,TL_LF_W_G";
    private static final String LTE_LTE_5M = "TL_LF_TD_W_G,TL_LF_TD_W_G";
    private static final String MODEM_CONFIG_PROP = "persist.vendor.radio.modem.config";
    public static final String PROPERTY_SINGLE_IMS_STACK = "persist.vendor.sys.single.imsstack";
    private static final int SUB_PROPERTY_NOT_INITIALIZED = -1;
    private static final String TAG = "ImsManagerEx";

    public static IImsServiceEx getIImsServiceEx() {
        IBinder b = ServiceManager.getService(IMS_SERVICE_EX);
        if (b == null) {
            return null;
        }
        IImsServiceEx service = IImsServiceEx.Stub.asInterface(b);
        return service;
    }

    public static IImsUtEx getIImsUtEx() {
        IBinder b = ServiceManager.getService(IMS_UT_EX);
        if (b == null) {
            return null;
        }
        IImsUtEx service = IImsUtEx.Stub.asInterface(b);
        return service;
    }

    public static boolean isDualVoLTERegistered() {
        String mSimConfig = SystemProperties.get("gsm.sys.volte.state");
        if (mSimConfig != null) {
            String[] states = mSimConfig.split(",");
            int count = 0;
            for (String str : states) {
                if (str.equals("1")) {
                    count++;
                }
            }
            if (count >= 2) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isVoLTERegisteredForPhone(int phoneId) {
        String mSimConfig;
        if (!SubscriptionManager.isValidPhoneId(phoneId) || (mSimConfig = SystemProperties.get("gsm.sys.volte.state")) == null) {
            return false;
        }
        if (phoneId == 0) {
            return mSimConfig.startsWith("1");
        }
        if (phoneId == 1) {
            return mSimConfig.endsWith(",1");
        }
        return false;
    }

    public static boolean isImsRegisteredForPhone(int phoneId) {
        boolean zEndsWith;
        boolean zEndsWith2;
        boolean isVolteRegistered = false;
        boolean isVoWifiRegistered = false;
        if (!SubscriptionManager.isValidPhoneId(phoneId)) {
            return false;
        }
        String mVolteState = SystemProperties.get("gsm.sys.volte.state");
        if (mVolteState != null) {
            if (phoneId == 0) {
                zEndsWith2 = mVolteState.startsWith("1");
            } else {
                zEndsWith2 = phoneId == 1 ? mVolteState.endsWith(",1") : false;
            }
            isVolteRegistered = zEndsWith2;
        }
        String mVoWifiState = SystemProperties.get("gsm.sys.vowifi.state");
        if (mVoWifiState != null) {
            if (phoneId == 0) {
                zEndsWith = mVoWifiState.startsWith("1");
            } else {
                zEndsWith = phoneId == 1 ? mVoWifiState.endsWith(",1") : false;
            }
            isVoWifiRegistered = zEndsWith;
        }
        return isVolteRegistered || isVoWifiRegistered;
    }

    public static boolean isVoWiFiRegisteredForPhone(int phoneId) {
        String voWifiState;
        if (!SubscriptionManager.isValidPhoneId(phoneId) || (voWifiState = SystemProperties.get("gsm.sys.vowifi.state")) == null) {
            return false;
        }
        if (phoneId == 0) {
            return voWifiState.startsWith("1");
        }
        if (phoneId == 1) {
            return voWifiState.endsWith(",1");
        }
        return false;
    }

    public static boolean isDualLteModem() {
        return SystemProperties.get(MODEM_CONFIG_PROP).equals(LTE_LTE_5M) || SystemProperties.get(MODEM_CONFIG_PROP).equals(LTE_LTE_4M);
    }

    public static void notifyVideoCapabilityChange() {
        try {
            if (getIImsServiceEx() != null) {
                getIImsServiceEx().notifyVideoCapabilityChange();
            }
        } catch (RemoteException e) {
        }
    }

    public static boolean isVolteEnabledByPlatform(Context context) {
        return context != null && context.getResources().getBoolean(R.bool.config_cecSystemAudioControlEnabled_allowed) && getBooleanCarrierConfig("carrier_volte_available_bool", context) && SystemProperties.getBoolean("persist.vendor.sys.volte.enable", false);
    }

    public static boolean isWfcEnabledByPlatform(Context context) {
        return context != null && context.getResources().getBoolean(R.bool.config_cecSystemAudioControl_userConfigurable) && getBooleanCarrierConfig("carrier_wfc_ims_available_bool", context);
    }

    public static boolean isWfcEnabledByUser(Context context) {
        int setting = SubscriptionManager.getIntegerSubscriptionProperty(SubscriptionManager.getDefaultDataSubscriptionId(), "wfc_ims_enabled", -1, context);
        if (setting == -1) {
            return getBooleanCarrierConfig("carrier_default_wfc_ims_enabled_bool", context);
        }
        return setting == 1;
    }

    public static void setWfcSetting(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Settings.Global.putInt(context.getContentResolver(), "wfc_ims_enabled", z ? 1 : 0);
        SubscriptionManager.setSubscriptionProperty(SubscriptionManager.getDefaultDataSubscriptionId(), "wfc_ims_enabled", booleanToPropertyString(z));
    }

    private static boolean getBooleanCarrierConfig(String key, Context context) {
        int subId = SubscriptionManager.getDefaultDataSubscriptionId();
        return getBooleanCarrierConfig(key, context, subId);
    }

    private static boolean getBooleanCarrierConfig(String key, Context context, int subId) {
        CarrierConfigManager configManager = (CarrierConfigManager) context.getSystemService("carrier_config");
        PersistableBundle b = null;
        if (configManager != null) {
            b = configManager.getConfigForSubId(subId);
        }
        if (b != null) {
            return b.getBoolean(key);
        }
        return CarrierConfigManager.getDefaultConfig().getBoolean(key);
    }

    private static boolean getBooleanUniCarrierConfig(String key, Context context, int subId) {
        if (context == null || !isSubIdValid(subId)) {
            return true;
        }
        UniCarrierConfigManager uniConfigManager = new UniCarrierConfigManager(context);
        PersistableBundle b = uniConfigManager.getConfigForSubId(subId);
        if (b != null) {
            return b.getBoolean(key);
        }
        return UniCarrierConfigManager.getDefaultConfig().getBoolean(key);
    }

    public static boolean isEnhanced4gLteModeSettingEnabledByUser(Context context) {
        if (context == null) {
            return false;
        }
        int setting = SubscriptionManager.getIntegerSubscriptionProperty(SubscriptionManager.getDefaultDataSubscriptionId(), "volte_vt_enabled", -1, context);
        boolean onByDefault = getBooleanCarrierConfig("enhanced_4g_lte_on_by_default_bool", context);
        if (!getBooleanCarrierConfig("editable_enhanced_4g_lte_bool", context) || setting == -1) {
            return onByDefault;
        }
        if (setting != 1) {
            return false;
        }
        return true;
    }

    private static String booleanToPropertyString(boolean bool) {
        return bool ? "1" : "0";
    }

    public static boolean synSettingForWFCandVoLTE(Context context) {
        int subId = SubscriptionManager.getDefaultDataSubscriptionId();
        return synSettingForWFCandVoLTE(context, subId);
    }

    public static boolean synSettingForWFCandVoLTE(Context context, int subId) {
        boolean isSynSettingForWFCandVoLTE = getBooleanUniCarrierConfig("synchronous_setting_for_wfc_volte", context, subId);
        Log.d(TAG, "synSettingForWFCandVoLTE =  " + isSynSettingForWFCandVoLTE);
        return isSynSettingForWFCandVoLTE;
    }

    private static boolean isCarrierConfigApplied(int subId, Context context) {
        PersistableBundle b;
        CarrierConfigManager configManager = (CarrierConfigManager) context.getSystemService("carrier_config");
        if (configManager != null && (b = configManager.getConfigForSubId(subId)) != null) {
            return CarrierConfigManager.isConfigForIdentifiedCarrier(b);
        }
        return false;
    }

    public static boolean isSingleImsStack() {
        boolean isSingleImsStack = SystemProperties.getBoolean(PROPERTY_SINGLE_IMS_STACK, true);
        return isSingleImsStack;
    }

    private static boolean isSubIdValid(int subId) {
        return SubscriptionManager.isValidSubscriptionId(subId) && subId != Integer.MAX_VALUE;
    }
}