package com.udacity.exploreindia.ui.selectedstate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivitySelectedStateBinding;
import com.udacity.exploreindia.ui.home.HomeContract;
import com.udacity.exploreindia.ui.selectedstate.adapter.SelectedStateVPAdapter;
import com.udacity.exploreindia.ui.selectedstate.fragment.SelectedPlacesFragment;

public class SelectedStateActivity extends BaseActivity<HomeContract.Presenter, ActivitySelectedStateBinding> implements HomeContract.View {

    private ViewPager mVpSelectedState;
    private TabLayout mTabSelectedState;

    @Override
    protected int getContentResource() {
        return R.layout.activity_selected_state;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        mVpSelectedState = findViewById(R.id.vp_selected_state);
        mTabSelectedState = findViewById(R.id.tb_selected_state);
        //Set up the view pager
        setupViewPager(mVpSelectedState);
        //set up the tab layout with the tab layout
        mTabSelectedState.setupWithViewPager(mVpSelectedState);
    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }

    private void setupViewPager(ViewPager viewPager) {
        SelectedStateVPAdapter adapter = new SelectedStateVPAdapter(getSupportFragmentManager());
        adapter.addFragment(SelectedPlacesFragment.newInstance(), getString(R.string.tab_places_title));
        //TODO
        //Add the City fragment here
        adapter.addFragment(SelectedPlacesFragment.newInstance(), getString(R.string.tab_city_title));
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }
}