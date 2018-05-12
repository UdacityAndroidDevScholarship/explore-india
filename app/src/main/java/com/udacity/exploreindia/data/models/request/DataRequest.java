package com.udacity.exploreindia.data.models.request;

import com.udacity.exploreindia.data.models.response.CitiResponse;
import com.udacity.exploreindia.data.models.response.PlaceResponse;
import com.udacity.exploreindia.data.models.response.StateResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kautilya on 06-05-2018.
 */
public interface DataRequest {

    @GET("states.php")
    Call<StateResponse> getStateDetails(@Query("token") String id);

    @GET("citeis.php")
    Call<CitiResponse> getCitiesForState(@Query("token") String token, @Query("state_code") String stateCode);

    @GET("places.php")
    Call<PlaceResponse> getAllPlaceForCity(@Query("token") String token, @Query("city_id") String cityId);
}
