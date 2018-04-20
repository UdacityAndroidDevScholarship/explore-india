package com.udacity.exploreindia.Base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;


/**
 * Created by kautilya on 09-12-2017.
 */

public abstract class BaseActivity<T extends BaseMvpPresenter, K extends ViewDataBinding> extends AppCompatActivity implements BaseView {


    T mPresenter;
    K mDataBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = injectPresenter();
        mPresenter.attach(this);
        mPresenter.init();
        beforeView(savedInstanceState);
        mDataBinder = DataBindingUtil.setContentView(this, getContentResource());

        init(savedInstanceState);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    public T getPresenter() {
        return mPresenter;
    }

    public K getDataBinder() {
        return mDataBinder;
    }


    /**
     * Layout resource to inflate
     *
     * @return layout resource
     */
    @LayoutRes
    protected abstract int getContentResource();

    protected abstract void init(@Nullable Bundle savedInstanceState);

    protected abstract T injectPresenter();

    protected abstract void beforeView(@Nullable Bundle savedInstanceState);

}