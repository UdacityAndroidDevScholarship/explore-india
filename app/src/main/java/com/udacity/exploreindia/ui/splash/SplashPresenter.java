package com.udacity.exploreindia.ui.splash;

import android.content.Context;
import android.os.Handler;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;


public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private int secondsDelayed = 5;


    public SplashPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context context) {
        super(mSharedPreferences, mBaseRepo, context);

    }

    @Override
    public void init() {

    }

    @Override
    public void initCountDown() {
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          if (getSharedPreferences().isFirstTimeLaunch()) {
                                              getView().moveToHomeScreen();
                                          } else {
                                              getView().moveToLoginScreen();

                                          }
                                      }
                                  },
                secondsDelayed * 1000);
    }


}






