package com.udacity.exploreindia.ui.home.fragments.likedplaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.adapter.LikedImageAdapter;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.databinding.FragmentLikedPlacesBinding;

/**
 * Created by kamalshree on 5/3/2018.
 */

public class LikedPlacesFragment extends BaseFragment<LikedPlacesContract.Presenter,FragmentLikedPlacesBinding> implements LikedPlacesContract.View{

    LikedImageAdapter likedImageAdapter;
    public LikedPlacesFragment() {
    }

    public static LikedPlacesFragment newInstance() {
        LikedPlacesFragment fragment = new LikedPlacesFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getContentResource() {
        return R.layout.fragment_liked_places;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {
        likedImageAdapter = new LikedImageAdapter(getContext());

        RecyclerView myrecyclerview = view.findViewById(R.id.liked_places_rv_images);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        myrecyclerview.setAdapter(likedImageAdapter);
    }
}
