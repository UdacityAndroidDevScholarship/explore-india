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

    private TextView tvTest;
    private PrefManager prefManager;
    private Context context = this;
    private int REQUEST_LOCATION=1;

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
        String location_permission = Manifest.permission.ACCESS_FINE_LOCATION;
        int grant = ContextCompat.checkSelfPermission(this,location_permission);
        if ( grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = location_permission;
            ActivityCompat.requestPermissions(this,permission_list,REQUEST_LOCATION);
            } else {   }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_LOCATION) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.v("Permission", "Permission: " + permissions[0] + "was " + grantResults[0]);
            } else { }
        }
    }
}
