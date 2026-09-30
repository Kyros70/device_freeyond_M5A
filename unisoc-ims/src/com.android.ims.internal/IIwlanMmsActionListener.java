package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IIwlanMmsActionListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IIwlanMmsActionListener";

    void onMmsTransportStateChange(int i, boolean z) throws RemoteException;

    public static class Default implements IIwlanMmsActionListener {
        @Override // com.android.ims.internal.IIwlanMmsActionListener
        public void onMmsTransportStateChange(int slot, boolean isRetrySend) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIwlanMmsActionListener {
        static final int TRANSACTION_onMmsTransportStateChange = 1;

        public Stub() {
            attachInterface(this, IIwlanMmsActionListener.DESCRIPTOR);
        }

        public static IIwlanMmsActionListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIwlanMmsActionListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IIwlanMmsActionListener)) {
                return (IIwlanMmsActionListener) iin;
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
                data.enforceInterface(IIwlanMmsActionListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IIwlanMmsActionListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            boolean _arg1 = data.readBoolean();
                            data.enforceNoDataAvail();
                            onMmsTransportStateChange(_arg0, _arg1);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IIwlanMmsActionListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIwlanMmsActionListener.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IIwlanMmsActionListener
            public void onMmsTransportStateChange(int slot, boolean isRetrySend) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIwlanMmsActionListener.DESCRIPTOR);
                    _data.writeInt(slot);
                    _data.writeBoolean(isRetrySend);
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