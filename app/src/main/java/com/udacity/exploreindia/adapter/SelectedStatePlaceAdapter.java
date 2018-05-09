package com.udacity.exploreindia.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;

/**
 * Created by kamalshree on 5/9/2018.
 */

public class SelectedStatePlaceAdapter extends ArrayAdapter<Integer> {

    Context context;
    LayoutInflater inflater;
    int layoutResourceId;
    float imageWidth;

    public SelectedStatePlaceAdapter(Context context, int layoutResourceId, Integer[] items, String[] placename) {
        super(context, layoutResourceId, items);
        this.context = context;
        this.layoutResourceId = layoutResourceId;

        float width = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
        float margin = (int) convertDpToPixel(10f, (Activity) context);
        // two images, three margins of 10dips
        imageWidth = ((width - (3 * margin)) / 2);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ConstraintLayout row = (ConstraintLayout) convertView;
        ItemHolder holder;
        Integer item = getItem(position);

        if (row == null) {
            holder = new ItemHolder();
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = (ConstraintLayout) inflater.inflate(layoutResourceId, parent, false);
            ImageView itemImage = (ImageView) row.findViewById(R.id.item_image);
            ImageView itemBackground = (ImageView) row.findViewById(R.id.selected_img_background);
            TextView placeName = (TextView) row.findViewById(R.id.place_name);
            ImageView heartImage = (ImageView) row.findViewById(R.id.heart_image);

            holder.itemImage = itemImage;
            holder.itemBackground = itemBackground;
            holder.placeName = placeName;
            holder.heartImage = heartImage;
        } else {
            holder = (ItemHolder) row.getTag();
        }

        row.setTag(holder);
        setImageBitmap(item, holder.itemImage);
        return row;
    }

    public static class ItemHolder {
        ImageView itemImage;
        ImageView itemBackground;
        TextView placeName;
        ImageView heartImage;
    }

    // resize the image proportionately so it fits the entire space
    private void setImageBitmap(Integer item, ImageView imageView) {
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), item);
        float i = ((float) imageWidth) / ((float) bitmap.getWidth());
        float imageHeight = i * (bitmap.getHeight());
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
        params.height = (int) imageHeight;
        params.width = (int) imageWidth;
        imageView.setLayoutParams(params);
        imageView.setImageResource(item);
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}