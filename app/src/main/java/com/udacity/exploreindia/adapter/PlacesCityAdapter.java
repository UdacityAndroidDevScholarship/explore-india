package com.udacity.exploreindia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;

public class PlacesCityAdapter extends RecyclerView.Adapter<PlacesCityAdapter.PlacesCityViewHolder> {

    private final Context mContext;
    private String[] imageTitles = {"Sabarmati Riverfront", "Sabarmati Riverfront", "Sabarmati Riverfront"
            , "Koteshwar Mahadev Temple", "Sabarmati Ashram", "Sabarmati Riverfront",
            "Kankaria Lake"};

    private int[] imageIds = {R.drawable.image1, R.drawable.image2, R.drawable.login_page_bg,
            R.drawable.image1, R.drawable.image3, R.drawable.image2, R.drawable.image1};

    public PlacesCityAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public PlacesCityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.places_list_item, parent, false);

        return new PlacesCityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesCityViewHolder holder, int position) {
        String imgTitle = imageTitles[position];
        int imgId = imageIds[position];

        holder.placesCityTextView.setText(imgTitle);
        holder.placesCityImageView.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        return imageTitles.length;
    }

    public class PlacesCityViewHolder extends RecyclerView.ViewHolder {

        public ImageView placesCityImageView;
        public TextView placesCityTextView;

        public PlacesCityViewHolder(View itemView) {
            super(itemView);

            placesCityImageView = (ImageView) itemView.findViewById(R.id.imageView_places_city);
            placesCityTextView = (TextView) itemView.findViewById(R.id.textView_places_city);
        }
    }
}
