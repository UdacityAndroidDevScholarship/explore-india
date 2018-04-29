package com.udacity.exploreindia.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * Created by kautilya on 11-12-2017.
 */

public abstract class BaseFragment<T extends BaseMvpPresenter, K extends ViewDataBinding> extends Fragment implements BaseView {


    T mPresenter;
    K mDataBinder;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getContentResource(), container, false);
        mDataBinder = DataBindingUtil.bind(view);
        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = PresenterFactory.getPresenter(this);
        mPresenter.attach(this);
        init(view, savedInstanceState);
    }

    public T getPresenter() {
        return mPresenter;
    }

    public K getDataBinder() {
        return mDataBinder;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    /**
     * Layout resource to inflate
     *
     * @return layout resource
     */
    @LayoutRes
    protected abstract int getContentResource();


    protected abstract void init(View view, @Nullable Bundle savedInstanceState);


    void displayText(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}