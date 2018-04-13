package com.udacity.exploreindia.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.repo.PreferenceRepository;
import com.udacity.exploreindia.ui.main.MainActivity;
import com.udacity.exploreindia.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SECONDS_DELAYED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        PreferenceRepository prefRepo = PreferenceRepository.getInstance(getApplicationContext());

        if (prefRepo.isFirstTimeLaunch()) launchActivity(WelcomeActivity.class);
        else launchActivity(MainActivity.class);
    }

    private void launchActivity(final Class activityClass) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, activityClass));
                finish();
            }
        }, SECONDS_DELAYED * 1000);
    }
}
