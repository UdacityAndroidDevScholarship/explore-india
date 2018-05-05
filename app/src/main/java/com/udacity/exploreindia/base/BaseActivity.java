package com.udacity.exploreindia.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.udacity.exploreindia.helper.CustomDialog;


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

    protected void showMessage(String message) {
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.setMessage(message);
        customDialog.show();
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}