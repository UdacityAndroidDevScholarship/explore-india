package com.udacity.exploreindia.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udacity.exploreindia.R;

public class ImagePagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImages = {R.drawable.taj_mahal, R.drawable.taj_mahal, R.drawable.taj_mahal};

    public ImagePagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_slider_layout, container, false);
        ImageView imageView = view.findViewById(R.id.places_details_list_img_images);
        imageView.setImageResource(mImages[position]);

        ViewPager viewPager = (ViewPager)container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
