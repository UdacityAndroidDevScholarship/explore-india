package com.udacity.exploreindia.data.models.response;

import com.google.gson.annotations.SerializedName;
import com.udacity.exploreindia.data.models.DAO.City;

import java.util.List;

public class CitiResponse {


    @SerializedName("response")
    private List<City> city;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
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
