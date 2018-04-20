package com.udacity.exploreindia.Base;


/**
 * Created by kautilya on 09-12-2017.
 */

public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

    private V view;


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

    @Override
    public void init() {
    }

    public V getView() {
        return view;
    }
}