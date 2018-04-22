package com.udacity.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.udacity.exploreindia.helper.PrefManager;

public class WelcomeActivity extends AppCompatActivity {

    //Request code for location permission
    private static final int REQUEST_CODE = 1;

    TextView tvTest;
    PrefManager prefManager;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvTest = findViewById(R.id.a_welcome_tv_test);
        prefManager = new PrefManager(context);

        //call for checking the location permission
        checkLocationPermission();

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.setFirstTimeLaunch(false);
                Intent intent = new Intent(context, SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void checkLocationPermission() {
        //Check for the location permission here.
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            //if permission is not granted, request for permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE);

        } else {
                // Permission is already granted. Do the next operation
            }

        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE: if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.v("Permission", "Permission: " + permissions[0] + "was " + grantResults[0]);
                //resume tasks needing this permission
            } else {
                //permission denied! Disable the functionality which uses this permission.
            }
        }
    }
}
