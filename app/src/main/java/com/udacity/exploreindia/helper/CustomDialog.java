package com.udacity.exploreindia.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.exploreindia.R;


public class CustomDialog extends AlertDialog {
    private String message;
    private Context mContext;

    public CustomDialog(Context context) {
        super(context);
        mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=View.inflate(mContext,R.layout.dialog_layout,null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        Animation animation = AnimationUtils.loadAnimation(mContext,
                R.anim.anim_rotate_clockwise);
        image.setAnimation(animation);
        TextView dialogMessage = (TextView) view.findViewById(R.id.dialog_message);
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/samarn.TTF");
        dialogMessage.setTypeface(typeface);

        final Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setContentView(view);
        setCancelable(false);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
