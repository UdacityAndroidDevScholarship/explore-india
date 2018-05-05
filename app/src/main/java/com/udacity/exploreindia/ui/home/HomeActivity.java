package com.udacity.exploreindia.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityHomBinding;
import com.udacity.exploreindia.ui.home.fragments.likedplaces.LikedPlacesFragment;


public class HomeActivity extends BaseActivity<HomeContract.Presenter, ActivityHomBinding> implements HomeContract.View {



    @Override
    protected int getContentResource() {
        return R.layout.activity_hom;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new LikedPlacesFragment())
                    .commit();
        }

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }
}
