package com.udacity.exploreindia.ui.home.fragments.search;

/**
 * Created by Divya on 30-04-2018.
 */

public class SearchModel {
    private String loctionName;
    private String locationDistance;
    private boolean isFavorite;
    private String locationUrl;

    public SearchModel()
    {
    }

    public SearchModel(String loctionName, String locationDistance, boolean isFavorite/*, String locationUrl*/) {
        this.loctionName = loctionName;
        this.locationDistance = locationDistance;
        this.isFavorite = isFavorite;
        //this.locationUrl = locationUrl;
    }

    public String getLoctionName() {
        return loctionName;
    }

    public void setLoctionName(String loctionName) {
        this.loctionName = loctionName;
    }

    public String getLocationDistance() {
        return locationDistance;
    }

    public void setLocationDistance(String locationDistance) {
        this.locationDistance = locationDistance;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }
}
