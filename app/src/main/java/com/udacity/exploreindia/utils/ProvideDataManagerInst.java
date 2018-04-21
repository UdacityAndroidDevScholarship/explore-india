package com.udacity.exploreindia.utils;

import android.content.Context;

import com.udacity.exploreindia.Data.AppDataManager;
import com.udacity.exploreindia.Data.prefs.PrefHelper;

public class ProvideDataManagerInst {

    public static AppDataManager provideDataSource(Context context) {
        return AppDataManager.getInstance(new PrefHelper(context));
    }
}
