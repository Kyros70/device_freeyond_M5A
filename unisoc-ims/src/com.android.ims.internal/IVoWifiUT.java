package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.ims.internal.IVoWifiUTCallback;

/* loaded from: classes.dex */
public interface IVoWifiUT extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiUT";

    int queryCLIP() throws RemoteException;

    int queryCLIR() throws RemoteException;

    int queryCOLP() throws RemoteException;

    int queryCOLR() throws RemoteException;

    int queryCallBarring(int i) throws RemoteException;

    int queryCallForward() throws RemoteException;

    int queryCallWaiting() throws RemoteException;

    void registerCallback(IVoWifiUTCallback iVoWifiUTCallback) throws RemoteException;

    void unregisterCallback(IVoWifiUTCallback iVoWifiUTCallback) throws RemoteException;

    int updateCLIP(boolean z) throws RemoteException;

    int updateCLIR(int i) throws RemoteException;

    int updateCOLP(boolean z) throws RemoteException;

    int updateCOLR(int i) throws RemoteException;

    int updateCallBarring(int i, boolean z, String[] strArr, int i2) throws RemoteException;

    int updateCallForward(int i, int i2, String str, int i3, int i4) throws RemoteException;

    int updateCallWaiting(boolean z) throws RemoteException;

    boolean updateIPAddr(String str, String str2) throws RemoteException;

    public static class Default implements IVoWifiUT {
        @Override // com.android.ims.internal.IVoWifiUT
        public void registerCallback(IVoWifiUTCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public void unregisterCallback(IVoWifiUTCallback callback) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public boolean updateIPAddr(String localIP, String dnsIP) throws RemoteException {
            return false;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCallBarring(int cbType) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCallForward() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCallWaiting() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCallBarring(int cbCondition, boolean enable, String[] barrList, int serviceClass) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCallForward(int action, int condition, String number, int serviceClass, int timeSeconds) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCallWaiting(boolean enabled) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCLIR() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCLIR(int clirMode) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCLIP() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCLIP(boolean enabled) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCOLR() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCOLR(int presentation) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int queryCOLP() throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IVoWifiUT
        public int updateCOLP(boolean enabled) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiUT {
        static final int TRANSACTION_queryCLIP = 12;
        static final int TRANSACTION_queryCLIR = 10;
        static final int TRANSACTION_queryCOLP = 16;
        static final int TRANSACTION_queryCOLR = 14;
        static final int TRANSACTION_queryCallBarring = 4;
        static final int TRANSACTION_queryCallForward = 5;
        static final int TRANSACTION_queryCallWaiting = 6;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_updateCLIP = 13;
        static final int TRANSACTION_updateCLIR = 11;
        static final int TRANSACTION_updateCOLP = 17;
        static final int TRANSACTION_updateCOLR = 15;
        static final int TRANSACTION_updateCallBarring = 7;
        static final int TRANSACTION_updateCallForward = 8;
        static final int TRANSACTION_updateCallWaiting = 9;
        static final int TRANSACTION_updateIPAddr = 3;

        public Stub() {
            attachInterface(this, IVoWifiUT.DESCRIPTOR);
        }

        public static IVoWifiUT asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiUT.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiUT)) {
                return (IVoWifiUT) iin;
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
                data.enforceInterface(IVoWifiUT.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiUT.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            IVoWifiUTCallback _arg0 = IVoWifiUTCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerCallback(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            IVoWifiUTCallback _arg02 = IVoWifiUTCallback.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterCallback(_arg02);
                            reply.writeNoException();
                            return true;
                        case 3:
                            String _arg03 = data.readString();
                            String _arg1 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result = updateIPAddr(_arg03, _arg1);
                            reply.writeNoException();
                            reply.writeBoolean(_result);
                            return true;
                        case TRANSACTION_queryCallBarring /* 4 */:
                            int _arg04 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result2 = queryCallBarring(_arg04);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case TRANSACTION_queryCallForward /* 5 */:
                            int _result3 = queryCallForward();
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        case TRANSACTION_queryCallWaiting /* 6 */:
                            int _result4 = queryCallWaiting();
                            reply.writeNoException();
                            reply.writeInt(_result4);
                            return true;
                        case TRANSACTION_updateCallBarring /* 7 */:
                            int _arg05 = data.readInt();
                            boolean _arg12 = data.readBoolean();
                            String[] _arg2 = data.createStringArray();
                            int _arg3 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result5 = updateCallBarring(_arg05, _arg12, _arg2, _arg3);
                            reply.writeNoException();
                            reply.writeInt(_result5);
                            return true;
                        case TRANSACTION_updateCallForward /* 8 */:
                            int _arg06 = data.readInt();
                            int _arg13 = data.readInt();
                            String _arg22 = data.readString();
                            int _arg32 = data.readInt();
                            int _arg4 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result6 = updateCallForward(_arg06, _arg13, _arg22, _arg32, _arg4);
                            reply.writeNoException();
                            reply.writeInt(_result6);
                            return true;
                        case TRANSACTION_updateCallWaiting /* 9 */:
                            boolean _arg07 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result7 = updateCallWaiting(_arg07);
                            reply.writeNoException();
                            reply.writeInt(_result7);
                            return true;
                        case TRANSACTION_queryCLIR /* 10 */:
                            int _result8 = queryCLIR();
                            reply.writeNoException();
                            reply.writeInt(_result8);
                            return true;
                        case TRANSACTION_updateCLIR /* 11 */:
                            int _arg08 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result9 = updateCLIR(_arg08);
                            reply.writeNoException();
                            reply.writeInt(_result9);
                            return true;
                        case TRANSACTION_queryCLIP /* 12 */:
                            int _result10 = queryCLIP();
                            reply.writeNoException();
                            reply.writeInt(_result10);
                            return true;
                        case TRANSACTION_updateCLIP /* 13 */:
                            boolean _arg09 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result11 = updateCLIP(_arg09);
                            reply.writeNoException();
                            reply.writeInt(_result11);
                            return true;
                        case TRANSACTION_queryCOLR /* 14 */:
                            int _result12 = queryCOLR();
                            reply.writeNoException();
                            reply.writeInt(_result12);
                            return true;
                        case TRANSACTION_updateCOLR /* 15 */:
                            int _arg010 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result13 = updateCOLR(_arg010);
                            reply.writeNoException();
                            reply.writeInt(_result13);
                            return true;
                        case TRANSACTION_queryCOLP /* 16 */:
                            int _result14 = queryCOLP();
                            reply.writeNoException();
                            reply.writeInt(_result14);
                            return true;
                        case TRANSACTION_updateCOLP /* 17 */:
                            boolean _arg011 = data.readBoolean();
                            data.enforceNoDataAvail();
                            int _result15 = updateCOLP(_arg011);
                            reply.writeNoException();
                            reply.writeInt(_result15);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiUT {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiUT.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public void registerCallback(IVoWifiUTCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public void unregisterCallback(IVoWifiUTCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeStrongInterface(callback);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public boolean updateIPAddr(String localIP, String dnsIP) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeString(localIP);
                    _data.writeString(dnsIP);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCallBarring(int cbType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeInt(cbType);
                    this.mRemote.transact(Stub.TRANSACTION_queryCallBarring, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCallForward() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryCallForward, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCallWaiting() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryCallWaiting, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCallBarring(int cbCondition, boolean enable, String[] barrList, int serviceClass) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeInt(cbCondition);
                    _data.writeBoolean(enable);
                    _data.writeStringArray(barrList);
                    _data.writeInt(serviceClass);
                    this.mRemote.transact(Stub.TRANSACTION_updateCallBarring, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCallForward(int action, int condition, String number, int serviceClass, int timeSeconds) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeInt(action);
                    _data.writeInt(condition);
                    _data.writeString(number);
                    _data.writeInt(serviceClass);
                    _data.writeInt(timeSeconds);
                    this.mRemote.transact(Stub.TRANSACTION_updateCallForward, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCallWaiting(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(Stub.TRANSACTION_updateCallWaiting, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCLIR() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryCLIR, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCLIR(int clirMode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeInt(clirMode);
                    this.mRemote.transact(Stub.TRANSACTION_updateCLIR, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCLIP() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryCLIP, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCLIP(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(Stub.TRANSACTION_updateCLIP, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCOLR() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryCOLR, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCOLR(int presentation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeInt(presentation);
                    this.mRemote.transact(Stub.TRANSACTION_updateCOLR, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int queryCOLP() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_queryCOLP, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWifiUT
            public int updateCOLP(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUT.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(Stub.TRANSACTION_updateCOLP, _data, _reply, 0);
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