package com.udacity.exploreindia.Data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelper implements IPrefHelper {

    // Shared preferences file name
    private static final String PREF_NAME = "ExploreIndia";
    // All Shared Preferences Keys
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private final SharedPreferences mPrefs;

    public PrefHelper(Context context) {
        this.mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setFirstTimeLaunch(boolean isFirstTime) {
        mPrefs.edit().putBoolean(IS_FIRST_TIME_LAUNCH, true).apply();
    }

    @Override
    public boolean isFirstTimeLaunch() {
        return mPrefs.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
