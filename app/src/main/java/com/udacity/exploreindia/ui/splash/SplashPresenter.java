package com.udacity.exploreindia.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.databinding.ActivitySplashBinding;
import com.udacity.exploreindia.helper.SharedPrefManager;
import com.udacity.exploreindia.helper.Utils;
import com.udacity.exploreindia.ui.home.HomeActivity;
import com.udacity.exploreindia.ui.login.LoginActivity;


public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private int secondsDelayed = 5;
    private Context mContext;

    public SplashPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context context) {
        super(mSharedPreferences, mBaseRepo, context);
        mContext = context;
    }

    @Override
    public void init() {

    }

    @Override
    public void initCountDown() {
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          if (getSharedPreferences().isFirstTimeLaunch()) {
                                              Intent intent = new Intent(mContext, HomeActivity.class);
                                              Utils.finishEntryAnimation(mContext, intent);
                                          } else {
                                              Intent intent = new Intent(mContext, LoginActivity.class);
                                              Utils.finishEntryAnimation(mContext, intent);
                                          }
                                      }
                                  },
                secondsDelayed * 1000);
    }

    @Override
    public void setAnimation(ActivitySplashBinding activitySplashBinding, Context context) {

        // Set font in Title
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/samarn.TTF");
        activitySplashBinding.title.setTypeface(typeface);

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_fade_in_rotate_clockwise);

        // rotate Left upper image
        activitySplashBinding.imageLeft.setAnimation(animation);
        // rotate Right upper image
        activitySplashBinding.imageRight.setAnimation(animation);

        activitySplashBinding.frameLogo.animate().alpha(1).setDuration(1000);
    }
}






