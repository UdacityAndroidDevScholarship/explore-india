package com.udacity.exploreindia.ui.StatesWithCities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentStatesWithCitiesBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Arun K Babu on 10-May-18.
 */

public class StatesWithCitiesFragment extends BaseFragment<StatesWithCitiesContract.Presenter,
        FragmentStatesWithCitiesBinding> implements StatesWithCitiesContract.View
{
    private ViewPager mCitySliderViewPager;
    private LinearLayout mDotsLayout;
    private TextView[] mDots;
    private RecyclerView mSmallCityRecyclerView;
    private MajorCitiesSliderAdapter mMajorCitiesSliderAdapter;
    private Context mContext;
    private int mPosition;
    private Handler handler;

    // TODO: Delete this after linking with real data
    private ArrayList<CityData> mDummyDataSmallCities;
    private ArrayList<CityData> mDummyDataMajorCities;


    Runnable slidePositionRunnable = new Runnable() {
        public void run() {
            if (mPosition == mDummyDataMajorCities.size()) {
                mPosition = 0;
            } else {
                mPosition = mPosition + 1;
            }
            mCitySliderViewPager.setCurrentItem(mPosition, true);
        }
    };

    public StatesWithCitiesFragment(){}  // Required public constructor

    public static StatesWithCitiesFragment newInstance() {
        StatesWithCitiesFragment frag = new StatesWithCitiesFragment();
        Bundle bundle = new Bundle();
        frag.setArguments(bundle);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        mContext = getContext();
        View view = inflater.inflate(R.layout.fragment_states_with_cities, container, false);

        mCitySliderViewPager = view.findViewById(R.id.vp_major_cities_slider);
        mDotsLayout = view.findViewById(R.id.dotsLayout);
        mSmallCityRecyclerView = view.findViewById(R.id.rv_small_cities_view);

        // Populating with dummy data
        mDummyDataSmallCities = new ArrayList<>();
        mDummyDataMajorCities = new ArrayList<>();

        // TODO: Delete this after linking with real data
        for (int i=0; i<5; i++) {
            mDummyDataMajorCities.add(new CityData(R.drawable.ahmedabad, "Ahmedabad"));
        }
        for (int i=0; i<16; i++) {
            mDummyDataSmallCities.add(new CityData(R.drawable.image3, "Taj Mahal"));
        }


        // TODO: Pass in the current mPosition of the card to the cardNumber variable.
        //  Like if you are showing the 3rd card from the Adapter or similar then pass it in here so that the 3rd dot will be highlighted
        //  Also call this method where ever you are updating the mPosition of the page to update the dot mPosition like onPageScrolled()
        //  callback in PageAdapter
        int cardNumber = 3;
        addDotsIndicator(cardNumber);

        this.handler = new Handler();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(slidePositionRunnable);
            }
        }, 1000, 5000);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Populate the Top SlideView with data
        mMajorCitiesSliderAdapter = new MajorCitiesSliderAdapter(mContext, mDummyDataMajorCities);
        mCitySliderViewPager.setAdapter(mMajorCitiesSliderAdapter);
        mCitySliderViewPager.addOnPageChangeListener(pageChangeListener);

        // Populate the Bottom Small City view with data
        mSmallCityRecyclerView.setHasFixedSize(true);
        mSmallCityRecyclerView.setNestedScrollingEnabled(true);
        mSmallCityRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3, GridLayout.VERTICAL, false));
        mSmallCityRecyclerView.addItemDecoration(new GridSpacingItemDecoration(80));
        mSmallCityRecyclerView.setAdapter(new SmallCitiesAdapter(mDummyDataSmallCities));
    }

    @Override
    protected int getContentResource() {
        return 0;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {

    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mPosition = position;

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    /**
     * Adds progress dots right below the states_with_cities_top_item view
     * @param position The current mPosition of the card. This mPosition is used to determine which dot to highlight
     */
    public void addDotsIndicator(int position) {
        // TODO: Specify the total number of cards or cities here (Ex: 5)
        // The size of this mDots array defines the number of dots that will be displayed
        mDots = new TextView[5];

        mDotsLayout.removeAllViews();

        int textPadding = 26;

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(mContext);
            mDots[i].setText("•");
            mDots[i].setPadding(textPadding, 0, textPadding, 0);
            mDots[i].setTextSize(30);
            // Set the color of the dot to light grey to indicate inactive dots
            mDots[i].setTextColor(getResources().getColor(R.color.colorDotInactive));

            mDotsLayout.addView(mDots[i]);
        }

        // Set the color of the dot to grey to indicate the currently active card mPosition
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorDotActive));
            mDots[position].setTextSize(35);
            mDots[position].setPadding(textPadding, 0, textPadding, 0);
        }
    }
}
