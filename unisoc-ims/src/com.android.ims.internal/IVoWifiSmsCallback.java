package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVoWifiSmsCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiSmsCallback";

    void onEvent(String str) throws RemoteException;

    public static class Default implements IVoWifiSmsCallback {
        @Override // com.android.ims.internal.IVoWifiSmsCallback
        public void onEvent(String json) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiSmsCallback {
        static final int TRANSACTION_onEvent = 1;

        public Stub() {
            attachInterface(this, IVoWifiSmsCallback.DESCRIPTOR);
        }

        public static IVoWifiSmsCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiSmsCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiSmsCallback)) {
                return (IVoWifiSmsCallback) iin;
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
                data.enforceInterface(IVoWifiSmsCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiSmsCallback.DESCRIPTOR);
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

        private static class Proxy implements IVoWifiSmsCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiSmsCallback.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiSmsCallback
            public void onEvent(String json) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSmsCallback.DESCRIPTOR);
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