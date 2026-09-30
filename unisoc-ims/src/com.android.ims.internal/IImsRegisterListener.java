package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IImsRegisterListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsRegisterListener";

    void imsRegisterStateChange(boolean z) throws RemoteException;

    public static class Default implements IImsRegisterListener {
        @Override // com.android.ims.internal.IImsRegisterListener
        public void imsRegisterStateChange(boolean isRegistered) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsRegisterListener {
        static final int TRANSACTION_imsRegisterStateChange = 1;

        public Stub() {
            attachInterface(this, IImsRegisterListener.DESCRIPTOR);
        }

        public static IImsRegisterListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsRegisterListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsRegisterListener)) {
                return (IImsRegisterListener) iin;
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
                data.enforceInterface(IImsRegisterListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsRegisterListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            boolean _arg0 = data.readBoolean();
                            data.enforceNoDataAvail();
                            imsRegisterStateChange(_arg0);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsRegisterListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsRegisterListener.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsRegisterListener
            public void imsRegisterStateChange(boolean isRegistered) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsRegisterListener.DESCRIPTOR);
                    _data.writeBoolean(isRegistered);
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