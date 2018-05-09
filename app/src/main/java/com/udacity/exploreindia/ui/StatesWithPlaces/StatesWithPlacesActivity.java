package com.udacity.exploreindia.ui.StatesWithPlaces;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityStatesWithPlacesBinding;

public class StatesWithPlacesActivity extends BaseActivity<StatesWithPlacesContract.Presenter, ActivityStatesWithPlacesBinding> implements StatesWithPlacesContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_with_places);
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
