package com.udacity.exploreindia.ui.splash;

import android.content.Context;
import android.os.Handler;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    int secondsDelayed = 1;

    public SplashPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context context) {
        super(mSharedPreferences, mBaseRepo,context);
    }

    @Override
    public void init() {

    }

    @Override
    public void inintCountDown() {
        if (getSharedPreferences().isFirstTimeLaunch()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // TODO: 24-04-2018 First Time Code
                    getView().moveToNextSScreen();
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
