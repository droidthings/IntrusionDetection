package com.abi.rtes;

import android.app.Application;

import com.abi.rtes.preference.IAPreference;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        IAPreference.startWith(getApplicationContext());

    }
}
