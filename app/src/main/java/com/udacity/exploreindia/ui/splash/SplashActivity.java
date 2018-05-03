package com.udacity.exploreindia.ui.splash;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivitySplashBinding;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class SplashActivity extends BaseActivity< SplashContract.Presenter,ActivitySplashBinding> implements SplashContract.View {

    private ActivitySplashBinding activitySplashBinding;
    private SplashPresenter splashPresenter;
    private Context mContext;

    @Override
    protected int getContentResource() {
         return R.layout.activity_splash;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

        activitySplashBinding=getDataBinder();
        mContext=SplashActivity.this;

        splashPresenter=new SplashPresenter(SharedPrefManager.getInstance(),null,mContext);

        splashPresenter.setAnimation(activitySplashBinding,mContext);
        splashPresenter.initCountDown();


    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }


    @Override
    public void moveToHomeScreen() {

    }

    @Override
    public void moveToLoginScreen() {

    }
}
