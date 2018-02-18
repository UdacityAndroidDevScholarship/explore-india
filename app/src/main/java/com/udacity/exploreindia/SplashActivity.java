package com.udacity.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.exploreindia.helper.PrefManager;

public class SplashActivity extends AppCompatActivity {

    // "PrefManager" used in app to store data locally (eg. firstLaunch)
    PrefManager prefManager;
    Context context = this;

    // "secondsDelayed = (seconds)" used to delay while moving from splash screen
    int secondsDelayed = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // -                                                                                         declarations
        prefManager = new PrefManager(context);

        // TODO: (In future) can fetch updated list of States and CityTown supported.
        // TODO: (In future) check app updated needed.

        // -                                                                                         actions
        
        // Checking app Launched First Time
        if (prefManager.isFirstTimeLaunch()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    /*
                     * if first time launch move activity to WelcomeActivity
                     *
                     * On WelcomeActivity:
                     *   Introduction to application
                     *   Getting permission from user (eg. Location permission).
                     */

                    startActivity(new Intent(context, WelcomeActivity.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    // if not first time launch move activity to MainActivity

                    startActivity(new Intent(context, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }
    }
}
