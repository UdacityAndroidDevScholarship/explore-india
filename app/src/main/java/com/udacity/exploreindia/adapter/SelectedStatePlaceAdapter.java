package com.udacity.exploreindia.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;

/**
 * Created by kamalshree on 5/9/2018.
 */

public class SelectedStatePlaceAdapter extends RecyclerView.Adapter<SelectedStatePlaceAdapter.ImageViewHolder> {

    private final Context mContext;

    //sample data this can be changed later
    private int[] likedImages = {R.drawable.gujarat1, R.drawable.gujarat2, R.drawable.gujarat3, R.drawable.gujarat4, R.drawable.gujarat5, R.drawable.gujarat6, R.drawable.gujarat7, R.drawable.gujarat8, R.drawable.gujarat5};
    private String[] mplace = {"Bharuch", "Vadodara", "Akshardham", "Sarkhej Roza", "Nagina Masjid", "Akshardham", "Gandhinagar", "Rajkot", "Nagina Masjid"};

    public SelectedStatePlaceAdapter(Context context) {
        mContext = context;

    }

    @Override
    public SelectedStatePlaceAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item_list, parent, false);
        return new SelectedStatePlaceAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectedStatePlaceAdapter.ImageViewHolder holder, int position) {
        holder.itemImage.setImageResource(likedImages[position]);
        holder.placeName.setText(mplace[position]);
    }

    @Override
    public int getItemCount() {
        return likedImages.length;
    }


    protected class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView placeName;

        public ImageViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.selected_places_list_images);
            placeName = (TextView) itemView.findViewById(R.id.selected_places_tv_name);
        }
    }

}