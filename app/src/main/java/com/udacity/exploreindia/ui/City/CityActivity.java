package com.udacity.exploreindia.ui.City;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityCityBinding;

public class CityActivity extends BaseActivity<CityContract.Presenter, ActivityCityBinding> implements CityContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
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
