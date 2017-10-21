package com.zakar.ncaung.sendingdatabetweenactivities;

import android.app.Application;

import com.zakar.ncaung.sendingdatabetweenactivities.Parcel.User;

/**
 * Created by ncaung on 10/21/17.
 */

public class MainApplication extends Application {
    private static User user;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static User getUser(){
        if(user == null){
            user = new User();

        }
        return user;
    }
}
