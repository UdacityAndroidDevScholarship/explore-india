package com.udacity.exploreindia.data.models.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kautilya on 06-05-2018.
 */
public class StateResponse {


    @SerializedName("state_status")
    private String state_status;
    @SerializedName("img")
    private String img;
    @SerializedName("description")
    private String description;
    @SerializedName("state_code")
    private String state_code;
    @SerializedName("state_name")
    private String state_name;
    @SerializedName("state_id")
    private String state_id;

    public String getState_status() {
        return state_status;
    }

    public void setState_status(String state_status) {
        this.state_status = state_status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }
}
