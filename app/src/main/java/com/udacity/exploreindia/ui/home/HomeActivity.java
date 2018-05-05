package com.udacity.exploreindia.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityHomBinding;
import com.udacity.exploreindia.ui.home.fragments.likedplaces.LikedPlacesFragment;
import com.udacity.exploreindia.ui.home.fragments.main.MainFragment;


public class HomeActivity extends BaseActivity<HomeContract.Presenter, ActivityHomBinding> implements HomeContract.View {

    private long lastBackPressTime;
    private FragmentTransaction fragmentTransaction;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected int getContentResource() {
        return R.layout.activity_hom;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setBottomNavigation();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new LikedPlacesFragment())
                    .commit();
        }


      
    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }

  

    private void setBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        replaceFragment(MainFragment.newInstance(), "My Location");
        bottomNavigationView.setSelectedItemId(R.id.my_location_fragment);
        bottomNavigationView.getMenu().findItem(R.id.bnv_my_location).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bnv_my_location :
                        replaceFragment(MainFragment.newInstance(), "My Locations");
                        break;

                    case R.id.bnv_search :
                        showMessage("Search not implemented yet");
                        break;

                    case R.id.bnv_add :
                        showMessage("Add not implemented yet");
                        break;

                    case R.id.bnv_favorite :
                        replaceFragment(LikedPlacesFragment.newInstance(), "Favorite");
                        break;

                    case R.id.bnv_profile :
                        showMessage("Profile not implemented yet");
                        break;
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment selectedFragment, String tag){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_dashboard_container, selectedFragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
