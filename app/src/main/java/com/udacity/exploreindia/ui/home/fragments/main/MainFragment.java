package com.udacity.exploreindia.ui.home.fragments.main;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentMainBinding;
import com.udacity.exploreindia.ui.home.adapters.MyLocationsRVAdapter;
import com.udacity.exploreindia.ui.home.adapters.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<MainContract.Presenter,FragmentMainBinding> implements MainContract.View {

    private Context context;
    private RecyclerView rvMyLocations;
    private ArrayList<MyLocationsModel> lMyLocations;

    private ViewPager vpSlider;
    private LinearLayout lDots;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<Integer> lSliderImage;
    private TextView[] dots;
    int pagePosition = 0;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        context = getContext();
        vpSlider = view.findViewById(R.id.vp_image_slider);
        lDots = view.findViewById(R.id.ll_dots);

        lSliderImage = new ArrayList<>();
        rvMyLocations = view.findViewById(R.id.my_location_rv_places);
        lMyLocations = new ArrayList<>();

        locationPlaceHolder();

        addBottomDots(0);


        // method for adding indicators
        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (pagePosition == lSliderImage.size()) {
                    pagePosition = 0;
                } else {
                    pagePosition = pagePosition + 1;
                }
                vpSlider.setCurrentItem(pagePosition, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);

        return view;
    }

    private void locationPlaceHolder() {
        for (int i = 0; i<6; i++){
            lMyLocations.add(new MyLocationsModel("Gateway of India", "600m", true));
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //locationPlaceHolder();
        rvMyLocations.setHasFixedSize(true);
        rvMyLocations.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        rvMyLocations.setAdapter(new MyLocationsRVAdapter(context, lMyLocations));

        lSliderImage.add(R.drawable.gateway_of_india_strech);
        lSliderImage.add(R.drawable.gateway_of_india_strech);
        lSliderImage.add(R.drawable.gateway_of_india_strech);


        sliderPagerAdapter = new SliderPagerAdapter(context, lSliderImage);
        vpSlider.setAdapter(sliderPagerAdapter);

        vpSlider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[lSliderImage.size()];

        lDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(40);
            dots[i].setTextColor(Color.parseColor("#8ff7f5f5"));
            lDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    protected int getContentResource() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {

    }
}