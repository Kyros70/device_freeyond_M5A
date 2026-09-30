package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.ims.internal.IVoWifiRegisterCallback;

/* loaded from: classes.dex */
public interface IVoWifiRegister extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiRegister";

    int cliLogin(boolean z, boolean z2, String str, String str2, String str3, int i, String str4, int i2, boolean z3) throws RemoteException;

    int cliLogout() throws RemoteException;

    int cliOpen(int i) throws RemoteException;

    int cliRefresh(int i, String str) throws RemoteException;

    int cliReset() throws RemoteException;

    int cliStart() throws RemoteException;

    int cliUpdateSettings(boolean z) throws RemoteException;

    void registerCallback(IVoWifiRegisterCallback iVoWifiRegisterCallback) throws RemoteException;

    void unregisterCallback(IVoWifiRegisterCallback iVoWifiRegisterCallback) throws RemoteException;

    public static class Default implements IVoWifiRegister {
        @Override // com.android.ims.internal.IVoWifiRegister
        public void registerCallback(IVoWifiRegisterCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public void unregisterCallback(IVoWifiRegisterCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliOpen(int subId) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliStart() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliUpdateSettings(boolean isSRVCCSupport) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliLogin(boolean forSos, boolean isIPv4, String localIP, String pcscfIP, String dnsSerIP, int networkType, String info, int age, boolean isRelogin) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliRefresh(int type, String info) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliLogout() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiRegister
        public int cliReset() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiRegister {
        static final int TRANSACTION_cliLogin = 6;
        static final int TRANSACTION_cliLogout = 8;
        static final int TRANSACTION_cliOpen = 3;
        static final int TRANSACTION_cliRefresh = 7;
        static final int TRANSACTION_cliReset = 9;
        static final int TRANSACTION_cliStart = 4;
        static final int TRANSACTION_cliUpdateSettings = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        public Stub() {
            attachInterface(this, IVoWifiRegister.DESCRIPTOR);
        }

        public static IVoWifiRegister asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiRegister.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiRegister)) {
                return (IVoWifiRegister) iin;
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
                data.enforceInterface(IVoWifiRegister.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiRegister.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            IVoWifiRegisterCallback _arg0 = IVoWifiRegisterCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerCallback(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            IVoWifiRegisterCallback _arg02 = IVoWifiRegisterCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterCallback(_arg02);
                            reply.writeNoException();
                            return true;
                        case 3:
                            int _arg03 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result = cliOpen(_arg03);
                            reply.writeNoException();
                            reply.writeInt(_result);
                            return true;
                        case TRANSACTION_cliStart /* 4 */:
                            int _result2 = cliStart();
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case TRANSACTION_cliUpdateSettings /* 5 */:
                            boolean _arg04 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result3 = cliUpdateSettings(_arg04);
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        case TRANSACTION_cliLogin /* 6 */:
                            boolean _arg05 = data.readBoolean();
                            boolean _arg1 = data.readBoolean();
                            String _arg2 = data.readString();
                            String _arg3 = data.readString();
                            String _arg4 = data.readString();
                            int _arg5 = data.readInt();
                            String _arg6 = data.readString();
                            int _arg7 = data.readInt();
                            boolean _arg8 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result4 = cliLogin(_arg05, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
                            reply.writeNoException();
                            reply.writeInt(_result4);
                            return true;
                        case TRANSACTION_cliRefresh /* 7 */:
                            int _arg06 = data.readInt();
                            String _arg12 = data.readString();
                            data.enforceNoDataAvail();
                            int _result5 = cliRefresh(_arg06, _arg12);
                            reply.writeNoException();
                            reply.writeInt(_result5);
                            return true;
                        case TRANSACTION_cliLogout /* 8 */:
                            int _result6 = cliLogout();
                            reply.writeNoException();
                            reply.writeInt(_result6);
                            return true;
                        case TRANSACTION_cliReset /* 9 */:
                            int _result7 = cliReset();
                            reply.writeNoException();
                            reply.writeInt(_result7);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiRegister {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiRegister.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public void registerCallback(IVoWifiRegisterCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public void unregisterCallback(IVoWifiRegisterCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliOpen(int subId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
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

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliStart() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_cliStart, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliUpdateSettings(boolean isSRVCCSupport) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    _data.writeBoolean(isSRVCCSupport);
                    this.mRemote.transact(Stub.TRANSACTION_cliUpdateSettings, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliLogin(boolean forSos, boolean isIPv4, String localIP, String pcscfIP, String dnsSerIP, int networkType, String info, int age, boolean isRelogin) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    _data.writeBoolean(forSos);
                    _data.writeBoolean(isIPv4);
                    _data.writeString(localIP);
                    _data.writeString(pcscfIP);
                    _data.writeString(dnsSerIP);
                    _data.writeInt(networkType);
                    _data.writeString(info);
                    _data.writeInt(age);
                    _data.writeBoolean(isRelogin);
                    this.mRemote.transact(Stub.TRANSACTION_cliLogin, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliRefresh(int type, String info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(info);
                    this.mRemote.transact(Stub.TRANSACTION_cliRefresh, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliLogout() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_cliLogout, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiRegister
            public int cliReset() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegister.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_cliReset, _data, _reply, 0);
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