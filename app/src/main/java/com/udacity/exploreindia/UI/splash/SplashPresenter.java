package com.udacity.exploreindia.UI.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.udacity.exploreindia.Base.BasePresenter;
import com.udacity.exploreindia.data.Basic.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class SplashPresenter extends BasePresenter<SplashContract.View> {

    int secondsDelayed = 1;

    public SplashPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context context) {
        super(mSharedPreferences, mBaseRepo,context);
    }

    @Override
    public void init() {
        if (getSharedPreferences().isFirstTimeLaunch()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // TODO: 24-04-2018 First Time Code
                }
            }, secondsDelayed * 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // TODO: 24-04-2018 Re-Visit Code
                }
            }, secondsDelayed * 1000);
        }
    }
}
