package com.udacity.exploreindia.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityHomBinding;
import com.udacity.exploreindia.helper.FragmentAdapter;
import com.udacity.exploreindia.ui.home.fragments.likedplaces.LikedPlacesFragment;
import com.udacity.exploreindia.ui.home.fragments.main.MainFragment;
import com.udacity.exploreindia.ui.home.fragments.search.SearchFragment;


public class HomeActivity extends BaseActivity<HomeContract.Presenter, ActivityHomBinding> implements HomeContract.View {


    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected int getContentResource() {
        return R.layout.activity_hom;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        populateViewPager();
        setBottomNavigation();


    }

    private void populateViewPager() {
         viewPager = findViewById(R.id.view_pager);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(MainFragment.newInstance());
        fragmentAdapter.addFragment(SearchFragment.newInstance());
        fragmentAdapter.addFragment(MainFragment.newInstance());
        fragmentAdapter.addFragment(LikedPlacesFragment.newInstance());
        fragmentAdapter.addFragment(MainFragment.newInstance());
        viewPager.setAdapter(fragmentAdapter);
    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }


    private void setBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setSelectedItemId(R.id.my_location_fragment);
        bottomNavigationView.getMenu().findItem(R.id.bnv_my_location).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bnv_my_location:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.bnv_search:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.bnv_add:
                        viewPager.setCurrentItem(2);
                        break;

                    case R.id.bnv_favorite:
                        viewPager.setCurrentItem(3);
                        break;

                    case R.id.bnv_profile:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment selectedFragment, String tag) {

    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
