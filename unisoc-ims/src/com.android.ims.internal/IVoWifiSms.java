package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.ims.internal.IVoWifiSmsCallback;

/* loaded from: classes.dex */
public interface IVoWifiSms extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiSms";

    int acknowledgeSms(int i, int i2, int i3) throws RemoteException;

    int acknowledgeSmsReport(int i, int i2, int i3) throws RemoteException;

    String registerCallback(IVoWifiSmsCallback iVoWifiSmsCallback) throws RemoteException;

    int sendSms(int i, int i2, int i3, String str, String str2) throws RemoteException;

    void unregisterCallback(String str) throws RemoteException;

    public static class Default implements IVoWifiSms {
        @Override // com.android.ims.internal.IVoWifiSms
        public String registerCallback(IVoWifiSmsCallback callback) throws RemoteException {
            return null;
        }

        @Override // com.android.ims.internal.IVoWifiSms
        public void unregisterCallback(String hashcode) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiSms
        public int sendSms(int token, int messageRef, int retry, String smsc, String pdu) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiSms
        public int acknowledgeSms(int token, int messageRef, int cause) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiSms
        public int acknowledgeSmsReport(int token, int messageRef, int cause) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiSms {
        static final int TRANSACTION_acknowledgeSms = 4;
        static final int TRANSACTION_acknowledgeSmsReport = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_sendSms = 3;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            attachInterface(this, IVoWifiSms.DESCRIPTOR);
        }

        public static IVoWifiSms asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiSms.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiSms)) {
                return (IVoWifiSms) iin;
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
                data.enforceInterface(IVoWifiSms.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiSms.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            IVoWifiSmsCallback _arg0 = IVoWifiSmsCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            String _result = registerCallback(_arg0);
                            reply.writeNoException();
                            reply.writeString(_result);
                            return true;
                        case 2:
                            String _arg02 = data.readString();
                            data.enforceNoDataAvail();
                            unregisterCallback(_arg02);
                            reply.writeNoException();
                            return true;
                        case 3:
                            int _arg03 = data.readInt();
                            int _arg1 = data.readInt();
                            int _arg2 = data.readInt();
                            String _arg3 = data.readString();
                            String _arg4 = data.readString();
                            data.enforceNoDataAvail();
                            int _result2 = sendSms(_arg03, _arg1, _arg2, _arg3, _arg4);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case TRANSACTION_acknowledgeSms /* 4 */:
                            int _arg04 = data.readInt();
                            int _arg12 = data.readInt();
                            int _arg22 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result3 = acknowledgeSms(_arg04, _arg12, _arg22);
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        case TRANSACTION_acknowledgeSmsReport /* 5 */:
                            int _arg05 = data.readInt();
                            int _arg13 = data.readInt();
                            int _arg23 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result4 = acknowledgeSmsReport(_arg05, _arg13, _arg23);
                            reply.writeNoException();
                            reply.writeInt(_result4);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiSms {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiSms.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiSms
            public String registerCallback(IVoWifiSmsCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSms.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSms
            public void unregisterCallback(String hashcode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSms.DESCRIPTOR);
                    _data.writeString(hashcode);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSms
            public int sendSms(int token, int messageRef, int retry, String smsc, String pdu) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSms.DESCRIPTOR);
                    _data.writeInt(token);
                    _data.writeInt(messageRef);
                    _data.writeInt(retry);
                    _data.writeString(smsc);
                    _data.writeString(pdu);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSms
            public int acknowledgeSms(int token, int messageRef, int cause) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSms.DESCRIPTOR);
                    _data.writeInt(token);
                    _data.writeInt(messageRef);
                    _data.writeInt(cause);
                    this.mRemote.transact(Stub.TRANSACTION_acknowledgeSms, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSms
            public int acknowledgeSmsReport(int token, int messageRef, int cause) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSms.DESCRIPTOR);
                    _data.writeInt(token);
                    _data.writeInt(messageRef);
                    _data.writeInt(cause);
                    this.mRemote.transact(Stub.TRANSACTION_acknowledgeSmsReport, _data, _reply, 0);
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