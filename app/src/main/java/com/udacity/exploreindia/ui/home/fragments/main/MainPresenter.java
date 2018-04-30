package com.udacity.exploreindia.ui.home.fragments.main;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    public MainPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
