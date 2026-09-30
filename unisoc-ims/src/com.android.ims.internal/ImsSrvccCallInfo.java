package com.android.ims.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ImsSrvccCallInfo implements Parcelable {
    public static final Parcelable.Creator<ImsSrvccCallInfo> CREATOR = new Parcelable.Creator<ImsSrvccCallInfo>() { // from class: com.android.ims.internal.ImsSrvccCallInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsSrvccCallInfo createFromParcel(Parcel in) {
            return new ImsSrvccCallInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsSrvccCallInfo[] newArray(int size) {
            return new ImsSrvccCallInfo[size];
        }
    };
    public int mCallId;
    public int mCallState;
    public int mCallType;
    public int mDir;
    public int mHoldState;
    public int mMptyOrder;
    public int mMptyState;
    public int mNumType;
    public String mNumber;

    public ImsSrvccCallInfo() {
    }

    public ImsSrvccCallInfo(Parcel in) {
        readFromParcel(in);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.mCallId);
        out.writeInt(this.mDir);
        out.writeInt(this.mCallState);
        out.writeInt(this.mHoldState);
        out.writeInt(this.mMptyState);
        out.writeInt(this.mMptyOrder);
        out.writeInt(this.mCallType);
        out.writeInt(this.mNumType);
        out.writeString(this.mNumber);
    }

    private void readFromParcel(Parcel in) {
        this.mCallId = in.readInt();
        this.mDir = in.readInt();
        this.mCallState = in.readInt();
        this.mHoldState = in.readInt();
        this.mMptyState = in.readInt();
        this.mMptyOrder = in.readInt();
        this.mCallType = in.readInt();
        this.mNumType = in.readInt();
        this.mNumber = in.readString();
    }

    public String toString() {
        return ImsSrvccCallInfo.class.toString() + ":mCallId: " + this.mCallId + ", mDir: " + this.mDir + ", mCallState: " + this.mCallState + ", mHoldState=" + this.mHoldState + ", mMptyState: " + this.mMptyState + ", mMptyOrder:" + this.mMptyOrder + ", mCallType:" + this.mCallType + ", mNumType:" + this.mNumType + ", mNumber:" + this.mNumber;
    }

    public String toAtCommands() {
        return "\"" + this.mCallId + "," + this.mDir + "," + this.mCallState + "," + this.mHoldState + "," + this.mMptyState + "," + this.mMptyOrder + "," + this.mCallType + "," + this.mNumType + "," + this.mNumber + "\"";
    }
}