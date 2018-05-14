package com.udacity.exploreindia.data.models.response;

import com.google.gson.annotations.SerializedName;
import com.udacity.exploreindia.data.models.DAO.State;

import java.util.List;

/**
 * Created by Kautilya on 06-05-2018.
 */
public class UserResponse {

    @SerializedName("response")
    private List<State> response;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public List<State> getResponse() {
        return response;
    }

    public void setResponse(List<State> response) {
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
