package com.udacity.exploreindia.ui.StatesWithPlaces;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

public class StatesWithPlacesPresenter extends BasePresenter<StatesWithPlacesContract.View> implements StatesWithPlacesContract.Presenter {
    public StatesWithPlacesPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
