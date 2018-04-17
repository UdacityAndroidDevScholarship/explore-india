package com.udacity.exploreindia.Data;

import com.udacity.exploreindia.Data.prefs.IPrefHelper;

public class AppDataManager implements DataManger {

    private static final String TAG = AppDataManager.class.getName();


    private static volatile AppDataManager INSTANCE;


    private IPrefHelper prefHelper;

    // Prevent direct instantiation.
    private AppDataManager(IPrefHelper prefHelper) {
        this.prefHelper = prefHelper;
    }


    public static AppDataManager getInstance(IPrefHelper prefHelper) {
        if (INSTANCE == null) {
            synchronized (AppDataManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppDataManager(prefHelper);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void setFirstTimeLaunch(boolean isFirstTime) {
        prefHelper.setFirstTimeLaunch(isFirstTime);
    }

    @Override
    public boolean isFirstTimeLaunch() {
        return prefHelper.isFirstTimeLaunch();
    }
}
