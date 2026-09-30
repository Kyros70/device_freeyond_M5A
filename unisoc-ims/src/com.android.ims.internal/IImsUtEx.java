package com.android.ims.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.ims.internal.IImsUtListenerEx;

/* loaded from: classes.dex */
public interface IImsUtEx extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsUtEx";

    int changeBarringPassword(int i, String str, String str2, String str3) throws RemoteException;

    int getCallForwardingOption(int i, int i2, int i3, String str) throws RemoteException;

    int setCallForwardingOption(int i, int i2, int i3, int i4, String str, int i5, String str2) throws RemoteException;

    void setListenerEx(int i, IImsUtListenerEx iImsUtListenerEx) throws RemoteException;

    public static class Default implements IImsUtEx {
        @Override // com.android.ims.internal.IImsUtEx
        public int setCallForwardingOption(int phoneId, int commandInterfaceCFAction, int commandInterfaceCFReason, int serviceClass, String dialingNumber, int timerSeconds, String ruleSet) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsUtEx
        public int getCallForwardingOption(int phoneId, int commandInterfaceCFReason, int serviceClass, String ruleSet) throws RemoteException {
            return 0;
        }

        @Override // com.android.ims.internal.IImsUtEx
        public void setListenerEx(int phoneId, IImsUtListenerEx listener) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtEx
        public int changeBarringPassword(int phoneId, String facility, String oldPwd, String newPwd) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsUtEx {
        static final int TRANSACTION_changeBarringPassword = 4;
        static final int TRANSACTION_getCallForwardingOption = 2;
        static final int TRANSACTION_setCallForwardingOption = 1;
        static final int TRANSACTION_setListenerEx = 3;

        public Stub() {
            attachInterface(this, IImsUtEx.DESCRIPTOR);
        }

        public static IImsUtEx asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsUtEx.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsUtEx)) {
                return (IImsUtEx) iin;
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
                data.enforceInterface(IImsUtEx.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsUtEx.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            int _arg0 = data.readInt();
                            int _arg1 = data.readInt();
                            int _arg2 = data.readInt();
                            int _arg3 = data.readInt();
                            String _arg4 = data.readString();
                            int _arg5 = data.readInt();
                            String _arg6 = data.readString();
                            data.enforceNoDataAvail();
                            int _result = setCallForwardingOption(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                            reply.writeNoException();
                            reply.writeInt(_result);
                            return true;
                        case 2:
                            int _arg02 = data.readInt();
                            int _arg12 = data.readInt();
                            int _arg22 = data.readInt();
                            String _arg32 = data.readString();
                            data.enforceNoDataAvail();
                            int _result2 = getCallForwardingOption(_arg02, _arg12, _arg22, _arg32);
                            reply.writeNoException();
                            reply.writeInt(_result2);
                            return true;
                        case 3:
                            int _arg03 = data.readInt();
                            IImsUtListenerEx _arg13 = IImsUtListenerEx.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            setListenerEx(_arg03, _arg13);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_changeBarringPassword /* 4 */:
                            int _arg04 = data.readInt();
                            String _arg14 = data.readString();
                            String _arg23 = data.readString();
                            String _arg33 = data.readString();
                            data.enforceNoDataAvail();
                            int _result3 = changeBarringPassword(_arg04, _arg14, _arg23, _arg33);
                            reply.writeNoException();
                            reply.writeInt(_result3);
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsUtEx {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsUtEx.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsUtEx
            public int setCallForwardingOption(int phoneId, int commandInterfaceCFAction, int commandInterfaceCFReason, int serviceClass, String dialingNumber, int timerSeconds, String ruleSet) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(commandInterfaceCFAction);
                    _data.writeInt(commandInterfaceCFReason);
                    _data.writeInt(serviceClass);
                    _data.writeString(dialingNumber);
                    _data.writeInt(timerSeconds);
                    _data.writeString(ruleSet);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtEx
            public int getCallForwardingOption(int phoneId, int commandInterfaceCFReason, int serviceClass, String ruleSet) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(commandInterfaceCFReason);
                    _data.writeInt(serviceClass);
                    _data.writeString(ruleSet);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtEx
            public void setListenerEx(int phoneId, IImsUtListenerEx listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeStrongInterface(listener);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtEx
            public int changeBarringPassword(int phoneId, String facility, String oldPwd, String newPwd) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtEx.DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeString(facility);
                    _data.writeString(oldPwd);
                    _data.writeString(newPwd);
                    this.mRemote.transact(Stub.TRANSACTION_changeBarringPassword, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}