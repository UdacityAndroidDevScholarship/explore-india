package com.udacity.exploreindia.injection;

import com.udacity.exploreindia.data.BaseRepo;
import com.udacity.exploreindia.data.BaseStorage;
import com.udacity.exploreindia.data.cloud.CloudStorage;
import com.udacity.exploreindia.data.local.LocalStorage;
import com.udacity.exploreindia.helper.SharedPrefManager;

/**
 * Created by Kautilya on 24-04-2018.
 */
public final class InjectionUtils {

    public InjectionUtils() {
    }

    public static SharedPrefManager getSharedPreference() {
        return SharedPrefManager.getInstance();
    }


    public static BaseStorage provideLocalStorage() {
        return LocalStorage.getInstance();
    }

    public static BaseStorage provideCloudData() {
        return CloudStorage.getInstance();
    }

    public static BaseRepo providesDataRepo() {
        return BaseRepo.getInstance(InjectionUtils.provideLocalStorage(),
                InjectionUtils.provideCloudData());
    }
}
