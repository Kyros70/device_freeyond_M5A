package com.android.ims.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.telephony.uicc.IccUtils;

/* loaded from: classes.dex */
public class GbaAuthResult implements Parcelable {
    public static final Parcelable.Creator<GbaAuthResult> CREATOR = new Parcelable.Creator<GbaAuthResult>() { // from class: com.android.ims.internal.GbaAuthResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GbaAuthResult createFromParcel(Parcel in) {
            return new GbaAuthResult(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GbaAuthResult[] newArray(int size) {
            return new GbaAuthResult[size];
        }
    };
    public static final int GBA_FAILURE_REASON_NONE = -1;
    private String mBtId;
    private int mFailureReason;
    private byte[] mGbaKey;
    private int mToken;

    public GbaAuthResult() {
    }

    public GbaAuthResult(int token, int failureReason, byte[] gbaKey, String btId) {
        this.mToken = token;
        this.mFailureReason = failureReason;
        this.mBtId = btId;
        this.mGbaKey = gbaKey;
    }

    private GbaAuthResult(Parcel in) {
        this.mToken = in.readInt();
        this.mFailureReason = in.readInt();
        this.mBtId = in.readString();
        int arrayLength = in.readInt();
        if (arrayLength > 0) {
            byte[] bArr = new byte[arrayLength];
            this.mGbaKey = bArr;
            in.readByteArray(bArr);
            return;
        }
        this.mGbaKey = null;
    }

    public int getToken() {
        return this.mToken;
    }

    public void setToken(int token) {
        this.mToken = token;
    }

    public int getFailureReason() {
        return this.mFailureReason;
    }

    public void setFailureReason(int failureReason) {
        this.mFailureReason = failureReason;
    }

    public byte[] getGbaKey() {
        return this.mGbaKey;
    }

    public void setGbaKey(byte[] gbaKey) {
        this.mGbaKey = gbaKey;
    }

    public String getBtId() {
        return this.mBtId;
    }

    public void setBtId(String btId) {
        this.mBtId = btId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mToken);
        dest.writeInt(this.mFailureReason);
        dest.writeString(this.mBtId);
        byte[] bArr = this.mGbaKey;
        if (bArr != null && bArr.length > 0) {
            dest.writeInt(bArr.length);
            dest.writeByteArray(this.mGbaKey);
        } else {
            dest.writeInt(0);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("GbaAuthResult (mToken=").append(this.mToken).append(", mFailureReason=").append(this.mFailureReason).append(", mGbaKey=");
        byte[] bArr = this.mGbaKey;
        Object objBytesToHexString = bArr;
        if (bArr != null) {
            objBytesToHexString = IccUtils.bytesToHexString(bArr);
        }
        return sbAppend.append(objBytesToHexString).append(", mBtId=").append(this.mBtId).append(")").toString();
    }
}