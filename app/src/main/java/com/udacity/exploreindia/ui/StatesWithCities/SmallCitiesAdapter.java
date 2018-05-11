package com.udacity.exploreindia.ui.StatesWithCities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;

import java.util.ArrayList;

public class SmallCitiesAdapter extends RecyclerView.Adapter<SmallCitiesAdapter.SmallCitiesViewHolder>
{
    private ArrayList<CityData> mSmallCitiesData;

    public SmallCitiesAdapter(ArrayList<CityData> smallCitiesData) {
        mSmallCitiesData = smallCitiesData;
    }

    @NonNull
    @Override
    public SmallCitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.states_with_cities_top_item, parent, false);
        return new SmallCitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmallCitiesViewHolder holder, int position) {
        CityData cityData = mSmallCitiesData.get(position);

        holder.smallCityImageView.setImageResource(cityData.getImageResourceId());
        holder.smallCityTextView.setText(cityData.getPlaceName());
    }

    @Override
    public int getItemCount() {
        return mSmallCitiesData.size();
    }


    /**
     * Recycler view adapter requires a ViewHolder. So it's created as an inner class
     */
    class SmallCitiesViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView smallCityImageView;
        private TextView smallCityTextView;

        public SmallCitiesViewHolder(View itemView) {
            super(itemView);
            this.smallCityImageView = itemView.findViewById(R.id.iv_small_city_photo);
            this.smallCityTextView = itemView.findViewById(R.id.tv_small_city_name);
        }
    }
}
