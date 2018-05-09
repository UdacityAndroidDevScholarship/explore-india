package com.udacity.exploreindia.data.models;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kautilya on 06-05-2018.
 */
public class RetrofitFactory {

    private static final String URL = "https://ei.wevands.com";

    public static <T> T createRetroFitService(final Class<T> clazz) {

        OkHttpClient client = new OkHttpClient.Builder().build();
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .client(client)
                .build();
        return retrofit.create(clazz);
    }
}