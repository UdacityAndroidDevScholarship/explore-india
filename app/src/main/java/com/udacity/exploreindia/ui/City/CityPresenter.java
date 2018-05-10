package com.udacity.exploreindia.ui.City;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class CityPresenter extends BasePresenter<CityContract.View> implements CityContract.Presenter{

    public CityPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }


    @Override
    public void init() {

    }
}
