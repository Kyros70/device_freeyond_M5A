package com.android.ims.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.ims.ImsReasonInfo;
import android.telephony.ims.ImsSsInfo;
import com.android.ims.internal.IImsUt;

/* loaded from: classes.dex */
public interface IImsUtListenerEx extends IInterface {
    public static final String DESCRIPTOR = "com.android.ims.internal.IImsUtListenerEx";

    void utConfigurationCallBarringFailed(int i, int[] iArr, int i2) throws RemoteException;

    void utConfigurationCallBarringQueried(IImsUt iImsUt, int i, ImsSsInfo[] imsSsInfoArr) throws RemoteException;

    void utConfigurationCallBarringResult(int i, int[] iArr) throws RemoteException;

    void utConfigurationCallForwardQueried(IImsUt iImsUt, int i, ImsCallForwardInfoEx[] imsCallForwardInfoExArr) throws RemoteException;

    void utConfigurationCallWaitingQueried(IImsUt iImsUt, int i, ImsSsInfo[] imsSsInfoArr) throws RemoteException;

    void utConfigurationQueried(IImsUt iImsUt, int i, Bundle bundle) throws RemoteException;

    void utConfigurationQueryFailed(IImsUt iImsUt, int i, ImsReasonInfo imsReasonInfo) throws RemoteException;

    void utConfigurationUpdateFailed(IImsUt iImsUt, int i, ImsReasonInfo imsReasonInfo) throws RemoteException;

    void utConfigurationUpdated(IImsUt iImsUt, int i) throws RemoteException;

    public static class Default implements IImsUtListenerEx {
        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationUpdated(IImsUt ut, int id) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationUpdateFailed(IImsUt ut, int id, ImsReasonInfo error) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationQueried(IImsUt ut, int id, Bundle ssInfo) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationQueryFailed(IImsUt ut, int id, ImsReasonInfo error) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationCallBarringQueried(IImsUt ut, int id, ImsSsInfo[] cbInfo) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationCallForwardQueried(IImsUt ut, int id, ImsCallForwardInfoEx[] cfInfo) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationCallWaitingQueried(IImsUt ut, int id, ImsSsInfo[] cwInfo) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationCallBarringFailed(int id, int[] result, int errorCode) throws RemoteException {
        }

