package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IImsEventListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsEventListener";

    void onImsCallEvent(int i) throws RemoteException;

    void onImsRegisterEvent(int i) throws RemoteException;

    public static class Default implements IImsEventListener {
        @Override // com.android.ims.internal.IImsEventListener
        public void onImsRegisterEvent(int event) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsEventListener
        public void onImsCallEvent(int event) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsEventListener {
        static final int TRANSACTION_onImsCallEvent = 2;
        static final int TRANSACTION_onImsRegisterEvent = 1;

        public Stub() {
            attachInterface(this, IImsEventListener.DESCRIPTOR);
        }

        public static IImsEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsEventListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsEventListener)) {
                return (IImsEventListener) iin;
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
                data.enforceInterface(IImsEventListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsEventListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            data.enforceNoDataAvail();
                            onImsRegisterEvent(_arg0);
                            reply.writeNoException();
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            data.enforceNoDataAvail();
                            onImsCallEvent(_arg02);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsEventListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsEventListener.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsEventListener
            public void onImsRegisterEvent(int event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsEventListener.DESCRIPTOR);
                    _data.writeInt(event);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsEventListener
            public void onImsCallEvent(int event) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsEventListener.DESCRIPTOR);
                    _data.writeInt(event);
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