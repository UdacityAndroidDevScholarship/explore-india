package com.udacity.exploreindia.data.models.request;

import com.udacity.exploreindia.data.models.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kautilya on 06-05-2018.
 */
public interface UserRequest {

    @GET("api/v1.0.0/states.php")
    Call<UserResponse> getUserDetails();
}
