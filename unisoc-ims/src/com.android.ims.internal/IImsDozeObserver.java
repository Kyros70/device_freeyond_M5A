package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IImsDozeObserver extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsDozeObserver";

    void onDozeModeOnOff(boolean z) throws RemoteException;

    public static class Default implements IImsDozeObserver {
        @Override // com.android.ims.internal.IImsDozeObserver
        public void onDozeModeOnOff(boolean switchedOn) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsDozeObserver {
        static final int TRANSACTION_onDozeModeOnOff = 1;

        public Stub() {
            attachInterface(this, IImsDozeObserver.DESCRIPTOR);
        }

        public static IImsDozeObserver asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsDozeObserver.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsDozeObserver)) {
                return (IImsDozeObserver) iin;
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
                data.enforceInterface(IImsDozeObserver.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsDozeObserver.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            boolean _arg0 = data.readBoolean();
                            data.enforceNoDataAvail();
                            onDozeModeOnOff(_arg0);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsDozeObserver {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsDozeObserver.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsDozeObserver
            public void onDozeModeOnOff(boolean switchedOn) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsDozeObserver.DESCRIPTOR);
                    _data.writeBoolean(switchedOn);
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