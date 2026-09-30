package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IImsPdnStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsPdnStateListener";

    void imsPdnStateChange(int i) throws RemoteException;

    public static class Default implements IImsPdnStateListener {
        @Override // com.android.ims.internal.IImsPdnStateListener
        public void imsPdnStateChange(int status) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsPdnStateListener {
        static final int TRANSACTION_imsPdnStateChange = 1;

        public Stub() {
            attachInterface(this, IImsPdnStateListener.DESCRIPTOR);
        }

        public static IImsPdnStateListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsPdnStateListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsPdnStateListener)) {
                return (IImsPdnStateListener) iin;
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
                data.enforceInterface(IImsPdnStateListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsPdnStateListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            data.enforceNoDataAvail();
                            imsPdnStateChange(_arg0);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsPdnStateListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsPdnStateListener.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsPdnStateListener
            public void imsPdnStateChange(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsPdnStateListener.DESCRIPTOR);
                    _data.writeInt(status);
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