package com.udacity.exploreindia.ui.login;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<LoginContract.Presenter,ActivityLoginBinding> implements LoginContract.View {


    @Override
    protected int getContentResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }
}
