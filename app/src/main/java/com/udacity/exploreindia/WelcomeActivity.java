package com.udacity.exploreindia;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.udacity.exploreindia.helper.PrefManager;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvTest;
    PrefManager prefManager;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvTest = findViewById(R.id.a_welcome_tv_test);
        prefManager = new PrefManager(context);

        locationPermissionCheck();

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

    public void locationPermissionCheck() {
        String[] location_permission = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,location_permission,1);
        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.v("Permission", "Permission: " + permissions[0] + "was " + grantResults[0]);
            } else { }
        }
    }
}
