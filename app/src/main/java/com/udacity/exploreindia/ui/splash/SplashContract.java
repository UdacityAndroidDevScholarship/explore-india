package com.udacity.exploreindia.ui.splash;

import android.content.Context;

import com.udacity.exploreindia.base.BaseMvpPresenter;
import com.udacity.exploreindia.base.BaseView;
import com.udacity.exploreindia.databinding.ActivitySplashBinding;


public interface SplashContract {

    interface Presenter extends BaseMvpPresenter<View> {


        void initCountDown();
        void setAnimation(ActivitySplashBinding activitySplashBinding, Context context);

    }

    interface View extends BaseView {

        void moveToHomeScreen();
        void moveToLoginScreen();

    }
}

