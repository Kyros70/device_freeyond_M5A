package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVoWiFiAttachCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWiFiAttachCallback";

    void onVoWiFiAttachStateChanged(int i, int i2) throws RemoteException;

    public static class Default implements IVoWiFiAttachCallback {
        @Override // com.android.ims.internal.IVoWiFiAttachCallback
        public void onVoWiFiAttachStateChanged(int slotId, int pdnState) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWiFiAttachCallback {
        static final int TRANSACTION_onVoWiFiAttachStateChanged = 1;

        public Stub() {
            attachInterface(this, IVoWiFiAttachCallback.DESCRIPTOR);
        }

        public static IVoWiFiAttachCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWiFiAttachCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWiFiAttachCallback)) {
                return (IVoWiFiAttachCallback) iin;
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
                data.enforceInterface(IVoWiFiAttachCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWiFiAttachCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            data.enforceNoDataAvail();
                            onVoWiFiAttachStateChanged(_arg0, _arg1);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWiFiAttachCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWiFiAttachCallback.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWiFiAttachCallback
            public void onVoWiFiAttachStateChanged(int slotId, int pdnState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWiFiAttachCallback.DESCRIPTOR);
                    _data.writeInt(slotId);
                    _data.writeInt(pdnState);
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