package com.udacity.exploreindia.ui.selectedstate.fragment;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

/**
 * Created by kamalshree on 5/3/2018.
 */

public class SelectedPlacesPresenter extends BasePresenter<SelectedPlacesContract.View> implements SelectedPlacesContract.Presenter {

    public SelectedPlacesPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}