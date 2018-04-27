package com.udacity.exploreindia.data.cloud;

import com.udacity.exploreindia.data.BaseStorage;

/**
 * Created by Kautilya on 24-04-2018.
 */
public class CloudStorage implements BaseStorage {


    public static CloudStorage INSTANCE;

    /**
     * This is where our cloud API and others go
     */
    private CloudStorage() {

    }

    public static CloudStorage getInstance() {
        if (INSTANCE == null) {
            synchronized (CloudStorage.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CloudStorage();
                }
            }
        }
        return INSTANCE;
    }


}
