package com.udacity.exploreindia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.udacity.exploreindia.R;

/**
 * Created by kamalshree on 5/3/2018.
 */

public class LikedImageAdapter extends RecyclerView.Adapter<LikedImageAdapter.ImageViewHolder> {

    private final Context mContext;

    //sample data
    private int[] likedImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private String[] mplace = {"Gate of India", "Bahai of Lotus", "Taj Mahal"};
    private String[] mlike = {"7,234", "5,344", "3,433"};
    private String[] mdate = {"27-03-2017", "25-08-2017", "18-09-2017"};

    public LikedImageAdapter(Context context) {
        mContext = context;

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.images_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.liked_images.setImageResource(likedImages[position]);
        holder.place_name.setText(mplace[position]);
        holder.like_val.setText(mlike[position]);
        holder.date_val.setText(mdate[position]);
    }

    @Override
    public int getItemCount() {
        return likedImages.length;
    }


    protected class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView liked_images;
        TextView place_name,like_val,date_val;

        public ImageViewHolder(View itemView) {
            super(itemView);
            liked_images = (ImageView) itemView.findViewById(R.id.liked_places_list_images);
            place_name=(TextView) itemView.findViewById(R.id.liked_place_tv_name);
            like_val=(TextView) itemView.findViewById(R.id.liked_place_tv_like);
            date_val=(TextView) itemView.findViewById(R.id.liked_place_tv_date);
        }
    }
}