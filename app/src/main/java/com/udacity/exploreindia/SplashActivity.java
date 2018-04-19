package com.udacity.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.exploreindia.helper.PrefManager;

    public class SplashActivity extends AppCompatActivity {
        PrefManager prefManager;
        Context context = this;

        int secondsDelayed = 1;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefManager = new PrefManager(context);
        if (prefManager.isFirstTimeLaunch()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(context, WelcomeActivity.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(context, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }
    }
}
