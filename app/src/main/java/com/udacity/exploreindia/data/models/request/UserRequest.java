package com.udacity.exploreindia.data.models.request;

import com.udacity.exploreindia.data.models.response.UserResponse;

import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Kautilya on 06-05-2018.
 */
public interface UserRequest {

    @POST("/add_user.php")
    UserResponse getUserResponse(
            @Query("first_name") String name,
            @Query("last_name") String lastName,
            @Query("country_code") String countryCode,
            @Query("mobile") String phone,
            @Query("firebase_db_id") String fireBaseUUID,
            @Query("firebase_token") String fireBaseToken);


}
