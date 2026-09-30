package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVoWifiRegisterCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiRegisterCallback";

    void onRegisterStateChanged(String str) throws RemoteException;

    public static class Default implements IVoWifiRegisterCallback {
        @Override // com.android.ims.internal.IVoWifiRegisterCallback
        public void onRegisterStateChanged(String json) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiRegisterCallback {
        static final int TRANSACTION_onRegisterStateChanged = 1;

        public Stub() {
            attachInterface(this, IVoWifiRegisterCallback.DESCRIPTOR);
        }

        public static IVoWifiRegisterCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiRegisterCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiRegisterCallback)) {
                return (IVoWifiRegisterCallback) iin;
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
                data.enforceInterface(IVoWifiRegisterCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiRegisterCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            String _arg0 = data.readString();
                            data.enforceNoDataAvail();
                            onRegisterStateChanged(_arg0);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiRegisterCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiRegisterCallback.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiRegisterCallback
            public void onRegisterStateChanged(String json) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiRegisterCallback.DESCRIPTOR);
                    _data.writeString(json);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}