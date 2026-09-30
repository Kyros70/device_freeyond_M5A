package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.ims.ImsSuppServiceNotification;
import com.android.ims.internal.IImsEventListener;
import com.android.ims.internal.IImsPdnStateListener;
import com.android.ims.internal.IImsRegisterListener;
import com.android.ims.internal.IImsServiceListenerEx;
import com.android.ims.internal.IIwlanAttachActionListener;
import com.android.ims.internal.IIwlanMmsActionListener;
import com.android.ims.internal.IVoWiFiAttachCallback;
import com.android.ims.internal.IVoWiFiAvailabilityCallback;
import java.util.List;

/* loaded from: classes.dex */
public interface IImsServiceEx extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsServiceEx";

    void addImsEventListener(IImsEventListener iImsEventListener) throws RemoteException;

    void addImsPdnStateListener(int i, IImsPdnStateListener iImsPdnStateListener) throws RemoteException;

    int cancelCurrentRequest() throws RemoteException;

    int getAliveCallJitter() throws RemoteException;

    int getAliveCallLose() throws RemoteException;

    int getAliveCallRtt() throws RemoteException;

    int getCLIRStatus(int i) throws RemoteException;

    int getCallType() throws RemoteException;

    void getCallWaitingStatus(int i) throws RemoteException;

    String getCurLocalAddress() throws RemoteException;

    String getCurPcscfAddress() throws RemoteException;

    int getCurrentImsFeature() throws RemoteException;

    int getCurrentImsFeatureForPhone(int i) throws RemoteException;

    int getCurrentImsVideoState() throws RemoteException;

    void getImsCNIInfor() throws RemoteException;

    String getImsPcscfAddress() throws RemoteException;

    String getImsRegAddress() throws RemoteException;

    String getPAU(int i) throws RemoteException;

    int getVolteRegisterState() throws RemoteException;

    int getVolteRegisterStateForPhone(int i) throws RemoteException;

    boolean isSupportMobike() throws RemoteException;

    boolean isSupportVoWifiMms(int i) throws RemoteException;

    boolean isVoWifiAttached() throws RemoteException;

    void notifyImsEvent(int i, int i2, ImsSuppServiceNotification imsSuppServiceNotification) throws RemoteException;

    void notifyMmsTranportStateChange(int i, boolean z) throws RemoteException;

    void notifyNetworkUnavailable() throws RemoteException;

    void notifySrvccCallInfos(List<ImsSrvccCallInfo> list) throws RemoteException;

    void notifyVideoCapabilityChange() throws RemoteException;

    void notifyVoWiFiAttachState(int i, int i2) throws RemoteException;

    void notifyVoWiFiAvailable(int i) throws RemoteException;

    void notifyVoWiFiUnavailable(int i) throws RemoteException;

    GbaAuthResult onAuthenticationRequest(int i, int i2, int i3, String str, byte[] bArr, boolean z) throws RemoteException;

    void registerIwlanAttachActionListener(IIwlanAttachActionListener iIwlanAttachActionListener) throws RemoteException;

    void registerIwlanMmsActionListener(IIwlanMmsActionListener iIwlanMmsActionListener) throws RemoteException;

    void registerforImsRegisterStateChanged(IImsRegisterListener iImsRegisterListener) throws RemoteException;

    void registerforVoWiFiAttachStateChanged(IVoWiFiAttachCallback iVoWiFiAttachCallback) throws RemoteException;

    void registerforVoWiFiAvailabilityChanged(IVoWiFiAvailabilityCallback iVoWiFiAvailabilityCallback) throws RemoteException;

    int releaseVoWifiResource() throws RemoteException;

    void removeImsEventListener(IImsEventListener iImsEventListener) throws RemoteException;

    void removeImsPdnStateListener(int i, IImsPdnStateListener iImsPdnStateListener) throws RemoteException;

    void setImsServiceListener(IImsServiceListenerEx iImsServiceListenerEx) throws RemoteException;

    void setMonitorPeriodForNoData(int i) throws RemoteException;

    int setVoWifiUnavailable(int i, boolean z) throws RemoteException;

    void setVowifiRegister(int i) throws RemoteException;

    void showVowifiNotification() throws RemoteException;

    int startHandover(int i) throws RemoteException;

    void startMobike() throws RemoteException;

    int switchImsFeature(int i) throws RemoteException;

    void terminateCalls(int i) throws RemoteException;

    void unregisterIwlanAttachActionListener(IIwlanAttachActionListener iIwlanAttachActionListener) throws RemoteException;

    void unregisterIwlanMmsActionListener(IIwlanMmsActionListener iIwlanMmsActionListener) throws RemoteException;

    void unregisterVoWiFiAttachStateChanged(IVoWiFiAttachCallback iVoWiFiAttachCallback) throws RemoteException;

    void unregisterVoWiFiAvailabilityChanged(IVoWiFiAvailabilityCallback iVoWiFiAvailabilityCallback) throws RemoteException;

    void unregisterforImsRegisterStateChanged(IImsRegisterListener iImsRegisterListener) throws RemoteException;

    int updateCLIRStatus(int i) throws RemoteException;

    public static class Default implements IImsServiceEx {
        @Override // com.android.ims.internal.IImsServiceEx
        public int switchImsFeature(int type) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int startHandover(int targetType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyNetworkUnavailable() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getCurrentImsFeature() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getCurrentImsFeatureForPhone(int phoneId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public boolean isVoWifiAttached() throws RemoteException {
            return false;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void setImsServiceListener(IImsServiceListenerEx listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public String getImsRegAddress() throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int releaseVoWifiResource() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int setVoWifiUnavailable(int wifiState, boolean isOnlySendAT) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int cancelCurrentRequest() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void registerforImsRegisterStateChanged(IImsRegisterListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void unregisterforImsRegisterStateChanged(IImsRegisterListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void terminateCalls(int wifiState) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public String getCurPcscfAddress() throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void setMonitorPeriodForNoData(int millis) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void showVowifiNotification() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public String getCurLocalAddress() throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getCurrentImsVideoState() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getAliveCallLose() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getAliveCallJitter() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getAliveCallRtt() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getVolteRegisterState() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getVolteRegisterStateForPhone(int phoneId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getCallType() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifySrvccCallInfos(List<ImsSrvccCallInfo> list) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public String getImsPcscfAddress() throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public String getPAU(int PhoneID) throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void setVowifiRegister(int action) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void addImsPdnStateListener(int slotId, IImsPdnStateListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void removeImsPdnStateListener(int slotId, IImsPdnStateListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int getCLIRStatus(int phoneId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public int updateCLIRStatus(int action) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyVideoCapabilityChange() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void startMobike() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public boolean isSupportMobike() throws RemoteException {
            return false;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void getCallWaitingStatus(int phoneId) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void getImsCNIInfor() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void addImsEventListener(IImsEventListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void removeImsEventListener(IImsEventListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyImsEvent(int eventType, int eventCode, ImsSuppServiceNotification ssNotification) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void registerforVoWiFiAvailabilityChanged(IVoWiFiAvailabilityCallback callBack) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void unregisterVoWiFiAvailabilityChanged(IVoWiFiAvailabilityCallback callBack) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyVoWiFiAvailable(int slotId) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyVoWiFiUnavailable(int slotId) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void registerforVoWiFiAttachStateChanged(IVoWiFiAttachCallback callBack) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void unregisterVoWiFiAttachStateChanged(IVoWiFiAttachCallback callBack) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyVoWiFiAttachState(int slotId, int pdnState) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public GbaAuthResult onAuthenticationRequest(int subscriptionId, int token, int appType, String nafUrl, byte[] securityProtocol, boolean forceBootStrapping) throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void registerIwlanAttachActionListener(IIwlanAttachActionListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void unregisterIwlanAttachActionListener(IIwlanAttachActionListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void registerIwlanMmsActionListener(IIwlanMmsActionListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void unregisterIwlanMmsActionListener(IIwlanMmsActionListener listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public void notifyMmsTranportStateChange(int slotId, boolean isRetrySend) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceEx
        public boolean isSupportVoWifiMms(int slotId) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsServiceEx {
        static final int TRANSACTION_addImsEventListener = 39;
        static final int TRANSACTION_addImsPdnStateListener = 30;
        static final int TRANSACTION_cancelCurrentRequest = 11;
        static final int TRANSACTION_getAliveCallJitter = 21;
        static final int TRANSACTION_getAliveCallLose = 20;
        static final int TRANSACTION_getAliveCallRtt = 22;
        static final int TRANSACTION_getCLIRStatus = 32;
        static final int TRANSACTION_getCallType = 25;
        static final int TRANSACTION_getCallWaitingStatus = 37;
        static final int TRANSACTION_getCurLocalAddress = 18;
        static final int TRANSACTION_getCurPcscfAddress = 15;
        static final int TRANSACTION_getCurrentImsFeature = 4;
        static final int TRANSACTION_getCurrentImsFeatureForPhone = 5;
        static final int TRANSACTION_getCurrentImsVideoState = 19;
        static final int TRANSACTION_getImsCNIInfor = 38;
        static final int TRANSACTION_getImsPcscfAddress = 27;
        static final int TRANSACTION_getImsRegAddress = 8;
        static final int TRANSACTION_getPAU = 28;
        static final int TRANSACTION_getVolteRegisterState = 23;
        static final int TRANSACTION_getVolteRegisterStateForPhone = 24;
        static final int TRANSACTION_isSupportMobike = 36;
        static final int TRANSACTION_isSupportVoWifiMms = 55;
        static final int TRANSACTION_isVoWifiAttached = 6;
        static final int TRANSACTION_notifyImsEvent = 41;
        static final int TRANSACTION_notifyMmsTranportStateChange = 54;
        static final int TRANSACTION_notifyNetworkUnavailable = 3;
        static final int TRANSACTION_notifySrvccCallInfos = 26;
        static final int TRANSACTION_notifyVideoCapabilityChange = 34;
        static final int TRANSACTION_notifyVoWiFiAttachState = 48;
        static final int TRANSACTION_notifyVoWiFiAvailable = 44;
        static final int TRANSACTION_notifyVoWiFiUnavailable = 45;
        static final int TRANSACTION_onAuthenticationRequest = 49;
        static final int TRANSACTION_registerIwlanAttachActionListener = 50;
        static final int TRANSACTION_registerIwlanMmsActionListener = 52;
        static final int TRANSACTION_registerforImsRegisterStateChanged = 12;
        static final int TRANSACTION_registerforVoWiFiAttachStateChanged = 46;
        static final int TRANSACTION_registerforVoWiFiAvailabilityChanged = 42;
        static final int TRANSACTION_releaseVoWifiResource = 9;
        static final int TRANSACTION_removeImsEventListener = 40;
        static final int TRANSACTION_removeImsPdnStateListener = 31;
        static final int TRANSACTION_setImsServiceListener = 7;
        static final int TRANSACTION_setMonitorPeriodForNoData = 16;
        static final int TRANSACTION_setVoWifiUnavailable = 10;
        static final int TRANSACTION_setVowifiRegister = 29;
        static final int TRANSACTION_showVowifiNotification = 17;
        static final int TRANSACTION_startHandover = 2;
        static final int TRANSACTION_startMobike = 35;
        static final int TRANSACTION_switchImsFeature = 1;
        static final int TRANSACTION_terminateCalls = 14;
        static final int TRANSACTION_unregisterIwlanAttachActionListener = 51;
        static final int TRANSACTION_unregisterIwlanMmsActionListener = 53;
        static final int TRANSACTION_unregisterVoWiFiAttachStateChanged = 47;
        static final int TRANSACTION_unregisterVoWiFiAvailabilityChanged = 43;
        static final int TRANSACTION_unregisterforImsRegisterStateChanged = 13;
        static final int TRANSACTION_updateCLIRStatus = 33;

        public Stub() {
            attachInterface(this, IImsServiceEx.DESCRIPTOR);
        }

        public static IImsServiceEx asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsServiceEx.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsServiceEx)) {
                return (IImsServiceEx) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IImsServiceEx.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsServiceEx.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result = switchImsFeature(_arg0);
                            reply.writeNoException();
                            reply.writeInt(_result);
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result2 = startHandover(_arg02);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case 3:
                            notifyNetworkUnavailable();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getCurrentImsFeature /* 4 */:
                            int _result3 = getCurrentImsFeature();
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        case TRANSACTION_getCurrentImsFeatureForPhone /* 5 */:
                            int _arg03 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result4 = getCurrentImsFeatureForPhone(_arg03);
                            reply.writeNoException();
                            reply.writeInt(_result4);
                            return true;
                        case TRANSACTION_isVoWifiAttached /* 6 */:
                            boolean _result5 = isVoWifiAttached();
                            reply.writeNoException();
                            reply.writeBoolean(_result5);
                            return true;
                        case TRANSACTION_setImsServiceListener /* 7 */:
                            IImsServiceListenerEx _arg04 = IImsServiceListenerEx.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            setImsServiceListener(_arg04);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getImsRegAddress /* 8 */:
                            String _result6 = getImsRegAddress();
                            reply.writeNoException();
                            reply.writeString(_result6);
                            return true;
                        case TRANSACTION_releaseVoWifiResource /* 9 */:
                            int _result7 = releaseVoWifiResource();
                            reply.writeNoException();
                            reply.writeInt(_result7);
                            return true;
                        case TRANSACTION_setVoWifiUnavailable /* 10 */:
                            int _arg05 = data.readInt();
                            boolean _arg1 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result8 = setVoWifiUnavailable(_arg05, _arg1);
                            reply.writeNoException();
                            reply.writeInt(_result8);
                            return true;
                        case TRANSACTION_cancelCurrentRequest /* 11 */:
                            int _result9 = cancelCurrentRequest();
                            reply.writeNoException();
                            reply.writeInt(_result9);
                            return true;
                        case TRANSACTION_registerforImsRegisterStateChanged /* 12 */:
                            IImsRegisterListener _arg06 = IImsRegisterListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerforImsRegisterStateChanged(_arg06);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_unregisterforImsRegisterStateChanged /* 13 */:
                            IImsRegisterListener _arg07 = IImsRegisterListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterforImsRegisterStateChanged(_arg07);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_terminateCalls /* 14 */:
                            int _arg08 = data.readInt();
                            data.enforceNoDataAvail();
                            terminateCalls(_arg08);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getCurPcscfAddress /* 15 */:
                            String _result10 = getCurPcscfAddress();
                            reply.writeNoException();
                            reply.writeString(_result10);
                            return true;
                        case TRANSACTION_setMonitorPeriodForNoData /* 16 */:
                            int _arg09 = data.readInt();
                            data.enforceNoDataAvail();
                            setMonitorPeriodForNoData(_arg09);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_showVowifiNotification /* 17 */:
                            showVowifiNotification();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getCurLocalAddress /* 18 */:
                            String _result11 = getCurLocalAddress();
                            reply.writeNoException();
                            reply.writeString(_result11);
                            return true;
                        case TRANSACTION_getCurrentImsVideoState /* 19 */:
                            int _result12 = getCurrentImsVideoState();
                            reply.writeNoException();
                            reply.writeInt(_result12);
                            return true;
                        case TRANSACTION_getAliveCallLose /* 20 */:
                            int _result13 = getAliveCallLose();
                            reply.writeNoException();
                            reply.writeInt(_result13);
                            return true;
                        case TRANSACTION_getAliveCallJitter /* 21 */:
                            int _result14 = getAliveCallJitter();
                            reply.writeNoException();
                            reply.writeInt(_result14);
                            return true;
                        case TRANSACTION_getAliveCallRtt /* 22 */:
                            int _result15 = getAliveCallRtt();
                            reply.writeNoException();
                            reply.writeInt(_result15);
                            return true;
                        case TRANSACTION_getVolteRegisterState /* 23 */:
                            int _result16 = getVolteRegisterState();
                            reply.writeNoException();
                            reply.writeInt(_result16);
                            return true;
                        case TRANSACTION_getVolteRegisterStateForPhone /* 24 */:
                            int _arg010 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result17 = getVolteRegisterStateForPhone(_arg010);
                            reply.writeNoException();
                            reply.writeInt(_result17);
                            return true;
                        case TRANSACTION_getCallType /* 25 */:
                            int _result18 = getCallType();
                            reply.writeNoException();
                            reply.writeInt(_result18);
                            return true;
                        case TRANSACTION_notifySrvccCallInfos /* 26 */:
                            List<ImsSrvccCallInfo> _arg011 = data.createTypedArrayList(ImsSrvccCallInfo.CREATOR);
                            data.enforceNoDataAvail();
                            notifySrvccCallInfos(_arg011);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getImsPcscfAddress /* 27 */:
                            String _result19 = getImsPcscfAddress();
                            reply.writeNoException();
                            reply.writeString(_result19);
                            return true;
                        case TRANSACTION_getPAU /* 28 */:
                            int _arg012 = data.readInt();
                            data.enforceNoDataAvail();
                            String _result20 = getPAU(_arg012);
                            reply.writeNoException();
                            reply.writeString(_result20);
                            return true;
                        case TRANSACTION_setVowifiRegister /* 29 */:
                            int _arg013 = data.readInt();
                            data.enforceNoDataAvail();
                            setVowifiRegister(_arg013);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_addImsPdnStateListener /* 30 */:
                            int _arg014 = data.readInt();
                            IImsPdnStateListener _arg12 = IImsPdnStateListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            addImsPdnStateListener(_arg014, _arg12);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_removeImsPdnStateListener /* 31 */:
                            int _arg015 = data.readInt();
                            IImsPdnStateListener _arg13 = IImsPdnStateListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            removeImsPdnStateListener(_arg015, _arg13);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getCLIRStatus /* 32 */:
                            int _arg016 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result21 = getCLIRStatus(_arg016);
                            reply.writeNoException();
                            reply.writeInt(_result21);
                            return true;
                        case TRANSACTION_updateCLIRStatus /* 33 */:
                            int _arg017 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result22 = updateCLIRStatus(_arg017);
                            reply.writeNoException();
                            reply.writeInt(_result22);
                            return true;
                        case TRANSACTION_notifyVideoCapabilityChange /* 34 */:
                            notifyVideoCapabilityChange();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_startMobike /* 35 */:
                            startMobike();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_isSupportMobike /* 36 */:
                            boolean _result23 = isSupportMobike();
                            reply.writeNoException();
                            reply.writeBoolean(_result23);
                            return true;
                        case TRANSACTION_getCallWaitingStatus /* 37 */:
                            int _arg018 = data.readInt();
                            data.enforceNoDataAvail();
                            getCallWaitingStatus(_arg018);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getImsCNIInfor /* 38 */:
                            getImsCNIInfor();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_addImsEventListener /* 39 */:
                            IImsEventListener _arg019 = IImsEventListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            addImsEventListener(_arg019);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_removeImsEventListener /* 40 */:
                            IImsEventListener _arg020 = IImsEventListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            removeImsEventListener(_arg020);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_notifyImsEvent /* 41 */:
                            int _arg021 = data.readInt();
                            int _arg14 = data.readInt();
                            ImsSuppServiceNotification _arg2 = (ImsSuppServiceNotification) data.readTypedObject(ImsSuppServiceNotification.CREATOR);
                            data.enforceNoDataAvail();
                            notifyImsEvent(_arg021, _arg14, _arg2);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_registerforVoWiFiAvailabilityChanged /* 42 */:
                            IVoWiFiAvailabilityCallback _arg022 = IVoWiFiAvailabilityCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerforVoWiFiAvailabilityChanged(_arg022);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_unregisterVoWiFiAvailabilityChanged /* 43 */:
                            IVoWiFiAvailabilityCallback _arg023 = IVoWiFiAvailabilityCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterVoWiFiAvailabilityChanged(_arg023);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_notifyVoWiFiAvailable /* 44 */:
                            int _arg024 = data.readInt();
                            data.enforceNoDataAvail();
                            notifyVoWiFiAvailable(_arg024);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_notifyVoWiFiUnavailable /* 45 */:
                            int _arg025 = data.readInt();
                            data.enforceNoDataAvail();
                            notifyVoWiFiUnavailable(_arg025);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_registerforVoWiFiAttachStateChanged /* 46 */:
                            IVoWiFiAttachCallback _arg026 = IVoWiFiAttachCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerforVoWiFiAttachStateChanged(_arg026);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_unregisterVoWiFiAttachStateChanged /* 47 */:
                            IVoWiFiAttachCallback _arg027 = IVoWiFiAttachCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterVoWiFiAttachStateChanged(_arg027);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_notifyVoWiFiAttachState /* 48 */:
                            int _arg028 = data.readInt();
                            int _arg15 = data.readInt();
                            data.enforceNoDataAvail();
                            notifyVoWiFiAttachState(_arg028, _arg15);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onAuthenticationRequest /* 49 */:
                            int _arg029 = data.readInt();
                            int _arg16 = data.readInt();
                            int _arg22 = data.readInt();
                            String _arg3 = data.readString();
                            byte[] _arg4 = data.createByteArray();
                            boolean _arg5 = data.readBoolean();
                            data.enforceNoDataAvail();
                            GbaAuthResult _result24 = onAuthenticationRequest(_arg029, _arg16, _arg22, _arg3, _arg4, _arg5);
                            reply.writeNoException();
                            reply.writeTypedObject(_result24, 1);
                            return true;
                        case TRANSACTION_registerIwlanAttachActionListener /* 50 */:
                            IIwlanAttachActionListener _arg030 = IIwlanAttachActionListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerIwlanAttachActionListener(_arg030);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_unregisterIwlanAttachActionListener /* 51 */:
                            IIwlanAttachActionListener _arg031 = IIwlanAttachActionListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterIwlanAttachActionListener(_arg031);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_registerIwlanMmsActionListener /* 52 */:
                            IIwlanMmsActionListener _arg032 = IIwlanMmsActionListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerIwlanMmsActionListener(_arg032);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_unregisterIwlanMmsActionListener /* 53 */:
                            IIwlanMmsActionListener _arg033 = IIwlanMmsActionListener.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterIwlanMmsActionListener(_arg033);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_notifyMmsTranportStateChange /* 54 */:
                            int _arg034 = data.readInt();
                            boolean _arg17 = data.readBoolean();
                            data.enforceNoDataAvail();
                            notifyMmsTranportStateChange(_arg034, _arg17);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_isSupportVoWifiMms /* 55 */:
                            int _arg035 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result25 = isSupportVoWifiMms(_arg035);
                            reply.writeNoException();
                            reply.writeBoolean(_result25);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsServiceEx {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsServiceEx.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int switchImsFeature(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int startHandover(int targetType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(targetType);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyNetworkUnavailable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getCurrentImsFeature() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentImsFeature, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getCurrentImsFeatureForPhone(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentImsFeatureForPhone, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public boolean isVoWifiAttached() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isVoWifiAttached, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void setImsServiceListener(IImsServiceListenerEx listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_setImsServiceListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public String getImsRegAddress() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getImsRegAddress, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int releaseVoWifiResource() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_releaseVoWifiResource, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int setVoWifiUnavailable(int wifiState, boolean isOnlySendAT) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(wifiState);
                    _data.writeBoolean(isOnlySendAT);
                    this.mRemote.transact(Stub.TRANSACTION_setVoWifiUnavailable, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int cancelCurrentRequest() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_cancelCurrentRequest, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void registerforImsRegisterStateChanged(IImsRegisterListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerforImsRegisterStateChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void unregisterforImsRegisterStateChanged(IImsRegisterListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterforImsRegisterStateChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void terminateCalls(int wifiState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(wifiState);
                    this.mRemote.transact(Stub.TRANSACTION_terminateCalls, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public String getCurPcscfAddress() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurPcscfAddress, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void setMonitorPeriodForNoData(int millis) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(millis);
                    this.mRemote.transact(Stub.TRANSACTION_setMonitorPeriodForNoData, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void showVowifiNotification() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_showVowifiNotification, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public String getCurLocalAddress() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurLocalAddress, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getCurrentImsVideoState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentImsVideoState, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getAliveCallLose() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAliveCallLose, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getAliveCallJitter() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAliveCallJitter, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getAliveCallRtt() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getAliveCallRtt, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getVolteRegisterState() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getVolteRegisterState, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getVolteRegisterStateForPhone(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    this.mRemote.transact(Stub.TRANSACTION_getVolteRegisterStateForPhone, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getCallType() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCallType, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifySrvccCallInfos(List<ImsSrvccCallInfo> list) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeTypedList(list);
                    this.mRemote.transact(Stub.TRANSACTION_notifySrvccCallInfos, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public String getImsPcscfAddress() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getImsPcscfAddress, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public String getPAU(int PhoneID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(PhoneID);
                    this.mRemote.transact(Stub.TRANSACTION_getPAU, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void setVowifiRegister(int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(action);
                    this.mRemote.transact(Stub.TRANSACTION_setVowifiRegister, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void addImsPdnStateListener(int slotId, IImsPdnStateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_addImsPdnStateListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void removeImsPdnStateListener(int slotId, IImsPdnStateListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_removeImsPdnStateListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int getCLIRStatus(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    this.mRemote.transact(Stub.TRANSACTION_getCLIRStatus, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public int updateCLIRStatus(int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(action);
                    this.mRemote.transact(Stub.TRANSACTION_updateCLIRStatus, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyVideoCapabilityChange() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_notifyVideoCapabilityChange, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void startMobike() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_startMobike, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public boolean isSupportMobike() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isSupportMobike, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void getCallWaitingStatus(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    this.mRemote.transact(Stub.TRANSACTION_getCallWaitingStatus, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void getImsCNIInfor() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getImsCNIInfor, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void addImsEventListener(IImsEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_addImsEventListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void removeImsEventListener(IImsEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_removeImsEventListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyImsEvent(int eventType, int eventCode, ImsSuppServiceNotification ssNotification) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(eventType);
                    _data.writeInt(eventCode);
                    _data.writeTypedObject(ssNotification, 0);
                    this.mRemote.transact(Stub.TRANSACTION_notifyImsEvent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void registerforVoWiFiAvailabilityChanged(IVoWiFiAvailabilityCallback callBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(callBack);
                    this.mRemote.transact(Stub.TRANSACTION_registerforVoWiFiAvailabilityChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void unregisterVoWiFiAvailabilityChanged(IVoWiFiAvailabilityCallback callBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(callBack);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterVoWiFiAvailabilityChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyVoWiFiAvailable(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(Stub.TRANSACTION_notifyVoWiFiAvailable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyVoWiFiUnavailable(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(Stub.TRANSACTION_notifyVoWiFiUnavailable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void registerforVoWiFiAttachStateChanged(IVoWiFiAttachCallback callBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(callBack);
                    this.mRemote.transact(Stub.TRANSACTION_registerforVoWiFiAttachStateChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void unregisterVoWiFiAttachStateChanged(IVoWiFiAttachCallback callBack) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(callBack);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterVoWiFiAttachStateChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyVoWiFiAttachState(int slotId, int pdnState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    _data.writeInt(pdnState);
                    this.mRemote.transact(Stub.TRANSACTION_notifyVoWiFiAttachState, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public GbaAuthResult onAuthenticationRequest(int subscriptionId, int token, int appType, String nafUrl, byte[] securityProtocol, boolean forceBootStrapping) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(subscriptionId);
                    _data.writeInt(token);
                    _data.writeInt(appType);
                    _data.writeString(nafUrl);
                    _data.writeByteArray(securityProtocol);
                    _data.writeBoolean(forceBootStrapping);
                    this.mRemote.transact(Stub.TRANSACTION_onAuthenticationRequest, _data, _reply, 0);
                    _reply.readException();
                    GbaAuthResult _result = (GbaAuthResult) _reply.readTypedObject(GbaAuthResult.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void registerIwlanAttachActionListener(IIwlanAttachActionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerIwlanAttachActionListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void unregisterIwlanAttachActionListener(IIwlanAttachActionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterIwlanAttachActionListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void registerIwlanMmsActionListener(IIwlanMmsActionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_registerIwlanMmsActionListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void unregisterIwlanMmsActionListener(IIwlanMmsActionListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(Stub.TRANSACTION_unregisterIwlanMmsActionListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public void notifyMmsTranportStateChange(int slotId, boolean isRetrySend) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    _data.writeBoolean(isRetrySend);
                    this.mRemote.transact(Stub.TRANSACTION_notifyMmsTranportStateChange, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceEx
            public boolean isSupportVoWifiMms(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceEx.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(Stub.TRANSACTION_isSupportVoWifiMms, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}