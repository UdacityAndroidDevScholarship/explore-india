package com.udacity.exploreindia.data.Basic.cloud;

import com.google.firebase.database.FirebaseDatabase;
import com.udacity.exploreindia.data.Basic.BaseStorage;

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

    @Override
    public void storageUsser() {
        // TODO: 24-04-2018 CAll API TO STORE
    }
}
