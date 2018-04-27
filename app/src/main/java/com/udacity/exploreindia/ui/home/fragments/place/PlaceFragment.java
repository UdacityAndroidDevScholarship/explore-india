package com.udacity.exploreindia.ui.home.fragments.place;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentPlaceBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends BaseFragment<PlaceContract.Presenter,FragmentPlaceBinding> implements PlaceContract.View {


    public PlaceFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentResource() {
        return R.layout.fragment_place;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {

    }



}
