package com.udacity.exploreindia.ui.StatesWithPlaces;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.adapter.SelectedStatePlaceAdapter;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityStatesWithPlacesBinding;


public class StatesWithPlacesActivity extends BaseActivity<StatesWithPlacesContract.Presenter, ActivityStatesWithPlacesBinding> implements StatesWithPlacesContract.View {

    RecyclerView mRecyclerView;

    @Override
    protected int getContentResource() {
        return R.layout.activity_states_with_places;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

        mRecyclerView = (RecyclerView) findViewById(R.id.selected_places_rv_images);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        SelectedStatePlaceAdapter adapter = new SelectedStatePlaceAdapter(this);
        mRecyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);
    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }

}