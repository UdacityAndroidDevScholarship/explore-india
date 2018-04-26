package com.udacity.exploreindia.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shivam Srivastava on 26/04/2018.
 */

public class PrefManager {
    // Shared Preferences
    private SharedPreferences preference;

    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    // Context
    private Context _context;

    // Shared preferences name
    private static final String PREF_NAME = "ExploreIndia";

    //  -------- Shared Preferences Keys  ---------
    // value to check first time app usage
    private static final String USER_EMAIL = "emailId";
    // value to store email of user
    private static final String USER_PHONE = "phone";
    // value DEFAULT if not data found
    private static final String NOT_AVAILABLE = "N/A";


    /**
     * Intialize SharedP reference for app
     *
     * @param context context
     */
    public PrefManager(Context context) {
        this._context = context;
        preference = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Set {@link PrefManager} editable to write values in SharedPreference
     */
    public void edit() {
        editor = preference.edit();
    }


    /**
     * User email is used to check login status
     *
     * @param email
     */
    public void setLoggedIn(String email) {
        editor.putString(USER_EMAIL, email);
        editor.commit();
    }

    /**
     * User email is used to check login status
     *
     * @return true if user logged in else false.
     */
    public boolean isLoggedIn() {

        if (preference.getString(USER_EMAIL, NOT_AVAILABLE).equals(NOT_AVAILABLE))
            return false;
        else
            return true;


    }


}
