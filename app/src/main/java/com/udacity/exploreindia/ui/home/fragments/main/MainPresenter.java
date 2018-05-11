package com.udacity.exploreindia.ui.home.fragments.main;

import android.content.Context;

import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.data.models.RetrofitFactory;
import com.udacity.exploreindia.data.models.request.DataRequest;
import com.udacity.exploreindia.data.models.response.StateResponse;
import com.udacity.exploreindia.helper.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    public MainPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
    }

    @Override
    public void init() {
        loadState();
    }

    private void loadState() {
        DataRequest data = RetrofitFactory.createRetroFitService(DataRequest.class);
        data.getStateDetails("asdasda").enqueue(new Callback<List<StateResponse>>() {
            @Override
            public void onResponse(Call<List<StateResponse>> call, Response<List<StateResponse>> response) {
                List<StateResponse> states = response.body();
            }

            @Override
            public void onFailure(Call<List<StateResponse>> call, Throwable t) {

            }
        });
    }
}
