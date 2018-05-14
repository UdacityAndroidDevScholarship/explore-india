package com.udacity.exploreindia.ui.StatesWithCities;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityStatesWithCitiesBinding;

public class StatesWithCitiesActivity extends BaseActivity<StatesWithCitiesContract.Presenter,
        ActivityStatesWithCitiesBinding> implements StatesWithCitiesContract.View
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_with_cities);
    }

    @Override
    protected int getContentResource() {
        return 0;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }
}
