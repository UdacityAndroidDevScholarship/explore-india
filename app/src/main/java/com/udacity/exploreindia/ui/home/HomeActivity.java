package com.udacity.exploreindia.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityHomeBinding;
import com.udacity.exploreindia.helper.FragmentAdapter;
import com.udacity.exploreindia.helper.SharedPrefManager;
import com.udacity.exploreindia.helper.Utils;
import com.udacity.exploreindia.ui.home.fragments.likedplaces.LikedPlacesFragment;
import com.udacity.exploreindia.ui.home.fragments.main.MainFragment;
import com.udacity.exploreindia.ui.home.fragments.place.PlaceFragment;
import com.udacity.exploreindia.ui.home.fragments.profile.UserDetailFragment;
import com.udacity.exploreindia.ui.home.fragments.search.SearchFragment;
import com.udacity.exploreindia.ui.login.LoginActivity;


public class HomeActivity extends BaseActivity<HomeContract.Presenter, ActivityHomeBinding> implements HomeContract.View {


    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected int getContentResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

        //Set custom title in ActionBar
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText(getString(R.string.app_name).toUpperCase());
        tv.setTextSize(getResources().getDimension(R.dimen.actionBarTitleSize));
        tv.setTextColor(Color.WHITE);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/samarn.TTF");
        tv.setTypeface(tf);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        getSupportActionBar().setElevation(0);


        populateViewPager();
        setBottomNavigation();


    }

    private void populateViewPager() {
        viewPager = findViewById(R.id.view_pager);

        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(MainFragment.newInstance(), R.id.bnv_my_location);
        fragmentAdapter.addFragment(SearchFragment.newInstance(), R.id.bnv_search);
        fragmentAdapter.addFragment(PlaceFragment.newInstance(), R.id.bnv_add);
        fragmentAdapter.addFragment(LikedPlacesFragment.newInstance(), R.id.bnv_favorite);
        fragmentAdapter.addFragment(UserDetailFragment.newInstance(), R.id.bnv_profile);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.setSelectedItemId(fragmentAdapter.getIds().get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedId = item.getItemId();
        switch (selectedId) {
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                SharedPrefManager.getInstance().setLoggedIn(false);
                Intent loginIntent = new Intent(this, LoginActivity.class);
                Utils.finishExitAnimation(this, loginIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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


    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
