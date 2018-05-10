package com.udacity.exploreindia.ui.City;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.adapter.PlacesCityAdapter;
import com.udacity.exploreindia.adapter.PopularPlacesCityAdapter;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityCityBinding;

public class CityActivity extends BaseActivity<CityContract.Presenter, ActivityCityBinding> implements CityContract.View {

    private RecyclerView popularPlacesRecyclerView, placesRecyclerView;
    private LinearLayoutManager popularPlacesLayoutManager;
    private PopularPlacesCityAdapter popularPlacesCityAdapter;
    private PlacesCityAdapter placesCityAdapter;

    private StaggeredGridLayoutManager placesLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        popularPlacesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularPlacesCityAdapter = new PopularPlacesCityAdapter(this);

        popularPlacesRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_popular_places);
        popularPlacesRecyclerView.setLayoutManager(popularPlacesLayoutManager);
        popularPlacesRecyclerView.setAdapter(popularPlacesCityAdapter);

        placesLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        placesCityAdapter = new PlacesCityAdapter(this);

        placesRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_places);
        placesRecyclerView.setLayoutManager(placesLayoutManager);
        placesRecyclerView.setAdapter(placesCityAdapter);
    }

    @Override
    protected int getContentResource() {
        return R.layout.activity_city;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }
}
