package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVoWiFiAvailabilityCallback extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IVoWiFiAvailabilityCallback";

    void onVoWiFiAvailable(int i) throws RemoteException;

    void onVoWiFiUnavailable(int i) throws RemoteException;

    public static class Default implements IVoWiFiAvailabilityCallback {
        @Override // com.android.ims.internal.IVoWiFiAvailabilityCallback
        public void onVoWiFiAvailable(int slotId) throws RemoteException {
        }

        @Override // com.android.ims.internal.IVoWiFiAvailabilityCallback
        public void onVoWiFiUnavailable(int slotId) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IVoWiFiAvailabilityCallback {
        static final int TRANSACTION_onVoWiFiAvailable = 1;
        static final int TRANSACTION_onVoWiFiUnavailable = 2;

        public Stub() {
            attachInterface(this, IVoWiFiAvailabilityCallback.DESCRIPTOR);
        }

        public static IVoWiFiAvailabilityCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IVoWiFiAvailabilityCallback.DESCRIPTOR);
            if (iin != null && (iin instanceof IVoWiFiAvailabilityCallback)) {
                return (IVoWiFiAvailabilityCallback) iin;
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
                data.enforceInterface(IVoWiFiAvailabilityCallback.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IVoWiFiAvailabilityCallback.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            data.enforceNoDataAvail();
                            onVoWiFiAvailable(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            data.enforceNoDataAvail();
                            onVoWiFiUnavailable(_arg02);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IVoWiFiAvailabilityCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVoWiFiAvailabilityCallback.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IVoWiFiAvailabilityCallback
            public void onVoWiFiAvailable(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWiFiAvailabilityCallback.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IVoWiFiAvailabilityCallback
            public void onVoWiFiUnavailable(int slotId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IVoWiFiAvailabilityCallback.DESCRIPTOR);
                    _data.writeInt(slotId);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}