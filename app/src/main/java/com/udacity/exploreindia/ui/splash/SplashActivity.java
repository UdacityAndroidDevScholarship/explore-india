package com.udacity.exploreindia.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.repo.PreferenceRepository;
import com.udacity.exploreindia.ui.main.MainActivity;
import com.udacity.exploreindia.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {
    PreferenceRepository prefRepo;
    Context context = this;

    int secondsDelayed = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefRepo = new PreferenceRepository(context);
        if (prefRepo.isFirstTimeLaunch()) {
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
