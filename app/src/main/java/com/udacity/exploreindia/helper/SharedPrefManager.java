package com.udacity.exploreindia.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.udacity.exploreindia.ExploreApp;

/**
 * Created by Desk on 17/02/2018.
 */

public class SharedPrefManager {
    // Shared Preferences
    private SharedPreferences pref;

    private SharedPreferences.Editor editor;


    private static SharedPrefManager INSTANCE;
    // Editor for Shared preferences


    private static final String PREF_NAME = "ExploreIndia";


    // All Shared Preferences Keys
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public SharedPrefManager() {
        pref =
                ExploreApp.getInstance().getApplicationContext().getSharedPreferences(PREF_NAME,
                        Context.MODE_PRIVATE);
    }

    public static SharedPrefManager getInstance() {
        if (INSTANCE == null) {
            synchronized (SharedPrefManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SharedPrefManager();
                }
            }
        }
        return INSTANCE;
    }


    private SharedPreferences.Editor getEditor() {
        return editor = (editor != null ? editor : pref.edit());
    }


    public void setFirstTimeLaunch(boolean isFirstTime) {
        getEditor().putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        getEditor().commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
