package com.udacity.exploreindia.adapter;

// Created by GauravR31 on 09/05/2018

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;

public class PopularPlacesCityAdapter extends RecyclerView.Adapter<PopularPlacesCityAdapter.PopularPlacesCityViewHolder> {

    private final Context mContext;
    private String[] imageTitles = {"Sabarmati Riverfront", "Sabarmati Riverfront", "Sabarmati Riverfront",
            "Koteshwar Mahadev Temple", "Sabarmati Ashram", "Sabarmati Riverfront", "Kankaria Lake"};

    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image1, R.drawable.image3, R.drawable.image2, R.drawable.login_page_bg};

    public PopularPlacesCityAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public PopularPlacesCityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.popular_places_list_item, parent, false);

        return new PopularPlacesCityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularPlacesCityViewHolder holder, int position) {
        String imgTitle = imageTitles[position];
        int imgId = imageIds[position];

        holder.popularPlacesCityTextView.setText(imgTitle);
        holder.popularPlacesCityImageView.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        return imageTitles.length;
    }

    public class PopularPlacesCityViewHolder extends RecyclerView.ViewHolder {

        public ImageView popularPlacesCityImageView;
        public TextView popularPlacesCityTextView;

        public PopularPlacesCityViewHolder(View itemView) {
            super(itemView);

            popularPlacesCityImageView = (ImageView) itemView.findViewById(R.id.imageView_popular_places_city);
            popularPlacesCityTextView = (TextView) itemView.findViewById(R.id.textView_popular_places_city);
        }
    }
}
