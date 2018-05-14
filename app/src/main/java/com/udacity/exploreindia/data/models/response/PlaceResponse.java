package com.udacity.exploreindia.data.models.response;

import com.google.gson.annotations.SerializedName;
import com.udacity.exploreindia.data.models.DAO.Place;

import java.util.List;

public class PlaceResponse {


    @SerializedName("place")
    private List<Place> place;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
