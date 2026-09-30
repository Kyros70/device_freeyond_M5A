package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVoWifiUTCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiUTCallback";

    void onEvent(String str) throws RemoteException;

    public static class Default implements IVoWifiUTCallback {
        @Override // com.android.ims.internal.IVoWifiUTCallback
        public void onEvent(String json) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiUTCallback {
        static final int TRANSACTION_onEvent = 1;

        public Stub() {
            attachInterface(this, IVoWifiUTCallback.DESCRIPTOR);
        }

        public static IVoWifiUTCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiUTCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiUTCallback)) {
                return (IVoWifiUTCallback) iin;
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
                data.enforceInterface(IVoWifiUTCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiUTCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            String _arg0 = data.readString();
                            data.enforceNoDataAvail();
                            onEvent(_arg0);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiUTCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiUTCallback.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiUTCallback
            public void onEvent(String json) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiUTCallback.DESCRIPTOR);
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