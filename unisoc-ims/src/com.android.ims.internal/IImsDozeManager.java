package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.ims.internal.IImsDozeObserver;

/* loaded from: classes.dex */
public interface IImsDozeManager extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsDozeManager";

    void registerImsDozeObserver(IImsDozeObserver iImsDozeObserver) throws RemoteException;

    void setImsDozeEnabled(boolean z) throws RemoteException;

    void unregisterImsDozeObserver(IImsDozeObserver iImsDozeObserver) throws RemoteException;

    public static class Default implements IImsDozeManager {
        @Override // com.android.ims.internal.IImsDozeManager
        public void setImsDozeEnabled(boolean enabled) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsDozeManager
        public void registerImsDozeObserver(IImsDozeObserver observer) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsDozeManager
        public void unregisterImsDozeObserver(IImsDozeObserver observer) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsDozeManager {
        static final int TRANSACTION_registerImsDozeObserver = 2;
        static final int TRANSACTION_setImsDozeEnabled = 1;
        static final int TRANSACTION_unregisterImsDozeObserver = 3;

        public Stub() {
            attachInterface(this, IImsDozeManager.DESCRIPTOR);
        }

        public static IImsDozeManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsDozeManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsDozeManager)) {
                return (IImsDozeManager) iin;
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
                data.enforceInterface(IImsDozeManager.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsDozeManager.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            boolean _arg0 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setImsDozeEnabled(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            IImsDozeObserver _arg02 = IImsDozeObserver.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            registerImsDozeObserver(_arg02);
                            reply.writeNoException();
                            return true;
                        case 3:
                            IImsDozeObserver _arg03 = IImsDozeObserver.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            unregisterImsDozeObserver(_arg03);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsDozeManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsDozeManager.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsDozeManager
            public void setImsDozeEnabled(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsDozeManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsDozeManager
            public void registerImsDozeObserver(IImsDozeObserver observer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsDozeManager.DESCRIPTOR);
                    _data.writeStrongInterface(observer);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsDozeManager
            public void unregisterImsDozeObserver(IImsDozeObserver observer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsDozeManager.DESCRIPTOR);
                    _data.writeStrongInterface(observer);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}