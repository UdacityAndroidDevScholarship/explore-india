package com.udacity.exploreindia.ui.login;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.udacity.exploreindia.base.BasePresenter;
import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.helper.SharedPrefManager;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    public static final String TAG = "LoginPresenter";

    LoginContract.View mLoginView;

    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;

    public LoginPresenter(SharedPrefManager mSharedPreferences, BaseRepo mBaseRepo, Context mContext) {
        super(mSharedPreferences, mBaseRepo, mContext);
        mLoginView = (LoginContract.View) getContext();
    }


    @Override
    public void init() {

    }

    @Override
    public void performPhoneLogin(String number) {
        mAuth = FirebaseAuth.getInstance();

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                //signInWithPhoneAuthCredential(phoneAuthCredential);
                mLoginView.onLoginSuccess();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                mLoginView.onLoginFailed();
            }

            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;

                mLoginView.createAlertDialog();

            }
        };

            if(TextUtils.isEmpty(number) || number.length() > 13 || number.length() < 13) {
                mLoginView.loginValidate();
            } else {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        number,        // Phone number to verify
                        60,                 // Timeout duration
                        TimeUnit.SECONDS,   // Unit of timeout
                        (Activity) getContext(),               // Activity (for callback binding)
                        mCallbacks);        // OnVerificationStateChangedCallbacks
            }
    }

    @Override
    public void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            mLoginView.onLoginSuccess();
                            mLoginView.navigateToHomeActivity();
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            mLoginView.onLoginFailed();
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

    @Override
    public void createAuthWithOTP(String otp) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp);
        signInWithPhoneAuthCredential(credential);
    }

}
