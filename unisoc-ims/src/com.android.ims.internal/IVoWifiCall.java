package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.android.ims.internal.IVoWifiCallCallback;

/* loaded from: classes.dex */
public interface IVoWifiCall extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiCall";

    int cameraAttach(boolean z, int i, boolean z2) throws RemoteException;

    int cameraDetach(boolean z, int i) throws RemoteException;

    int captureStart(boolean z, int i, int i2, int i3) throws RemoteException;

    int captureStop(boolean z) throws RemoteException;

    int captureStopAll() throws RemoteException;

    int confAcceptInvite(int i) throws RemoteException;

    int confAddMembers(int i, String[] strArr, int[] iArr) throws RemoteException;

    int confCall(String[] strArr, String str, boolean z) throws RemoteException;

    int confDtmf(int i, int i2) throws RemoteException;

    int confHold(int i) throws RemoteException;

    int confInit(boolean z) throws RemoteException;

    int confKickMembers(int i, String[] strArr) throws RemoteException;

    int confRelease(int i) throws RemoteException;

    int confResume(int i) throws RemoteException;

    int confSetLocalImageForTrans(int i, String str, boolean z) throws RemoteException;

    int confSetMute(int i, boolean z) throws RemoteException;

    int confSetup(int i, String str) throws RemoteException;

    int confTerm(int i, int i2) throws RemoteException;

    int confUpdate(int i, int i2) throws RemoteException;

    int confUpdateSRVCCResult(int i, int i2) throws RemoteException;

    int getDefaultVideoLevel() throws RemoteException;

    int getMediaJitter(int i, boolean z, boolean z2) throws RemoteException;

    int getMediaLostRatio(int i, boolean z, boolean z2) throws RemoteException;

    int getMediaRtt(int i, boolean z, boolean z2) throws RemoteException;

    int localRenderAdd(Surface surface, boolean z) throws RemoteException;

    int localRenderRemove(Surface surface, boolean z) throws RemoteException;

    int localRenderRotate(boolean z, int i, int i2) throws RemoteException;

    void registerCallback(IVoWifiCallCallback iVoWifiCallCallback) throws RemoteException;

    int remoteRenderAdd(Surface surface, boolean z, int i) throws RemoteException;

    int remoteRenderRemove(Surface surface, boolean z, int i) throws RemoteException;

    int remoteRenderRotate(boolean z, int i, int i2) throws RemoteException;

    int sendSessionModifyRequest(int i, int i2) throws RemoteException;

    int sendSessionModifyResponse(int i, int i2) throws RemoteException;

    int sendUSSDMessage(int i, String str) throws RemoteException;

    int sessAnswer(int i, String str, boolean z, boolean z2) throws RemoteException;

    int sessCall(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    int sessDtmf(int i, int i2) throws RemoteException;

    int sessHold(int i) throws RemoteException;

    int sessRelease(int i) throws RemoteException;

    int sessResume(int i) throws RemoteException;

    int sessSetMicMute(int i, boolean z) throws RemoteException;

    int sessTerm(int i, int i2) throws RemoteException;

    int sessUpdate(int i, int i2) throws RemoteException;

    int sessUpdateSRVCCResult(int i, int i2) throws RemoteException;

    int setDefaultVideoLevel(int i) throws RemoteException;

    void startAudioStream() throws RemoteException;

    void stopAudioStream() throws RemoteException;

    void unregisterCallback(IVoWifiCallCallback iVoWifiCallCallback) throws RemoteException;

    int updateCurCallSlot(int i) throws RemoteException;

    int updateDataRouterState(int i, int i2, int i3) throws RemoteException;

    int videoStart(boolean z, int i) throws RemoteException;

    int videoStop(boolean z, int i) throws RemoteException;

    public static class Default implements IVoWifiCall {
        @Override // com.android.ims.internal.IVoWifiCall
        public void registerCallback(IVoWifiCallCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public void unregisterCallback(IVoWifiCallCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public void startAudioStream() throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public void stopAudioStream() throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessCall(String peerNumber, String cookie, boolean needAudio, boolean needVideo, boolean ussd, boolean isEmergency) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessSetMicMute(int sessionId, boolean needMute) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessTerm(int sessionId, int termReason) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessHold(int sessionId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessResume(int sessionId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessDtmf(int sessionId, int dtmfType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessAnswer(int sessionId, String cookie, boolean needAudio, boolean needVideo) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessUpdate(int sessionId, int videoType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessRelease(int sessionId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sessUpdateSRVCCResult(int sessionId, int result) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confCall(String[] phoneNumbers, String cookie, boolean isVideo) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confInit(boolean isVideo) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confSetup(int confId, String cookie) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confHold(int confId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confResume(int confId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confAddMembers(int confId, String[] phoneNumbers, int[] sessionIds) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confAcceptInvite(int confId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confTerm(int confId, int reason) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confKickMembers(int confId, String[] phoneNumbers) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confSetMute(int confId, boolean needMute) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confSetLocalImageForTrans(int confId, String uri, boolean start) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confRelease(int confId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confUpdate(int confId, int videoType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confUpdateSRVCCResult(int confId, int result) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int confDtmf(int sessionId, int dtmfType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int cameraAttach(boolean isConf, int callId, boolean isFrontCamera) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int cameraDetach(boolean isConf, int callId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int videoStart(boolean isConf, int callId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int videoStop(boolean isConf, int callId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int captureStart(boolean isFrontCamera, int width, int height, int frameRate) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int captureStop(boolean isFrontCamera) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int captureStopAll() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int remoteRenderRotate(boolean isConf, int callId, int angle) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int localRenderRotate(boolean isFrontCamera, int angle, int deviceOrientation) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int remoteRenderAdd(Surface surface, boolean isConf, int callId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int localRenderAdd(Surface surface, boolean isFrontCamera) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int remoteRenderRemove(Surface surface, boolean isConf, int callId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int localRenderRemove(Surface surface, boolean isFrontCamera) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int setDefaultVideoLevel(int videoLevel) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int getDefaultVideoLevel() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sendSessionModifyRequest(int sessionId, int videoType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sendSessionModifyResponse(int sessionId, int videoType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int getMediaLostRatio(int id, boolean isConference, boolean isVideo) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int getMediaJitter(int id, boolean isConference, boolean isVideo) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int getMediaRtt(int id, boolean isConference, boolean isVideo) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int sendUSSDMessage(int sessionId, String message) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int updateDataRouterState(int flag, int attachSessionId, int state) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiCall
        public int updateCurCallSlot(int slodId) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiCall {
        static final int TRANSACTION_cameraAttach = 30;
        static final int TRANSACTION_cameraDetach = 31;
        static final int TRANSACTION_captureStart = 34;
        static final int TRANSACTION_captureStop = 35;
        static final int TRANSACTION_captureStopAll = 36;
        static final int TRANSACTION_confAcceptInvite = 21;
        static final int TRANSACTION_confAddMembers = 20;
        static final int TRANSACTION_confCall = 15;
        static final int TRANSACTION_confDtmf = 29;
        static final int TRANSACTION_confHold = 18;
        static final int TRANSACTION_confInit = 16;
        static final int TRANSACTION_confKickMembers = 23;
        static final int TRANSACTION_confRelease = 26;
        static final int TRANSACTION_confResume = 19;
        static final int TRANSACTION_confSetLocalImageForTrans = 25;
        static final int TRANSACTION_confSetMute = 24;
        static final int TRANSACTION_confSetup = 17;
        static final int TRANSACTION_confTerm = 22;
        static final int TRANSACTION_confUpdate = 27;
        static final int TRANSACTION_confUpdateSRVCCResult = 28;
        static final int TRANSACTION_getDefaultVideoLevel = 44;
        static final int TRANSACTION_getMediaJitter = 48;
        static final int TRANSACTION_getMediaLostRatio = 47;
        static final int TRANSACTION_getMediaRtt = 49;
        static final int TRANSACTION_localRenderAdd = 40;
        static final int TRANSACTION_localRenderRemove = 42;
        static final int TRANSACTION_localRenderRotate = 38;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_remoteRenderAdd = 39;
        static final int TRANSACTION_remoteRenderRemove = 41;
        static final int TRANSACTION_remoteRenderRotate = 37;
        static final int TRANSACTION_sendSessionModifyRequest = 45;
        static final int TRANSACTION_sendSessionModifyResponse = 46;
        static final int TRANSACTION_sendUSSDMessage = 50;
        static final int TRANSACTION_sessAnswer = 11;
        static final int TRANSACTION_sessCall = 5;
        static final int TRANSACTION_sessDtmf = 10;
        static final int TRANSACTION_sessHold = 8;
        static final int TRANSACTION_sessRelease = 13;
        static final int TRANSACTION_sessResume = 9;
        static final int TRANSACTION_sessSetMicMute = 6;
        static final int TRANSACTION_sessTerm = 7;
        static final int TRANSACTION_sessUpdate = 12;
        static final int TRANSACTION_sessUpdateSRVCCResult = 14;
        static final int TRANSACTION_setDefaultVideoLevel = 43;
        static final int TRANSACTION_startAudioStream = 3;
        static final int TRANSACTION_stopAudioStream = 4;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_updateCurCallSlot = 52;
        static final int TRANSACTION_updateDataRouterState = 51;
        static final int TRANSACTION_videoStart = 32;
        static final int TRANSACTION_videoStop = 33;

        public Stub() {
            attachInterface(this, IVoWifiCall.DESCRIPTOR);
        }

        public static IVoWifiCall asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiCall.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiCall)) {
                return (IVoWifiCall) iin;
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
                data.enforceInterface(IVoWifiCall.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiCall.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            IVoWifiCallCallback _arg0 = IVoWifiCallCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerCallback(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            IVoWifiCallCallback _arg02 = IVoWifiCallCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterCallback(_arg02);
                            reply.writeNoException();
                            return true;
                        case 3:
                            startAudioStream();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_stopAudioStream /* 4 */:
                            stopAudioStream();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_sessCall /* 5 */:
                            String _arg03 = data.readString();
                            String _arg1 = data.readString();
                            boolean _arg2 = data.readBoolean();
                            boolean _arg3 = data.readBoolean();
                            boolean _arg4 = data.readBoolean();
                            boolean _arg5 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result = sessCall(_arg03, _arg1, _arg2, _arg3, _arg4, _arg5);
                            reply.writeNoException();
                            reply.writeInt(_result);
                            return true;
                        case TRANSACTION_sessSetMicMute /* 6 */:
                            int _arg04 = data.readInt();
                            boolean _arg12 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result2 = sessSetMicMute(_arg04, _arg12);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case TRANSACTION_sessTerm /* 7 */:
                            int _arg05 = data.readInt();
                            int _arg13 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result3 = sessTerm(_arg05, _arg13);
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        case TRANSACTION_sessHold /* 8 */:
                            int _arg06 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result4 = sessHold(_arg06);
                            reply.writeNoException();
                            reply.writeInt(_result4);
                            return true;
                        case TRANSACTION_sessResume /* 9 */:
                            int _arg07 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result5 = sessResume(_arg07);
                            reply.writeNoException();
                            reply.writeInt(_result5);
                            return true;
                        case TRANSACTION_sessDtmf /* 10 */:
                            int _arg08 = data.readInt();
                            int _arg14 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result6 = sessDtmf(_arg08, _arg14);
                            reply.writeNoException();
                            reply.writeInt(_result6);
                            return true;
                        case TRANSACTION_sessAnswer /* 11 */:
                            int _arg09 = data.readInt();
                            String _arg15 = data.readString();
                            boolean _arg22 = data.readBoolean();
                            boolean _arg32 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result7 = sessAnswer(_arg09, _arg15, _arg22, _arg32);
                            reply.writeNoException();
                            reply.writeInt(_result7);
                            return true;
                        case TRANSACTION_sessUpdate /* 12 */:
                            int _arg010 = data.readInt();
                            int _arg16 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result8 = sessUpdate(_arg010, _arg16);
                            reply.writeNoException();
                            reply.writeInt(_result8);
                            return true;
                        case TRANSACTION_sessRelease /* 13 */:
                            int _arg011 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result9 = sessRelease(_arg011);
                            reply.writeNoException();
                            reply.writeInt(_result9);
                            return true;
                        case TRANSACTION_sessUpdateSRVCCResult /* 14 */:
                            int _arg012 = data.readInt();
                            int _arg17 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result10 = sessUpdateSRVCCResult(_arg012, _arg17);
                            reply.writeNoException();
                            reply.writeInt(_result10);
                            return true;
                        case TRANSACTION_confCall /* 15 */:
                            String[] _arg013 = data.createStringArray();
                            String _arg18 = data.readString();
                            boolean _arg23 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result11 = confCall(_arg013, _arg18, _arg23);
                            reply.writeNoException();
                            reply.writeInt(_result11);
                            return true;
                        case TRANSACTION_confInit /* 16 */:
                            boolean _arg014 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result12 = confInit(_arg014);
                            reply.writeNoException();
                            reply.writeInt(_result12);
                            return true;
                        case TRANSACTION_confSetup /* 17 */:
                            int _arg015 = data.readInt();
                            String _arg19 = data.readString();
                            data.enforceNoDataAvail();
                            int _result13 = confSetup(_arg015, _arg19);
                            reply.writeNoException();
                            reply.writeInt(_result13);
                            return true;
                        case TRANSACTION_confHold /* 18 */:
                            int _arg016 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result14 = confHold(_arg016);
                            reply.writeNoException();
                            reply.writeInt(_result14);
                            return true;
                        case TRANSACTION_confResume /* 19 */:
                            int _arg017 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result15 = confResume(_arg017);
                            reply.writeNoException();
                            reply.writeInt(_result15);
                            return true;
                        case TRANSACTION_confAddMembers /* 20 */:
                            int _arg018 = data.readInt();
                            String[] _arg110 = data.createStringArray();
                            int[] _arg24 = data.createIntArray();
                            data.enforceNoDataAvail();
                            int _result16 = confAddMembers(_arg018, _arg110, _arg24);
                            reply.writeNoException();
                            reply.writeInt(_result16);
                            return true;
                        case TRANSACTION_confAcceptInvite /* 21 */:
                            int _arg019 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result17 = confAcceptInvite(_arg019);
                            reply.writeNoException();
                            reply.writeInt(_result17);
                            return true;
                        case TRANSACTION_confTerm /* 22 */:
                            int _arg020 = data.readInt();
                            int _arg111 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result18 = confTerm(_arg020, _arg111);
                            reply.writeNoException();
                            reply.writeInt(_result18);
                            return true;
                        case TRANSACTION_confKickMembers /* 23 */:
                            int _arg021 = data.readInt();
                            String[] _arg112 = data.createStringArray();
                            data.enforceNoDataAvail();
                            int _result19 = confKickMembers(_arg021, _arg112);
                            reply.writeNoException();
                            reply.writeInt(_result19);
                            return true;
                        case TRANSACTION_confSetMute /* 24 */:
                            int _arg022 = data.readInt();
                            boolean _arg113 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result20 = confSetMute(_arg022, _arg113);
                            reply.writeNoException();
                            reply.writeInt(_result20);
                            return true;
                        case TRANSACTION_confSetLocalImageForTrans /* 25 */:
                            int _arg023 = data.readInt();
                            String _arg114 = data.readString();
                            boolean _arg25 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result21 = confSetLocalImageForTrans(_arg023, _arg114, _arg25);
                            reply.writeNoException();
                            reply.writeInt(_result21);
                            return true;
                        case TRANSACTION_confRelease /* 26 */:
                            int _arg024 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result22 = confRelease(_arg024);
                            reply.writeNoException();
                            reply.writeInt(_result22);
                            return true;
                        case TRANSACTION_confUpdate /* 27 */:
                            int _arg025 = data.readInt();
                            int _arg115 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result23 = confUpdate(_arg025, _arg115);
                            reply.writeNoException();
                            reply.writeInt(_result23);
                            return true;
                        case TRANSACTION_confUpdateSRVCCResult /* 28 */:
                            int _arg026 = data.readInt();
                            int _arg116 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result24 = confUpdateSRVCCResult(_arg026, _arg116);
                            reply.writeNoException();
                            reply.writeInt(_result24);
                            return true;
                        case TRANSACTION_confDtmf /* 29 */:
                            int _arg027 = data.readInt();
                            int _arg117 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result25 = confDtmf(_arg027, _arg117);
                            reply.writeNoException();
                            reply.writeInt(_result25);
                            return true;
                        case TRANSACTION_cameraAttach /* 30 */:
                            boolean _arg028 = data.readBoolean();
                            int _arg118 = data.readInt();
                            boolean _arg26 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result26 = cameraAttach(_arg028, _arg118, _arg26);
                            reply.writeNoException();
                            reply.writeInt(_result26);
                            return true;
                        case TRANSACTION_cameraDetach /* 31 */:
                            boolean _arg029 = data.readBoolean();
                            int _arg119 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result27 = cameraDetach(_arg029, _arg119);
                            reply.writeNoException();
                            reply.writeInt(_result27);
                            return true;
                        case TRANSACTION_videoStart /* 32 */:
                            boolean _arg030 = data.readBoolean();
                            int _arg120 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result28 = videoStart(_arg030, _arg120);
                            reply.writeNoException();
                            reply.writeInt(_result28);
                            return true;
                        case TRANSACTION_videoStop /* 33 */:
                            boolean _arg031 = data.readBoolean();
                            int _arg121 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result29 = videoStop(_arg031, _arg121);
                            reply.writeNoException();
                            reply.writeInt(_result29);
                            return true;
                        case TRANSACTION_captureStart /* 34 */:
                            boolean _arg032 = data.readBoolean();
                            int _arg122 = data.readInt();
                            int _arg27 = data.readInt();
                            int _arg33 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result30 = captureStart(_arg032, _arg122, _arg27, _arg33);
                            reply.writeNoException();
                            reply.writeInt(_result30);
                            return true;
                        case TRANSACTION_captureStop /* 35 */:
                            boolean _arg033 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result31 = captureStop(_arg033);
                            reply.writeNoException();
                            reply.writeInt(_result31);
                            return true;
                        case TRANSACTION_captureStopAll /* 36 */:
                            int _result32 = captureStopAll();
                            reply.writeNoException();
                            reply.writeInt(_result32);
                            return true;
                        case TRANSACTION_remoteRenderRotate /* 37 */:
                            boolean _arg034 = data.readBoolean();
                            int _arg123 = data.readInt();
                            int _arg28 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result33 = remoteRenderRotate(_arg034, _arg123, _arg28);
                            reply.writeNoException();
                            reply.writeInt(_result33);
                            return true;
                        case TRANSACTION_localRenderRotate /* 38 */:
                            boolean _arg035 = data.readBoolean();
                            int _arg124 = data.readInt();
                            int _arg29 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result34 = localRenderRotate(_arg035, _arg124, _arg29);
                            reply.writeNoException();
                            reply.writeInt(_result34);
                            return true;
                        case TRANSACTION_remoteRenderAdd /* 39 */:
                            Surface _arg036 = (Surface) data.readTypedObject(Surface.CREATOR);
                            boolean _arg125 = data.readBoolean();
                            int _arg210 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result35 = remoteRenderAdd(_arg036, _arg125, _arg210);
                            reply.writeNoException();
                            reply.writeInt(_result35);
                            return true;
                        case TRANSACTION_localRenderAdd /* 40 */:
                            Surface _arg037 = (Surface) data.readTypedObject(Surface.CREATOR);
                            boolean _arg126 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result36 = localRenderAdd(_arg037, _arg126);
                            reply.writeNoException();
                            reply.writeInt(_result36);
                            return true;
                        case TRANSACTION_remoteRenderRemove /* 41 */:
                            Surface _arg038 = (Surface) data.readTypedObject(Surface.CREATOR);
                            boolean _arg127 = data.readBoolean();
                            int _arg211 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result37 = remoteRenderRemove(_arg038, _arg127, _arg211);
                            reply.writeNoException();
                            reply.writeInt(_result37);
                            return true;
                        case TRANSACTION_localRenderRemove /* 42 */:
                            Surface _arg039 = (Surface) data.readTypedObject(Surface.CREATOR);
                            boolean _arg128 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result38 = localRenderRemove(_arg039, _arg128);
                            reply.writeNoException();
                            reply.writeInt(_result38);
                            return true;
                        case TRANSACTION_setDefaultVideoLevel /* 43 */:
                            int _arg040 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result39 = setDefaultVideoLevel(_arg040);
                            reply.writeNoException();
                            reply.writeInt(_result39);
                            return true;
                        case TRANSACTION_getDefaultVideoLevel /* 44 */:
                            int _result40 = getDefaultVideoLevel();
                            reply.writeNoException();
                            reply.writeInt(_result40);
                            return true;
                        case TRANSACTION_sendSessionModifyRequest /* 45 */:
                            int _arg041 = data.readInt();
                            int _arg129 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result41 = sendSessionModifyRequest(_arg041, _arg129);
                            reply.writeNoException();
                            reply.writeInt(_result41);
                            return true;
                        case TRANSACTION_sendSessionModifyResponse /* 46 */:
                            int _arg042 = data.readInt();
                            int _arg130 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result42 = sendSessionModifyResponse(_arg042, _arg130);
                            reply.writeNoException();
                            reply.writeInt(_result42);
                            return true;
                        case TRANSACTION_getMediaLostRatio /* 47 */:
                            int _arg043 = data.readInt();
                            boolean _arg131 = data.readBoolean();
                            boolean _arg212 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result43 = getMediaLostRatio(_arg043, _arg131, _arg212);
                            reply.writeNoException();
                            reply.writeInt(_result43);
                            return true;
                        case TRANSACTION_getMediaJitter /* 48 */:
                            int _arg044 = data.readInt();
                            boolean _arg132 = data.readBoolean();
                            boolean _arg213 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result44 = getMediaJitter(_arg044, _arg132, _arg213);
                            reply.writeNoException();
                            reply.writeInt(_result44);
                            return true;
                        case TRANSACTION_getMediaRtt /* 49 */:
                            int _arg045 = data.readInt();
                            boolean _arg133 = data.readBoolean();
                            boolean _arg214 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result45 = getMediaRtt(_arg045, _arg133, _arg214);
                            reply.writeNoException();
                            reply.writeInt(_result45);
                            return true;
                        case TRANSACTION_sendUSSDMessage /* 50 */:
                            int _arg046 = data.readInt();
                            String _arg134 = data.readString();
                            data.enforceNoDataAvail();
                            int _result46 = sendUSSDMessage(_arg046, _arg134);
                            reply.writeNoException();
                            reply.writeInt(_result46);
                            return true;
                        case TRANSACTION_updateDataRouterState /* 51 */:
                            int _arg047 = data.readInt();
                            int _arg135 = data.readInt();
                            int _arg215 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result47 = updateDataRouterState(_arg047, _arg135, _arg215);
                            reply.writeNoException();
                            reply.writeInt(_result47);
                            return true;
                        case TRANSACTION_updateCurCallSlot /* 52 */:
                            int _arg048 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result48 = updateCurCallSlot(_arg048);
                            reply.writeNoException();
                            reply.writeInt(_result48);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiCall {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiCall.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public void registerCallback(IVoWifiCallCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public void unregisterCallback(IVoWifiCallCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public void startAudioStream() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public void stopAudioStream() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_stopAudioStream, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessCall(String peerNumber, String cookie, boolean needAudio, boolean needVideo, boolean ussd, boolean isEmergency) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeString(peerNumber);
                    _data.writeString(cookie);
                    _data.writeBoolean(needAudio);
                    _data.writeBoolean(needVideo);
                    _data.writeBoolean(ussd);
                    _data.writeBoolean(isEmergency);
                    this.mRemote.transact(Stub.TRANSACTION_sessCall, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessSetMicMute(int sessionId, boolean needMute) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeBoolean(needMute);
                    this.mRemote.transact(Stub.TRANSACTION_sessSetMicMute, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessTerm(int sessionId, int termReason) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(termReason);
                    this.mRemote.transact(Stub.TRANSACTION_sessTerm, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessHold(int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    this.mRemote.transact(Stub.TRANSACTION_sessHold, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessResume(int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    this.mRemote.transact(Stub.TRANSACTION_sessResume, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessDtmf(int sessionId, int dtmfType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(dtmfType);
                    this.mRemote.transact(Stub.TRANSACTION_sessDtmf, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessAnswer(int sessionId, String cookie, boolean needAudio, boolean needVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeString(cookie);
                    _data.writeBoolean(needAudio);
                    _data.writeBoolean(needVideo);
                    this.mRemote.transact(Stub.TRANSACTION_sessAnswer, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessUpdate(int sessionId, int videoType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(videoType);
                    this.mRemote.transact(Stub.TRANSACTION_sessUpdate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessRelease(int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    this.mRemote.transact(Stub.TRANSACTION_sessRelease, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sessUpdateSRVCCResult(int sessionId, int result) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(result);
                    this.mRemote.transact(Stub.TRANSACTION_sessUpdateSRVCCResult, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confCall(String[] phoneNumbers, String cookie, boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeStringArray(phoneNumbers);
                    _data.writeString(cookie);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_confCall, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confInit(boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_confInit, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confSetup(int confId, String cookie) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeString(cookie);
                    this.mRemote.transact(Stub.TRANSACTION_confSetup, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confHold(int confId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    this.mRemote.transact(Stub.TRANSACTION_confHold, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confResume(int confId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    this.mRemote.transact(Stub.TRANSACTION_confResume, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confAddMembers(int confId, String[] phoneNumbers, int[] sessionIds) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeStringArray(phoneNumbers);
                    _data.writeIntArray(sessionIds);
                    this.mRemote.transact(Stub.TRANSACTION_confAddMembers, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confAcceptInvite(int confId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    this.mRemote.transact(Stub.TRANSACTION_confAcceptInvite, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confTerm(int confId, int reason) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeInt(reason);
                    this.mRemote.transact(Stub.TRANSACTION_confTerm, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confKickMembers(int confId, String[] phoneNumbers) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeStringArray(phoneNumbers);
                    this.mRemote.transact(Stub.TRANSACTION_confKickMembers, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confSetMute(int confId, boolean needMute) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeBoolean(needMute);
                    this.mRemote.transact(Stub.TRANSACTION_confSetMute, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confSetLocalImageForTrans(int confId, String uri, boolean start) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeString(uri);
                    _data.writeBoolean(start);
                    this.mRemote.transact(Stub.TRANSACTION_confSetLocalImageForTrans, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confRelease(int confId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    this.mRemote.transact(Stub.TRANSACTION_confRelease, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confUpdate(int confId, int videoType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeInt(videoType);
                    this.mRemote.transact(Stub.TRANSACTION_confUpdate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confUpdateSRVCCResult(int confId, int result) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(confId);
                    _data.writeInt(result);
                    this.mRemote.transact(Stub.TRANSACTION_confUpdateSRVCCResult, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int confDtmf(int sessionId, int dtmfType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(dtmfType);
                    this.mRemote.transact(Stub.TRANSACTION_confDtmf, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int cameraAttach(boolean isConf, int callId, boolean isFrontCamera) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    _data.writeBoolean(isFrontCamera);
                    this.mRemote.transact(Stub.TRANSACTION_cameraAttach, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int cameraDetach(boolean isConf, int callId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    this.mRemote.transact(Stub.TRANSACTION_cameraDetach, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int videoStart(boolean isConf, int callId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    this.mRemote.transact(Stub.TRANSACTION_videoStart, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int videoStop(boolean isConf, int callId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    this.mRemote.transact(Stub.TRANSACTION_videoStop, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int captureStart(boolean isFrontCamera, int width, int height, int frameRate) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isFrontCamera);
                    _data.writeInt(width);
                    _data.writeInt(height);
                    _data.writeInt(frameRate);
                    this.mRemote.transact(Stub.TRANSACTION_captureStart, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int captureStop(boolean isFrontCamera) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isFrontCamera);
                    this.mRemote.transact(Stub.TRANSACTION_captureStop, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int captureStopAll() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_captureStopAll, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int remoteRenderRotate(boolean isConf, int callId, int angle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    _data.writeInt(angle);
                    this.mRemote.transact(Stub.TRANSACTION_remoteRenderRotate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int localRenderRotate(boolean isFrontCamera, int angle, int deviceOrientation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeBoolean(isFrontCamera);
                    _data.writeInt(angle);
                    _data.writeInt(deviceOrientation);
                    this.mRemote.transact(Stub.TRANSACTION_localRenderRotate, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int remoteRenderAdd(Surface surface, boolean isConf, int callId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeTypedObject(surface, 0);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    this.mRemote.transact(Stub.TRANSACTION_remoteRenderAdd, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int localRenderAdd(Surface surface, boolean isFrontCamera) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeTypedObject(surface, 0);
                    _data.writeBoolean(isFrontCamera);
                    this.mRemote.transact(Stub.TRANSACTION_localRenderAdd, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int remoteRenderRemove(Surface surface, boolean isConf, int callId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeTypedObject(surface, 0);
                    _data.writeBoolean(isConf);
                    _data.writeInt(callId);
                    this.mRemote.transact(Stub.TRANSACTION_remoteRenderRemove, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int localRenderRemove(Surface surface, boolean isFrontCamera) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeTypedObject(surface, 0);
                    _data.writeBoolean(isFrontCamera);
                    this.mRemote.transact(Stub.TRANSACTION_localRenderRemove, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int setDefaultVideoLevel(int videoLevel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(videoLevel);
                    this.mRemote.transact(Stub.TRANSACTION_setDefaultVideoLevel, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int getDefaultVideoLevel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getDefaultVideoLevel, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sendSessionModifyRequest(int sessionId, int videoType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(videoType);
                    this.mRemote.transact(Stub.TRANSACTION_sendSessionModifyRequest, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sendSessionModifyResponse(int sessionId, int videoType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(videoType);
                    this.mRemote.transact(Stub.TRANSACTION_sendSessionModifyResponse, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int getMediaLostRatio(int id, boolean isConference, boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeBoolean(isConference);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_getMediaLostRatio, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int getMediaJitter(int id, boolean isConference, boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeBoolean(isConference);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_getMediaJitter, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int getMediaRtt(int id, boolean isConference, boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeBoolean(isConference);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_getMediaRtt, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int sendUSSDMessage(int sessionId, String message) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeString(message);
                    this.mRemote.transact(Stub.TRANSACTION_sendUSSDMessage, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int updateDataRouterState(int flag, int attachSessionId, int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(flag);
                    _data.writeInt(attachSessionId);
                    _data.writeInt(state);
                    this.mRemote.transact(Stub.TRANSACTION_updateDataRouterState, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiCall
            public int updateCurCallSlot(int slodId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiCall.DESCRIPTOR);
                    _data.writeInt(slodId);
                    this.mRemote.transact(Stub.TRANSACTION_updateCurCallSlot, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}