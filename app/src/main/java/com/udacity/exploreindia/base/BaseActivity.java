package com.udacity.exploreindia.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by kautilya on 09-12-2017.
 */

public abstract class BaseActivity<T extends BaseMvpPresenter, K extends ViewDataBinding> extends AppCompatActivity implements BaseView {


    T mPresenter;
    K mDataBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = PresenterFactory.getPresenter(this);
        mPresenter.attach(this);
        mPresenter.init();
        beforeView(savedInstanceState);
        mDataBinder = DataBindingUtil.setContentView(this, getContentResource());

        init(savedInstanceState);
        getPresenter().init();
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



    protected abstract void beforeView(@Nullable Bundle savedInstanceState);

}