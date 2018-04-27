package com.udacity.exploreindia.data.local;

import com.udacity.exploreindia.data.BaseStorage;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class LocalStorage implements BaseStorage {

    private static LocalStorage INSTANCE;

    private LocalStorage() {
    }

    public static LocalStorage getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalStorage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalStorage();
                }
            }
        }
        return INSTANCE;
    }


}