        @Override // com.android.ims.internal.IImsUtListenerEx
        public void utConfigurationCallBarringResult(int id, int[] result) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IImsUtListenerEx {
        static final int TRANSACTION_utConfigurationCallBarringFailed = 8;
        static final int TRANSACTION_utConfigurationCallBarringQueried = 5;
        static final int TRANSACTION_utConfigurationCallBarringResult = 9;
        static final int TRANSACTION_utConfigurationCallForwardQueried = 6;
        static final int TRANSACTION_utConfigurationCallWaitingQueried = 7;
        static final int TRANSACTION_utConfigurationQueried = 3;
        static final int TRANSACTION_utConfigurationQueryFailed = 4;
        static final int TRANSACTION_utConfigurationUpdateFailed = 2;
        static final int TRANSACTION_utConfigurationUpdated = 1;

        public Stub() {
            attachInterface(this, IImsUtListenerEx.DESCRIPTOR);
        }

        public static IImsUtListenerEx asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IImsUtListenerEx.DESCRIPTOR);
            if (iin != null && (iin instanceof IImsUtListenerEx)) {
                return (IImsUtListenerEx) iin;
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
                data.enforceInterface(IImsUtListenerEx.DESCRIPTOR);
            }
            switch (code) {
                case 1598968902:
                    reply.writeString(IImsUtListenerEx.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            IImsUt _arg0 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg1 = data.readInt();
                            data.enforceNoDataAvail();
                            utConfigurationUpdated(_arg0, _arg1);
                            reply.writeNoException();
                            return true;
                        case 2:
                            IImsUt _arg02 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg12 = data.readInt();
                            ImsReasonInfo _arg2 = (ImsReasonInfo) data.readTypedObject(ImsReasonInfo.CREATOR);
                            data.enforceNoDataAvail();
                            utConfigurationUpdateFailed(_arg02, _arg12, _arg2);
                            reply.writeNoException();
                            return true;
                        case 3:
                            IImsUt _arg03 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg13 = data.readInt();
                            Bundle _arg22 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            utConfigurationQueried(_arg03, _arg13, _arg22);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_utConfigurationQueryFailed /* 4 */:
                            IImsUt _arg04 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg14 = data.readInt();
                            ImsReasonInfo _arg23 = (ImsReasonInfo) data.readTypedObject(ImsReasonInfo.CREATOR);
                            data.enforceNoDataAvail();
                            utConfigurationQueryFailed(_arg04, _arg14, _arg23);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_utConfigurationCallBarringQueried /* 5 */:
                            IImsUt _arg05 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg15 = data.readInt();
                            ImsSsInfo[] _arg24 = (ImsSsInfo[]) data.createTypedArray(ImsSsInfo.CREATOR);
                            data.enforceNoDataAvail();
                            utConfigurationCallBarringQueried(_arg05, _arg15, _arg24);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_utConfigurationCallForwardQueried /* 6 */:
                            IImsUt _arg06 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg16 = data.readInt();
                            ImsCallForwardInfoEx[] _arg25 = (ImsCallForwardInfoEx[]) data.createTypedArray(ImsCallForwardInfoEx.CREATOR);
                            data.enforceNoDataAvail();
                            utConfigurationCallForwardQueried(_arg06, _arg16, _arg25);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_utConfigurationCallWaitingQueried /* 7 */:
                            IImsUt _arg07 = IImsUt.Stub.asInterface(data.readStrongBinder());
                            int _arg17 = data.readInt();
                            ImsSsInfo[] _arg26 = (ImsSsInfo[]) data.createTypedArray(ImsSsInfo.CREATOR);
                            data.enforceNoDataAvail();
                            utConfigurationCallWaitingQueried(_arg07, _arg17, _arg26);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_utConfigurationCallBarringFailed /* 8 */:
                            int _arg08 = data.readInt();
                            int[] _arg18 = data.createIntArray();
                            int _arg27 = data.readInt();
                            data.enforceNoDataAvail();
                            utConfigurationCallBarringFailed(_arg08, _arg18, _arg27);
                            reply.writeNoException();
                            return true;
                        case TRANSACTION_utConfigurationCallBarringResult /* 9 */:
                            int _arg09 = data.readInt();
                            int[] _arg19 = data.createIntArray();
                            data.enforceNoDataAvail();
                            utConfigurationCallBarringResult(_arg09, _arg19);
                            reply.writeNoException();
                            return true;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
            }
        }

        private static class Proxy implements IImsUtListenerEx {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IImsUtListenerEx.DESCRIPTOR;
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationUpdated(IImsUt ut, int id) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationUpdateFailed(IImsUt ut, int id, ImsReasonInfo error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    _data.writeTypedObject(error, 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationQueried(IImsUt ut, int id, Bundle ssInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    _data.writeTypedObject(ssInfo, 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationQueryFailed(IImsUt ut, int id, ImsReasonInfo error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    _data.writeTypedObject(error, 0);
                    this.mRemote.transact(Stub.TRANSACTION_utConfigurationQueryFailed, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationCallBarringQueried(IImsUt ut, int id, ImsSsInfo[] cbInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    _data.writeTypedArray(cbInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_utConfigurationCallBarringQueried, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationCallForwardQueried(IImsUt ut, int id, ImsCallForwardInfoEx[] cfInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    _data.writeTypedArray(cfInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_utConfigurationCallForwardQueried, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationCallWaitingQueried(IImsUt ut, int id, ImsSsInfo[] cwInfo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeStrongInterface(ut);
                    _data.writeInt(id);
                    _data.writeTypedArray(cwInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_utConfigurationCallWaitingQueried, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationCallBarringFailed(int id, int[] result, int errorCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeIntArray(result);
                    _data.writeInt(errorCode);
                    this.mRemote.transact(Stub.TRANSACTION_utConfigurationCallBarringFailed, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.android.ims.internal.IImsUtListenerEx
            public void utConfigurationCallBarringResult(int id, int[] result) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IImsUtListenerEx.DESCRIPTOR);
                    _data.writeInt(id);
                    _data.writeIntArray(result);
                    this.mRemote.transact(Stub.TRANSACTION_utConfigurationCallBarringResult, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}