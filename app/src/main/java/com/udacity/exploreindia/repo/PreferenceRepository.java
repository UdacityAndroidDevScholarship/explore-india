package com.udacity.exploreindia.repo;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Desk on 17/02/2018.
 */

public class PreferenceRepository {

    // SharedPreferences file names
    private static final String PREF_NAME = "ExploreIndia";

    // Key Constants
    private static final String KEY_IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    // Default Value Constants
    private static final boolean IS_FIRST_TIME_LAUNCH = true;

    private static PreferenceRepository prefRepo;

    private SharedPreferences exploreIndiaPrefs;

    private PreferenceRepository(Context context) {
        this.exploreIndiaPrefs = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    /**
     * @param applicationContext Application Context
     */
    public static PreferenceRepository getInstance(Context applicationContext) {
        if (prefRepo == null)
            prefRepo = new PreferenceRepository(applicationContext);

        return prefRepo;
    }

    public boolean isFirstTimeLaunch() {
        return exploreIndiaPrefs.getBoolean(KEY_IS_FIRST_TIME_LAUNCH, IS_FIRST_TIME_LAUNCH);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        exploreIndiaPrefs.edit()
                .putBoolean(KEY_IS_FIRST_TIME_LAUNCH, isFirstTime)
                .apply();
    }

}
