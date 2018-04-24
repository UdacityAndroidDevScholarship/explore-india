package com.udacity.exploreindia.UI.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.udacity.exploreindia.Base.BaseActivity;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.databinding.ActivitySplashBinding;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class SplashActivity extends BaseActivity< SplashContract.Presenter,ActivitySplashBinding> {



    @Override
    protected int getContentResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }
}
