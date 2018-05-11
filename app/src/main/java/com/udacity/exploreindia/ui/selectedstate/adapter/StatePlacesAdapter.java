package com.udacity.exploreindia.ui.selectedstate.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;

/**
 * Created by Divya on 30-04-2018.
 */

public class StatePlacesAdapter extends RecyclerView.Adapter<StatePlacesAdapter.ViewHolder> {
    private Context context;

    /*TODO
     * 1. add the arrayList in the Constructor
     * */
    public StatePlacesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.places_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //TODO Remove this code when fetch the data from the server
        if (position % 2 == 0)
            holder.mIvPlaceImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.gateway_of_india));
        else
            holder.mIvPlaceImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.gateway_of_india_small));

        holder.mTvPlaceName.setText("Diu Daman");
        holder.mIvIsFavorite.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_action_favorite_fill));
    }


    @Override
    public int getItemCount() {
        //TODO Change this to -> arrayListObject.size()
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvPlaceImage;
        private TextView mTvPlaceName;
        private ImageView mIvIsFavorite;

        ViewHolder(View itemView) {
            super(itemView);
            mIvPlaceImage = itemView.findViewById(R.id.iv_state_place_image);
            mTvPlaceName = itemView.findViewById(R.id.tv_state_place_name);
            mIvIsFavorite = itemView.findViewById(R.id.iv_state_place_favourite);
        }
    }

}
