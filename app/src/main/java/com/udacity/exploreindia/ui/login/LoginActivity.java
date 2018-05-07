package com.udacity.exploreindia.ui.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.udacity.exploreindia.R;
import com.udacity.exploreindia.base.BaseActivity;
import com.udacity.exploreindia.databinding.ActivityLoginBinding;
import com.udacity.exploreindia.helper.SharedPrefManager;
import com.udacity.exploreindia.ui.home.HomeActivity;

public class LoginActivity extends BaseActivity<LoginContract.Presenter,ActivityLoginBinding> implements LoginContract.View {

    private EditText mEtNumber;
    private Button mBtnLoginProceed;
    private Button mBtnSigninWithGooglePlus;

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

        mSharedPrefManager = SharedPrefManager.getInstance();

        mLoginPresenter = getPresenter();

        mBtnLoginProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+91" + mEtNumber.getText().toString();
                mLoginPresenter.performPhoneLogin(number);
            }
        });

    }

    @Override
    protected void beforeView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void loginValidate() {
        if(mLoginToast != null) {
            mLoginToast.cancel();
        }
        mLoginToast = Toast.makeText(this, "Please Enter correct number!", Toast.LENGTH_SHORT);
        mLoginToast.show();
    }

    @Override
    public void onLoginSuccess() {
        if(mLoginToast != null) {
            mLoginToast.cancel();
        }
        mLoginToast = Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT);
        mLoginToast.show();
    }

    @Override
    public void onLoginFailed() {
        if(mLoginToast != null) {
            mLoginToast.cancel();
        }
        mLoginToast = Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT);
        mLoginToast.show();
    }

    @Override
    public void navigateToHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void createAlertDialog() {
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        View alertDiaglogView = getLayoutInflater().inflate(R.layout.alert_dialog_layout, null);

        Pinview pvAlertDialop = alertDiaglogView.findViewById(R.id.login_pv_otp);

        builder.setView(alertDiaglogView);
        final AlertDialog dialog = builder.create();
        pvAlertDialop.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                //Make api calls here or what not
                String otp = pinview.getValue();
                dialog.dismiss();
                mLoginPresenter.createAuthWithOTP(otp);
            }
        });
        dialog.show();
    }
}
