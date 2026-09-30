package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IN3AMVideoStateNoitfy extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IN3AMVideoStateNoitfy";

    void notifyRtpReceived(int i, boolean z) throws RemoteException;

    void notifyVideoQos(int i, int i2, int i3, int i4) throws RemoteException;

    public static class Default implements IN3AMVideoStateNoitfy {
        @Override // com.android.ims.internal.IN3AMVideoStateNoitfy
        public void notifyVideoQos(int phoneId, int lose, int jitter, int rtt) throws RemoteException {
        }

        @Override // com.android.ims.internal.IN3AMVideoStateNoitfy
        public void notifyRtpReceived(int phoneId, boolean isReceived) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IN3AMVideoStateNoitfy {
        static final int TRANSACTION_notifyRtpReceived = 2;
        static final int TRANSACTION_notifyVideoQos = 1;

        public Stub() {
            attachInterface(this, IN3AMVideoStateNoitfy.DESCRIPTOR);
        }

        public static IN3AMVideoStateNoitfy asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IN3AMVideoStateNoitfy.DESCRIPTOR);
            if (iin != null && (iin instanceof IN3AMVideoStateNoitfy)) {
                return (IN3AMVideoStateNoitfy) iin;
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
                data.enforceInterface(IN3AMVideoStateNoitfy.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IN3AMVideoStateNoitfy.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            int _arg2 = data.readInt();
                            int _arg3 = data.readInt();
                            data.enforceNoDataAvail();
                            notifyVideoQos(_arg0, _arg1, _arg2, _arg3);
                            reply.writeNoException();
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            boolean _arg12 = data.readBoolean();
                            data.enforceNoDataAvail();
                            notifyRtpReceived(_arg02, _arg12);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IN3AMVideoStateNoitfy {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IN3AMVideoStateNoitfy.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IN3AMVideoStateNoitfy
            public void notifyVideoQos(int phoneId, int lose, int jitter, int rtt) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IN3AMVideoStateNoitfy.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(lose);
                    _data.writeInt(jitter);
                    _data.writeInt(rtt);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IN3AMVideoStateNoitfy
            public void notifyRtpReceived(int phoneId, boolean isReceived) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IN3AMVideoStateNoitfy.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeBoolean(isReceived);
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