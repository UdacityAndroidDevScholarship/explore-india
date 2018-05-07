package com.udacity.exploreindia.ui.login;

import com.google.firebase.auth.PhoneAuthCredential;
import com.udacity.exploreindia.base.BaseMvpPresenter;
import com.udacity.exploreindia.base.BaseView;

public interface LoginContract {

    interface Presenter extends BaseMvpPresenter<View>{
            void performPhoneLogin(String number);
            void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential);
            void createAuthWithOTP(String otp);

    }

    interface View extends BaseView{
            void loginValidate();
            void onLoginSuccess();
            void onLoginFailed();
            void navigateToHomeActivity();
            void createAlertDialog();
    }
}
