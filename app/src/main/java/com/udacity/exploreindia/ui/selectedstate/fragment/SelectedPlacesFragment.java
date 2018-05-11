package com.udacity.exploreindia.ui.selectedstate.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentSelectedPlacesBinding;
import com.udacity.exploreindia.ui.selectedstate.adapter.StatePlacesAdapter;


public class SelectedPlacesFragment extends BaseFragment<SelectedPlacesContract.Presenter, FragmentSelectedPlacesBinding> implements SelectedPlacesContract.View {

    public SelectedPlacesFragment() {
        // Required empty public constructor
    }

    public static SelectedPlacesFragment newInstance() {
        SelectedPlacesFragment fragment = new SelectedPlacesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentResource() {
        return R.layout.fragment_selected_places;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {
        //initializations
        RecyclerView mRvSelectedPlaces = view.findViewById(R.id.rv_selected_state_places);
        //set up the RecyclerView
        mRvSelectedPlaces.setHasFixedSize(true);
        mRvSelectedPlaces.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        mRvSelectedPlaces.setAdapter(new StatePlacesAdapter(getContext()));
    }
}
