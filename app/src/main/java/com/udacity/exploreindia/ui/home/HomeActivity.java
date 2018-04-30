package com.udacity.exploreindia.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityHomBinding;
import com.udacity.exploreindia.ui.home.fragments.placedetail.PlaceDetailFragment;

public class HomeActivity extends BaseActivity<HomeContract.Presenter, ActivityHomBinding> implements HomeContract.View {



    @Override
    protected int getContentResource() {
        return R.layout.activity_hom;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(getString(R.string.taj_mahal),1);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        //Sample code to inflate PlaceDetailFragment and can be changed later
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new PlaceDetailFragment())
                    .commit();
        }
    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }
}
