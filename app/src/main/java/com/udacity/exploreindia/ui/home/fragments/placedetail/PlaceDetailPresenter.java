package com.udacity.exploreindia.ui.home.fragments.placedetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;
import com.udacity.exploreindia.ui.home.fragments.place.PlaceContract;

public class PlaceDetailPresenter extends BasePresenter<PlaceDetailContract.View> implements PlaceDetailContract.Presenter {


    public PlaceDetailPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {

    }
}
