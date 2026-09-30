package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.ims.internal.IVoWifiSecurityCallback;

/* loaded from: classes.dex */
public interface IVoWifiSecurity extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiSecurity";

    boolean deleteTunelIpsec(int i) throws RemoteException;

    int getState(int i) throws RemoteException;

    void registerCallback(IVoWifiSecurityCallback iVoWifiSecurityCallback) throws RemoteException;

    int start(int i, int i2) throws RemoteException;

    void startMobike(int i) throws RemoteException;

    int startWithAddr(boolean z, int i, int i2, String str) throws RemoteException;

    void stop(int i, boolean z) throws RemoteException;

    boolean switchLoginIpVersion(int i, int i2) throws RemoteException;

    void unregisterCallback(IVoWifiSecurityCallback iVoWifiSecurityCallback) throws RemoteException;

    public static class Default implements IVoWifiSecurity {
        @Override // com.android.ims.internal.IVoWifiSecurity
        public void registerCallback(IVoWifiSecurityCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public void unregisterCallback(IVoWifiSecurityCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public int start(int type, int subId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public int startWithAddr(boolean isHandover, int type, int subId, String localAddr) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public void stop(int sessionId, boolean forHandover) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public void startMobike(int sessionId) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public int getState(int sessionId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public boolean switchLoginIpVersion(int sessionId, int ipVersion) throws RemoteException {
            return false;
        }

        @Override // com.android.ims.internal.IVoWifiSecurity
        public boolean deleteTunelIpsec(int sessionId) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiSecurity {
        static final int TRANSACTION_deleteTunelIpsec = 9;
        static final int TRANSACTION_getState = 7;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_start = 3;
        static final int TRANSACTION_startMobike = 6;
        static final int TRANSACTION_startWithAddr = 4;
        static final int TRANSACTION_stop = 5;
        static final int TRANSACTION_switchLoginIpVersion = 8;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            attachInterface(this, IVoWifiSecurity.DESCRIPTOR);
        }

        public static IVoWifiSecurity asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiSecurity.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiSecurity)) {
                return (IVoWifiSecurity) iin;
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
                data.enforceInterface(IVoWifiSecurity.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiSecurity.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            IVoWifiSecurityCallback _arg0 = IVoWifiSecurityCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerCallback(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            IVoWifiSecurityCallback _arg02 = IVoWifiSecurityCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterCallback(_arg02);
                            reply.writeNoException();
                            return true;
                        case 3:
                            int _arg03 = data.readInt();
                            int _arg1 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result = start(_arg03, _arg1);
                            reply.writeNoException();
                            reply.writeInt(_result);
                            return true;
                        case TRANSACTION_startWithAddr /* 4 */:
                            boolean _arg04 = data.readBoolean();
                            int _arg12 = data.readInt();
                            int _arg2 = data.readInt();
                            String _arg3 = data.readString();
                            data.enforceNoDataAvail();
                            int _result2 = startWithAddr(_arg04, _arg12, _arg2, _arg3);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case TRANSACTION_stop /* 5 */:
                            int _arg05 = data.readInt();
                            boolean _arg13 = data.readBoolean();
                            data.enforceNoDataAvail();
                            stop(_arg05, _arg13);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_startMobike /* 6 */:
                            int _arg06 = data.readInt();
                            data.enforceNoDataAvail();
                            startMobike(_arg06);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_getState /* 7 */:
                            int _arg07 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result3 = getState(_arg07);
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        case TRANSACTION_switchLoginIpVersion /* 8 */:
                            int _arg08 = data.readInt();
                            int _arg14 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result4 = switchLoginIpVersion(_arg08, _arg14);
                            reply.writeNoException();
                            reply.writeBoolean(_result4);
                            return true;
                        case TRANSACTION_deleteTunelIpsec /* 9 */:
                            int _arg09 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result5 = deleteTunelIpsec(_arg09);
                            reply.writeNoException();
                            reply.writeBoolean(_result5);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiSecurity {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiSecurity.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public void registerCallback(IVoWifiSecurityCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public void unregisterCallback(IVoWifiSecurityCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public int start(int type, int subId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeInt(subId);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public int startWithAddr(boolean isHandover, int type, int subId, String localAddr) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeBoolean(isHandover);
                    _data.writeInt(type);
                    _data.writeInt(subId);
                    _data.writeString(localAddr);
                    this.mRemote.transact(Stub.TRANSACTION_startWithAddr, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public void stop(int sessionId, boolean forHandover) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeBoolean(forHandover);
                    this.mRemote.transact(Stub.TRANSACTION_stop, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public void startMobike(int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    this.mRemote.transact(Stub.TRANSACTION_startMobike, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public int getState(int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    this.mRemote.transact(Stub.TRANSACTION_getState, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public boolean switchLoginIpVersion(int sessionId, int ipVersion) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    _data.writeInt(ipVersion);
                    this.mRemote.transact(Stub.TRANSACTION_switchLoginIpVersion, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiSecurity
            public boolean deleteTunelIpsec(int sessionId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurity.DESCRIPTOR);
                    _data.writeInt(sessionId);
                    this.mRemote.transact(Stub.TRANSACTION_deleteTunelIpsec, _data, _reply, 0);
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