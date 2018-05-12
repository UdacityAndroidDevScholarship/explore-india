package com.udacity.exploreindia.data.models.response;

import com.google.gson.annotations.SerializedName;
import com.udacity.exploreindia.data.models.DAO.States;

import java.util.List;

/**
 * Created by Kautilya on 06-05-2018.
 */
public class UserResponse {

    @SerializedName("response")
    private List<States> response;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public List<States> getResponse() {
        return response;
    }

    public void setResponse(List<States> response) {
        this.response = response;
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
