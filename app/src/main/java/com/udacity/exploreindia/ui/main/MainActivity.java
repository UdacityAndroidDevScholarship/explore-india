package com.udacity.exploreindia.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewModel();
    }

    private void setupViewModel() {
        MainViewModel.Factory factory = new MainViewModel.Factory();
        viewModel = ViewModelProviders.of(MainActivity.this, factory).get(MainViewModel.class);
    }
}
