package com.udacity.exploreindia.data.models.request;

import com.udacity.exploreindia.data.models.response.StateResponse;
import com.udacity.exploreindia.data.models.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kautilya on 06-05-2018.
 */
public interface DataRequest {

    @GET("api/v1.0.0/states.php")
    Call<List<StateResponse>> getStateDetails(@Query("token") String id);
}
