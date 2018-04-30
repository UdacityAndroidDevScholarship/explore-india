package com.udacity.exploreindia.ui.home.fragments.placedetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.adapters.ImagePagerAdapter;
import com.udacity.exploreindia.base.BaseFragment;
import com.udacity.exploreindia.databinding.FragmentPlaceDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceDetailFragment extends BaseFragment<PlaceDetailContract.Presenter,FragmentPlaceDetailBinding> implements PlaceDetailContract.View {

    private ImageView[] mImageSlideDotIndicators;
    private int imageSlideDotsCount;
    public PlaceDetailFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentResource() {
        return R.layout.fragment_place_detail;
    }

    @Override
    protected void init(View view, @Nullable Bundle savedInstanceState) {

        //Code for image slider
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getActivity());
        ViewPager imageViewPager = view.findViewById(R.id.places_details_vp_images);
        imageViewPager.setAdapter(imagePagerAdapter);
        //No of slides
        imageSlideDotsCount = imagePagerAdapter.getCount();
        mImageSlideDotIndicators = new ImageView[imageSlideDotsCount];
        //Container for dots indicator
        LinearLayout imageSliderDotsContainer = view.findViewById(R.id.places_details_ll_image_dots_indicator);
        //setting up the dots indicator
        for(int i = 0; i< imageSlideDotsCount; i++){
            mImageSlideDotIndicators[i] = new ImageView(getActivity());
            mImageSlideDotIndicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.dots_indicator_inactive));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(32, 0, 32, 0);

            imageSliderDotsContainer.addView(mImageSlideDotIndicators[i], params);
        }
        //setting the first dot as active
        mImageSlideDotIndicators[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.dots_indicator_active));

        //setting page change listener to view pager
        imageViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //resetting the dots to inactive state
                for(int i = 0; i< imageSlideDotsCount; i++){
                    mImageSlideDotIndicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.dots_indicator_inactive));
                }
                //setting the active dot for the current page
                mImageSlideDotIndicators[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.dots_indicator_active));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Place Description
        TextView placeDescriptionTextView = view.findViewById(R.id.places_details_tv_place_description);
        placeDescriptionTextView.setText(R.string.dummy_place_description);
    }



}
