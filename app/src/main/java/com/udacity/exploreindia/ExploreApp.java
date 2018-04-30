package com.udacity.exploreindia;

import android.app.Application;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class ExploreApp extends Application {

    private static ExploreApp INSTANCE;

    public static ExploreApp getInstance() {
        return INSTANCE;
    }

    @Override public void onCreate() {
        super.onCreate();

        INSTANCE = this;
    }
}
