package com.udacity.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
