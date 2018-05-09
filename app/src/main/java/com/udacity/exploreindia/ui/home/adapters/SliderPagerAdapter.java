package com.udacity.exploreindia.ui.home.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.udacity.exploreindia.R;

import java.util.ArrayList;

/**
 * Created by Divya on 30-04-2018.
 */

public class SliderPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> lSliderImage;

    public SliderPagerAdapter(Context context, ArrayList<Integer> list_images) {
        this.context = context;
        this.lSliderImage = list_images;
    }

    @Override
    public int getCount() {
        return lSliderImage.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_location_layout, container, false);

        ImageView imgSlider = view.findViewById(R.id.my_location_img_places);
        Picasso.with(context)
                .load(lSliderImage.get(position))
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher)         // optional
                .into(imgSlider);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
