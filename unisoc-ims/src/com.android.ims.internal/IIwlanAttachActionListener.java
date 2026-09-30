package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IIwlanAttachActionListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IIwlanAttachActionListener";

    void onVoWifiAttachStateChange(int i, int i2) throws RemoteException;

    public static class Default implements IIwlanAttachActionListener {
        @Override // com.android.ims.internal.IIwlanAttachActionListener
        public void onVoWifiAttachStateChange(int slotId, int state) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIwlanAttachActionListener {
        static final int TRANSACTION_onVoWifiAttachStateChange = 1;

        public Stub() {
            attachInterface(this, IIwlanAttachActionListener.DESCRIPTOR);
        }

        public static IIwlanAttachActionListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IIwlanAttachActionListener.DESCRIPTOR);
            if (iin != null && (iin instanceof IIwlanAttachActionListener)) {
                return (IIwlanAttachActionListener) iin;
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
                data.enforceInterface(IIwlanAttachActionListener.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IIwlanAttachActionListener.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            data.enforceNoDataAvail();
                            onVoWifiAttachStateChange(_arg0, _arg1);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IIwlanAttachActionListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IIwlanAttachActionListener.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IIwlanAttachActionListener
            public void onVoWifiAttachStateChange(int slotId, int state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IIwlanAttachActionListener.DESCRIPTOR);
                    _data.writeInt(slotId);
                    _data.writeInt(state);
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