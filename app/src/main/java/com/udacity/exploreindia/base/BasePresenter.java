package com.udacity.exploreindia.base;


import android.content.Context;

import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

/**
 * Created by kautilya on 09-12-2017.
 */

public abstract class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    private SharedPrefManager mSharedPreferences;
    private BaseRepo mBaseRepo;
    private Context mContext;

    private V view;

    public BasePresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        this.mSharedPreferences = mSharedPreferences;
        this.mBaseRepo = mBaseRepo;
        this.mContext = mContext;
    }

    public Context getContext() {
        return mContext;
    }

    protected SharedPrefManager getSharedPreferences() {
        return mSharedPreferences;
    }

    protected BaseRepo getBaseRepo() {
        return mBaseRepo;
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }

    @Override
    public boolean isAttached() {
        return view != null;
    }


    public V getView() {
        return view;
    }
}