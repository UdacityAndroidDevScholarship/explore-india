package com.udacity.exploreindia.ui.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityLoginBinding;
import com.udacity.exploreindia.helper.SharedPrefManager;
import com.udacity.exploreindia.helper.Utils;
import com.udacity.exploreindia.ui.home.HomeActivity;

import okhttp3.internal.Util;

public class LoginActivity extends BaseActivity<LoginContract.Presenter, ActivityLoginBinding> implements LoginContract.View {

    private EditText mEtNumber;
    private Button mBtnLoginProceed;
    private Button mBtnSkip;

    private Toast mLoginToast;
    private LoginContract.Presenter mLoginPresenter;
    private SharedPrefManager mSharedPrefManager;

    @Override
    protected int getContentResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        mEtNumber = findViewById(R.id.login_et_mobile_no);
        mBtnLoginProceed = findViewById(R.id.login_btn_proceed);
        mBtnSkip = findViewById(R.id.login_btn_skip);

        mSharedPrefManager = SharedPrefManager.getInstance();

        mLoginPresenter = getPresenter();
        FirebaseAuth.getInstance().signOut();

        mBtnLoginProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = getString(R.string.country_code) + mEtNumber.getText().toString();
                showMessage(getString(R.string.msg_signing_in));
                mLoginPresenter.performPhoneLogin(number);

            }
        });
        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance().setSkipped(true);
                navigateToHomeActivity();

            }
        });

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void loginValidate() {
        if (mLoginToast != null) {
            mLoginToast.cancel();
        }
        dismissDialog();
        mLoginToast = Toast.makeText(this, getString(R.string.msg_invalid_no), Toast.LENGTH_SHORT);
        mLoginToast.show();
    }

    @Override
    public void onLoginSuccess() {
        if (mLoginToast != null) {
            mLoginToast.cancel();
        }
        dismissDialog();
        mLoginToast = Toast.makeText(this, getString(R.string.msg_login_success), Toast.LENGTH_SHORT);
        mLoginToast.show();
    }

    @Override
    public void onLoginFailed() {
        if (mLoginToast != null) {
            mLoginToast.cancel();
        }
        dismissDialog();
        mLoginToast = Toast.makeText(this, getString(R.string.msg_login_failed), Toast.LENGTH_SHORT);
        mLoginToast.show();
    }

    @Override
    public void navigateToHomeActivity() {

        Intent intent = new Intent(this, HomeActivity.class);
        Utils.finishEntryAnimation(this, intent);
    }

    @Override
    public void createAlertDialog() {
        dismissDialog();
        mLoginPresenter.openOTPDialog();
    }

    @Override
    protected void onResume() {
        mLoginPresenter.registerOTPReceiver();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mLoginPresenter.unRegisterOTPReceiver();
        super.onPause();
    }

}
