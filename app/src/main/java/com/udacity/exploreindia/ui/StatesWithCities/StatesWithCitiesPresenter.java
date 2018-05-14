package com.udacity.exploreindia.ui.StatesWithCities;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class StatesWithCitiesPresenter extends BasePresenter<StatesWithCitiesContract.View> implements StatesWithCitiesContract.Presenter
{
    public StatesWithCitiesPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext)
    {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
