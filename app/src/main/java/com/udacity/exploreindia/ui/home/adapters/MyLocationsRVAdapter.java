package com.udacity.exploreindia.ui.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.ui.home.fragments.main.MyLocationsModel;

import java.util.ArrayList;

/**
 * Created by Divya on 30-04-2018.
 */

public class MyLocationsRVAdapter extends RecyclerView.Adapter<MyLocationsRVAdapter.ViewHolder> {
    private Context context;
    private MyLocationsModel myLocationsModel;
    private ArrayList<MyLocationsModel> list_my_loctions;

    public MyLocationsRVAdapter(Context context, ArrayList<MyLocationsModel> list_my_loctions) {
        this.context = context;
        this.list_my_loctions = list_my_loctions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_location_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        myLocationsModel = list_my_loctions.get(position);

        if(position%2==0)
            holder.iv_location.setImageResource(R.drawable.gateway_of_india);
        else
            holder.iv_location.setImageResource(R.drawable.gateway_of_india_small);

        if (myLocationsModel.isFavorite())
            holder.isFavorite.setImageResource(R.drawable.ic_action_favorite_fill);
        else
            holder.isFavorite.setImageResource(R.drawable.ic_action_favorite);


        holder.tv_locationName.setText(myLocationsModel.getLoctionName());
        holder.tv_locationDistance.setText(myLocationsModel.getLocationDistance());
    }


    @Override
    public int getItemCount() {
        return list_my_loctions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_location;
        private TextView tv_locationName, tv_locationDistance;
        private ImageView isFavorite;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_location = itemView.findViewById(R.id.my_location_img_places);
            tv_locationName = itemView.findViewById(R.id.loaction_tv_name);
            tv_locationDistance = itemView.findViewById(R.id.loaction_tv_distance);
            isFavorite = itemView.findViewById(R.id.loaction_img_favorite);
        }
    }

}
