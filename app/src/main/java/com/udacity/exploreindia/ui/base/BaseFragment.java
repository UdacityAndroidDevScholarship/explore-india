package com.udacity.exploreindia.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.udacity.exploreindia.R;

/**
 * This is the root class for the activity that extends {@link AppCompatActivity}. Use this class instead
 * of {@link Fragment} through out the application.
 */
public class BaseFragment extends Fragment {
    protected Context mContext;       //Instance of the caller

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void showErrorMessage(String message) {
        showSnackbar(true, message);
    }

    private void showSnackbar(boolean isError, String message) {
        Snackbar make = Snackbar.make(getView(), message, Snackbar.LENGTH_LONG);
        make.getView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
        make.show();
    }

    public void showMessage(String message) {
        showSnackbar(false, message);
    }

    public AppCompatActivity getParent() {
        if (getActivity() instanceof AppCompatActivity) {
            return (AppCompatActivity) getActivity();
        } else {
            return null;
        }
    }
}