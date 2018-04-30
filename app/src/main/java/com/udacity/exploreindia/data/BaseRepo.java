package com.udacity.exploreindia.data;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class BaseRepo implements BaseStorage {

    private static BaseRepo INSTANCE = null;
    private final BaseStorage mLocalStorage;
    private final BaseStorage mCloudData;

    private BaseRepo(BaseStorage mLocalStorage,
                     BaseStorage mCloudData) {
        this.mLocalStorage = mLocalStorage;
        this.mCloudData = mCloudData;
    }

    public static BaseRepo getInstance(BaseStorage mLocalStorage,
                                       BaseStorage mCloudData) {
        if (INSTANCE == null) {
            synchronized (BaseStorage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseRepo(mLocalStorage, mCloudData);
                }
            }
        }
        return INSTANCE;
    }


}
