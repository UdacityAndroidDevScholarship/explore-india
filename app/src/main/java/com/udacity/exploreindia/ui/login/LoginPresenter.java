package com.udacity.exploreindia.ui.login;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {


    public LoginPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
