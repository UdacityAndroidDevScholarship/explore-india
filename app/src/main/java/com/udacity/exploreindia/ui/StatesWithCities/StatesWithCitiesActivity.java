package com.udacity.exploreindia.ui.StatesWithCities;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityStatesWithCitiesBinding;

import java.util.ArrayList;
import java.util.List;

public class StatesWithCitiesActivity extends BaseActivity<StatesWithCitiesContract.Presenter,
        ActivityStatesWithCitiesBinding> implements StatesWithCitiesContract.View
{
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_with_cities);

        // TODO: Needs to be deleted after proper implementation of TabLayout
        viewPager = findViewById(R.id.vp_cities_fragment_container);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(StatesWithCitiesFragment.newInstance(), "Cities");
        viewPager.setAdapter(viewPagerAdapter);


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

    // TODO: Needs to be deleted after proper implementation of TabLayout
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
