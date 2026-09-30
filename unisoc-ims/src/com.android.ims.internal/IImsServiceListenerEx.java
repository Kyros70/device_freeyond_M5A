package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IImsServiceListenerEx extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsServiceListenerEx";

    void imsCallEnd(int i) throws RemoteException;

    void imsPdnStateChange(int i) throws RemoteException;

    void onDPDDisconnected() throws RemoteException;

    void onMediaQualityChanged(boolean z, int i, int i2, int i3) throws RemoteException;

    void onNoRtpReceived(boolean z) throws RemoteException;

    void onRtpReceived(boolean z) throws RemoteException;

    void onSetVowifiRegister(int i) throws RemoteException;

    void onSrvccFaild() throws RemoteException;

    void onVideoStateChanged(int i) throws RemoteException;

    void onVoWiFiError(int i) throws RemoteException;

    void operationFailed(int i, String str, int i2) throws RemoteException;

    void operationSuccessed(int i, int i2) throws RemoteException;

    public static class Default implements IImsServiceListenerEx {
        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void operationSuccessed(int id, int type) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void operationFailed(int id, String reason, int type) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void imsCallEnd(int type) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void imsPdnStateChange(int state) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onDPDDisconnected() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onNoRtpReceived(boolean isVideo) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onVoWiFiError(int statusCode) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onRtpReceived(boolean isVideo) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onMediaQualityChanged(boolean isVideo, int lose, int jitter, int rtt) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onSrvccFaild() throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onVideoStateChanged(int videoState) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsServiceListenerEx
        public void onSetVowifiRegister(int action) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsServiceListenerEx {
        static final int TRANSACTION_imsCallEnd = 3;
        static final int TRANSACTION_imsPdnStateChange = 4;
        static final int TRANSACTION_onDPDDisconnected = 5;
        static final int TRANSACTION_onMediaQualityChanged = 9;
        static final int TRANSACTION_onNoRtpReceived = 6;
        static final int TRANSACTION_onRtpReceived = 8;
        static final int TRANSACTION_onSetVowifiRegister = 12;
        static final int TRANSACTION_onSrvccFaild = 10;
        static final int TRANSACTION_onVideoStateChanged = 11;
        static final int TRANSACTION_onVoWiFiError = 7;
        static final int TRANSACTION_operationFailed = 2;
        static final int TRANSACTION_operationSuccessed = 1;

        public Stub() {
            attachInterface(this, IImsServiceListenerEx.DESCRIPTOR);
        }

        public static IImsServiceListenerEx asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsServiceListenerEx.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsServiceListenerEx)) {
                return (IImsServiceListenerEx) iin;
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
                data.enforceInterface(IImsServiceListenerEx.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsServiceListenerEx.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            data.enforceNoDataAvail();
                            operationSuccessed(_arg0, _arg1);
                            reply.writeNoException();
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            String _arg12 = data.readString();
                            int _arg2 = data.readInt();
                            data.enforceNoDataAvail();
                            operationFailed(_arg02, _arg12, _arg2);
                            reply.writeNoException();
                            return true;
                        case 3:
                            int _arg03 = data.readInt();
                            data.enforceNoDataAvail();
                            imsCallEnd(_arg03);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_imsPdnStateChange /* 4 */:
                            int _arg04 = data.readInt();
                            data.enforceNoDataAvail();
                            imsPdnStateChange(_arg04);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onDPDDisconnected /* 5 */:
                            onDPDDisconnected();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onNoRtpReceived /* 6 */:
                            boolean _arg05 = data.readBoolean();
                            data.enforceNoDataAvail();
                            onNoRtpReceived(_arg05);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onVoWiFiError /* 7 */:
                            int _arg06 = data.readInt();
                            data.enforceNoDataAvail();
                            onVoWiFiError(_arg06);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onRtpReceived /* 8 */:
                            boolean _arg07 = data.readBoolean();
                            data.enforceNoDataAvail();
                            onRtpReceived(_arg07);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onMediaQualityChanged /* 9 */:
                            boolean _arg08 = data.readBoolean();
                            int _arg13 = data.readInt();
                            int _arg22 = data.readInt();
                            int _arg3 = data.readInt();
                            data.enforceNoDataAvail();
                            onMediaQualityChanged(_arg08, _arg13, _arg22, _arg3);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onSrvccFaild /* 10 */:
                            onSrvccFaild();
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onVideoStateChanged /* 11 */:
                            int _arg09 = data.readInt();
                            data.enforceNoDataAvail();
                            onVideoStateChanged(_arg09);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_onSetVowifiRegister /* 12 */:
                            int _arg010 = data.readInt();
                            data.enforceNoDataAvail();
                            onSetVowifiRegister(_arg010);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsServiceListenerEx {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsServiceListenerEx.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void operationSuccessed(int id, int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeInt(type);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void operationFailed(int id, String reason, int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeString(reason);
                    _data.writeInt(type);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void imsCallEnd(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void imsPdnStateChange(int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(state);
                    this.mRemote.transact(Stub.TRANSACTION_imsPdnStateChange, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onDPDDisconnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_onDPDDisconnected, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onNoRtpReceived(boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_onNoRtpReceived, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onVoWiFiError(int statusCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(statusCode);
                    this.mRemote.transact(Stub.TRANSACTION_onVoWiFiError, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onRtpReceived(boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeBoolean(isVideo);
                    this.mRemote.transact(Stub.TRANSACTION_onRtpReceived, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onMediaQualityChanged(boolean isVideo, int lose, int jitter, int rtt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeBoolean(isVideo);
                    _data.writeInt(lose);
                    _data.writeInt(jitter);
                    _data.writeInt(rtt);
                    this.mRemote.transact(Stub.TRANSACTION_onMediaQualityChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onSrvccFaild() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_onSrvccFaild, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onVideoStateChanged(int videoState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(videoState);
                    this.mRemote.transact(Stub.TRANSACTION_onVideoStateChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsServiceListenerEx
            public void onSetVowifiRegister(int action) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsServiceListenerEx.DESCRIPTOR);
                    _data.writeInt(action);
                    this.mRemote.transact(Stub.TRANSACTION_onSetVowifiRegister, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}