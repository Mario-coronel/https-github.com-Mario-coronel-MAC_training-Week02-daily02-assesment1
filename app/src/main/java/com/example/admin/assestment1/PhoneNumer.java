package com.example.admin.assestment1;

import android.os.Parcel;
import android.os.Parcelable;

public class PhoneNumer implements Parcelable  {
    private final String area;
    private final String num;

    protected PhoneNumer(Parcel in) {
        area = in.readString();
        num = in.readString();
    }

    public static final Creator<PhoneNumer> CREATOR = new Creator<PhoneNumer>() {
        @Override
        public PhoneNumer createFromParcel(Parcel in) {
            return new PhoneNumer(in);
        }

        @Override
        public PhoneNumer[] newArray(int size) {
            return new PhoneNumer[size];
        }
    };

    @Override
    public String toString() {
        return "com.example.admin.assestment1.PhoneNumer{" +
                "area='" + area + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public PhoneNumer(String area, String num) {
        this.area = area;
        this.num = num;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(area);
        dest.writeString(num);
    }
}

