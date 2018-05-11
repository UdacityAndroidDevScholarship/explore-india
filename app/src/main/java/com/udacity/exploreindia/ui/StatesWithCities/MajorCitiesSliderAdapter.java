package com.udacity.exploreindia.ui.StatesWithCities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.exploreindia.R;

import java.util.ArrayList;

/**
 * Created by Arun K Babu on 10-May-18.
 */

public class MajorCitiesSliderAdapter extends PagerAdapter
{
    private Context mContext;
    private ArrayList<CityData> mMajorCitiesData;

    public MajorCitiesSliderAdapter (Context context, ArrayList<CityData> majorCitiesData) {
        mContext = context;
        mMajorCitiesData = majorCitiesData;
    }

    @Override
    public int getCount() {
        return mMajorCitiesData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.states_with_cities_top_item, container, false);

        ImageView cityImage = view.findViewById(R.id.iv_city_photo);
        TextView cityName = view.findViewById(R.id.tv_city_name);

        CityData cityData = mMajorCitiesData.get(position);

        Picasso.with(mContext)
                .load(cityData.getImageResourceId())
                .placeholder(R.drawable.ic_search) // TODO: Set the placeholder image if no image loaded
                .error(R.drawable.ic_add_box)      // TODO: Set the error image in-case load fails
                .into(cityImage);

        cityName.setText(cityData.getPlaceName());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
