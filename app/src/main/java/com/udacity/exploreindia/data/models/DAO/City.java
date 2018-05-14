package com.udacity.exploreindia.data.models.DAO;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("add_date")
    private String addDate;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("city_status")
    private String cityStatus;
    @SerializedName("city_name")
    private String cityName;
    @SerializedName("city_id")
    private String cityId;

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(String cityStatus) {
        this.cityStatus = cityStatus;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
