package com.udacity.exploreindia.ui.home.fragments.likedplaces;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

/**
 * Created by kamalshree on 5/3/2018.
 */

public class LikedPlacesPresenter extends BasePresenter<LikedPlacesContract.View> implements LikedPlacesContract.Presenter{

    public LikedPlacesPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
