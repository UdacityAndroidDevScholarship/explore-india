package com.udacity.exploreindia.ui.home.fragments.profile;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class UserDetailPresenter extends BasePresenter<UserDetailContract.View> implements UserDetailContract.Presenter {


    public UserDetailPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
