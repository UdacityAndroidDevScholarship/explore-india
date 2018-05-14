package com.udacity.exploreindia.ui.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.udacity.exploreindia.R;
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
    private AlertDialog dialog;
    private String num1, num2, num3, num4, num5, num6;
    EditText n1;
    EditText n2;
    EditText n3;
    EditText n4;
    EditText n5;
    EditText n6;

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
        mAuth.signOut();

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                // mLoginView.onLoginSuccess();
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Log.e("Error", e.getLocalizedMessage());
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

        if (TextUtils.isEmpty(number) || number.length() < 13) {
            mLoginView.loginValidate();
        } else {
            Log.e("phone", number);
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
                .addOnCompleteListener((AppCompatActivity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            mLoginView.onLoginSuccess();
                            SharedPrefManager.getInstance().setLoggedIn(true);
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


    @Override
    public void openOTPDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = ((AppCompatActivity) getContext()).getLayoutInflater().inflate(R.layout.alert_dialog_layout, null);


        final ImageView cross;

        cross = (ImageView) view.findViewById(R.id.login_img_cross);
        n1 = (EditText) view.findViewById(R.id.n1);
        n2 = (EditText) view.findViewById(R.id.n2);
        n3 = (EditText) view.findViewById(R.id.n3);
        n4 = (EditText) view.findViewById(R.id.n4);
        n5 = (EditText) view.findViewById(R.id.n5);
        n6 = (EditText) view.findViewById(R.id.n6);


        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        n1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = s.toString().trim();
                if (str.length() == 1) {
                    num1 = str;
                    n2.requestFocus();
                    checkNumber();
                }
            }
        });


        n2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = s.toString().trim();
                if (str.length() == 1) {
                    num2 = str;
                    n3.requestFocus();
                    checkNumber();

                }
            }
        });


        n3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = s.toString().trim();
                if (str.length() == 1) {
                    num3 = str;
                    n4.requestFocus();
                    checkNumber();

                }
            }
        });


        n4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = s.toString().trim();
                if (str.length() == 1) {
                    num4 = str;
                    n5.requestFocus();
                    checkNumber();
                }
            }
        });


        n5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = s.toString().trim();
                if (str.length() == 1) {
                    num5 = str;
                    n6.requestFocus();
                    checkNumber();
                }
            }
        });

        n6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = s.toString().trim();
                if (str.length() == 1) {
                    num6 = str;
                    checkNumber();
                }
            }
        });


        builder.setView(view);
        dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private void checkNumber() {
        if (!TextUtils.isEmpty(num1) && !TextUtils.isEmpty(num2) && !TextUtils.isEmpty(num3)
                && !TextUtils.isEmpty(num4) && !TextUtils.isEmpty(num5) && !TextUtils.isEmpty(num6)) {
            dialog.dismiss();
            Log.e("OTP", num1 + num2 + num3 + num4 + num5 + num6);
            createAuthWithOTP(num1 + num2 + num3 + num4 + num5 + num6);

        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {

                if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                    final Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        Object[] pdusObj = (Object[]) bundle.get("pdus");
                        for (Object aPdusObj : pdusObj) {
                            SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                            String senderAddress = currentMessage.getDisplayOriginatingAddress();
                            String message = currentMessage.getDisplayMessageBody();

                            if (!senderAddress.toLowerCase().contains(getContext().getString(R.string.app_name))) {
                                return;
                            }

                            String verificationCode = getVerificationCode(message);
                            if (!TextUtils.isEmpty(verificationCode)) {
                                Log.e("OTP num", verificationCode.charAt(0) + "");
                                n1.setText(verificationCode.charAt(0));
                                n2.setText(verificationCode.charAt(1));
                                n3.setText(verificationCode.charAt(2));
                                n4.setText(verificationCode.charAt(3));
                                n5.setText(verificationCode.charAt(4));
                                n6.setText(verificationCode.charAt(5));
                            }
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    private String getVerificationCode(String message) {
        String code = null;
        int index = message.indexOf("-");
        if (index != -1) {
            int start = index + 1;
            int length = 6;
            code = message.substring(start, start + length);
            return code;
        }

        return null;
    }

    @Override
    public void registerOTPReceiver() {
        getContext().registerReceiver(broadcastReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    @Override
    public void unRegisterOTPReceiver() {
        getContext().unregisterReceiver(broadcastReceiver);

    }
}
