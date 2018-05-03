package com.udacity.exploreindia.ui.home.fragments.search;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentMainBinding;
import com.udacity.exploreindia.ui.home.HomeActivity;
import com.udacity.exploreindia.ui.home.adapters.SearchRVAdapter;
import com.udacity.exploreindia.ui.home.fragments.main.MainContract;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment<MainContract.Presenter,FragmentMainBinding> implements MainContract.View {

    private RecyclerView rvPopularCities;
    private RecyclerView rvPopularPlaces;
    private ArrayList<SearchModel> lPopularCites;
    private ArrayList<SearchModel> lPopularPlaces;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((HomeActivity) getActivity())
                .setActionBarTitle("Search");
    }

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        rvPopularCities = view.findViewById(R.id.rv_popular_cities);
        rvPopularPlaces = view.findViewById(R.id.rv_popular_places);

        lPopularCites = new ArrayList<>();
        lPopularPlaces = new ArrayList<>();

        locationPlaceHolder();

        // method for adding indicators
        final Handler handler = new Handler();

        return view;
    }

    private void locationPlaceHolder() {
        for (int i = 0; i<6; i++){
            lPopularCites.add(new SearchModel("Gateway of India", "600m", true));
            lPopularPlaces.add(new SearchModel("Gateway of India", "600m", true));
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //locationPlaceHolder();
        rvPopularCities.setHasFixedSize(true);
        rvPopularCities.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayout.HORIZONTAL));
        rvPopularCities.setAdapter(new SearchRVAdapter(getActivity(), lPopularCites));

        rvPopularPlaces.setHasFixedSize(true);
        rvPopularPlaces.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayout.HORIZONTAL));
        rvPopularPlaces.setAdapter(new SearchRVAdapter(getActivity(), lPopularCites));

    }

    @Override
    protected int getContentResource() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {

    }
}
