package com.udacity.exploreindia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private Context mContext;

    private int mSecondsDelayed = 5000;  // 5 seconds

    private RelativeLayout transitionsContainer;
    private ImageView imageLeft;
    private ImageView imageRight;
    private RelativeLayout frameLogo;
    private ImageView imageWomen;
    private TextView title;
    private TextView privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViews();
        initialize();
        setAnimation();

        // Set Font samarn.TTF in Title
        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/samarn.TTF");
        title.setTypeface(typeface);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(mContext,HomeScreen.class);
                startActivity(intent);
                Utils.finishEntryAnimation(mContext);
            }
        },mSecondsDelayed);


    }

    /**
     * Initialize all Member variables here
     */
    private void initialize() {
        mContext = SplashActivity.this;
    }

    private void setAnimation() {
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.fade_in_rotate_clockwise);

        imageLeft.setAnimation(animation); // rotate Left upper image
        imageRight.setAnimation(animation); // rotate Right upper image

        frameLogo.animate().alpha(1).setDuration(1000);
    }

    /**
     * Finding all Views in Layout
     */
    private void findViews() {
        transitionsContainer = (RelativeLayout) findViewById(R.id.transitionsContainer);
        imageLeft = (ImageView) findViewById(R.id.imageLeft);
        imageRight = (ImageView) findViewById(R.id.imageRight);
        frameLogo = (RelativeLayout) findViewById(R.id.frameLogo);
        imageWomen = (ImageView) findViewById(R.id.imageWomen);
        title = (TextView) findViewById(R.id.title);
        privacy = (TextView) findViewById(R.id.privacy);

    }
}
