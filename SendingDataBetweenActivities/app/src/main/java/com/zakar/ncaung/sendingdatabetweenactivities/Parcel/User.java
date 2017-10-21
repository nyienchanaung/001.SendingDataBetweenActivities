package com.zakar.ncaung.sendingdatabetweenactivities.Parcel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ncaung on 10/21/17.
 */

public class User implements Parcelable {


    private String user_name;
    private String user_email;
    private String user_age;
    private String user_address;

    protected User(Parcel in) {

        user_name = in.readString();
        user_email = in.readString();
        user_age = in.readString();
        user_address = in.readString();
    }
    //Create Blank Constructor
    public User() {
    }
    //Generate Getter and Setter



    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_name);
        dest.writeString(user_email);
        dest.writeString(user_age);
        dest.writeString(user_address);
    }
}
