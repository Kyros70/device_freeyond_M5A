package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVoWifiSecurityCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWifiSecurityCallback";

    void onS2bStateChanged(String str) throws RemoteException;

    public static class Default implements IVoWifiSecurityCallback {
        @Override // com.android.ims.internal.IVoWifiSecurityCallback
        public void onS2bStateChanged(String json) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWifiSecurityCallback {
        static final int TRANSACTION_onS2bStateChanged = 1;

        public Stub() {
            attachInterface(this, IVoWifiSecurityCallback.DESCRIPTOR);
        }

        public static IVoWifiSecurityCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWifiSecurityCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWifiSecurityCallback)) {
                return (IVoWifiSecurityCallback) iin;
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
                data.enforceInterface(IVoWifiSecurityCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWifiSecurityCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            String _arg0 = data.readString();
                            data.enforceNoDataAvail();
                            onS2bStateChanged(_arg0);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWifiSecurityCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWifiSecurityCallback.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWifiSecurityCallback
            public void onS2bStateChanged(String json) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWifiSecurityCallback.DESCRIPTOR);
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