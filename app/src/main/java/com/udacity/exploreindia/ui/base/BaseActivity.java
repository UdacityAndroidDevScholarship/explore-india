package com.udacity.exploreindia.ui.base;

import android.annotation.SuppressLint;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.udacity.exploreindia.R;

/**
 * This is the root class for the activity that extends {@link AppCompatActivity}. Use this class instead
 * of {@link AppCompatActivity} through out the application.
 */

@SuppressWarnings("unused")
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    /**
     * Set the toolbar of the activity.
     *
     * @param toolbarId    resource id of the toolbar
     * @param title        title of the activity
     * @param showUpButton true if toolbar should display up indicator.
     */
    protected void setToolbar(int toolbarId, @StringRes int title, boolean showUpButton) {
        Toolbar toolbar = findViewById(toolbarId);
        setSupportActionBar(toolbar);
        setToolbar(title, showUpButton);
    }

    /**
     * Set the toolbar of the activity.
     *
     * @param toolbarId    resource id of the toolbar
     * @param title        title of the activity
     * @param showUpButton true if toolbar should display up indicator.
     */
    protected void setToolbar(int toolbarId, @NonNull String title, boolean showUpButton) {
        Toolbar toolbar = findViewById(toolbarId);
        setSupportActionBar(toolbar);
        setToolbar(title, showUpButton);
    }

    /**
     * Set the toolbar.
     *
     * @param title        Activity title string resource
     * @param showUpButton true if toolbar should display up indicator.
     */
    @SuppressWarnings("WeakerAccess")
    protected void setToolbar(@StringRes int title, boolean showUpButton) {
        setToolbar(getString(title), showUpButton);
    }

    /**
     * Set the toolbar.
     *
     * @param title        Activity title string.
     * @param showUpButton true if toolbar should display up indicator.
     */
    @SuppressLint("RestrictedApi")
    @SuppressWarnings({"ConstantConditions", "WeakerAccess"})
    protected void setToolbar(@NonNull String title, boolean showUpButton) {
        //set the title
        getSupportActionBar().setTitle(title);

        //Set the up indicator
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(showUpButton);
        getSupportActionBar().setHomeButtonEnabled(showUpButton);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_top_nav_back_arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
    }

    public void showErrorMessage(String message) {
        showSnackbar(true, message);
    }

    public void showSnackbar(boolean isError, String message) {
        View view = findViewById(android.R.id.content);
        if (view != null) {
            Snackbar make = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
            make.getView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
            make.show();
        }
    }

    public void showMessage(String message) {
        showSnackbar(false, message);
    }

    public void setFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}