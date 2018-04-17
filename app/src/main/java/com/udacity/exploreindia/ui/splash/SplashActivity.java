package com.udacity.exploreindia.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.exploreindia.Data.AppDataManager;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.WelcomeActivity;
import com.udacity.exploreindia.ui.main.MainActivity;
import com.udacity.exploreindia.utils.ProvideDataManagerInst;

public class SplashActivity extends AppCompatActivity {
    Context context = this;

    int secondsDelayed = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppDataManager manager = ProvideDataManagerInst.provideDataSource(this);
        if (manager.isFirstTimeLaunch()) {
            manager.setFirstTimeLaunch(false);
            startActivity(new Intent(context, WelcomeActivity.class));
            finish();
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
