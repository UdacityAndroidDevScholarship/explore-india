package com.udacity.exploreindia.ui.splash;


import android.content.Intent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivitySplashBinding;
import com.udacity.exploreindia.ui.home.HomeActivity;
import com.udacity.exploreindia.helper.SharedPrefManager;
import com.udacity.exploreindia.helper.Utils;
import com.udacity.exploreindia.ui.home.HomeActivity;
import com.udacity.exploreindia.ui.login.LoginActivity;


public class SplashActivity extends BaseActivity<SplashContract.Presenter, ActivitySplashBinding> implements SplashContract.View {


    @Override
    protected int getContentResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

        setAnimation();
        getPresenter().initCountDown();


    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }


    @Override
    public void moveToHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        Utils.finishEntryAnimation(this, intent);
    }

    @Override
    public void moveToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        Utils.finishEntryAnimation(this, intent);
    }

    @Override
    public void setAnimation() {

        // Set font in Title
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/samarn.TTF");
        getDataBinder().title.setTypeface(typeface);

        Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_fade_in_rotate_clockwise);

        // rotate Left upper image
        getDataBinder().imageLeft.setAnimation(animation);
        // rotate Right upper image
        getDataBinder().imageRight.setAnimation(animation);

        getDataBinder().frameLogo.animate().alpha(1).setDuration(1000);

    }
}
