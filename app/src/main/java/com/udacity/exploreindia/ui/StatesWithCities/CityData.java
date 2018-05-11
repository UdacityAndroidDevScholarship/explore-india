package com.udacity.exploreindia.ui.StatesWithCities;

// TODO: This class can be deleted after linking with real data

/**
 * Used for saving the dummy data for StatesWithCitiesScreen
 */
public class CityData
{
    private int mImageId;
    private String mPlaceName;

    public CityData(int imageResourceId, String placeName) {
        mImageId = imageResourceId;
        mPlaceName = placeName;
    }

    public int getImageResourceId() {
        return mImageId;
    }

    public String getPlaceName() {
        return mPlaceName;
    }
}
