package com.example.ximeiliu.contactlist.other;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ximeiliu on 20/01/17.
 */

public class RetroClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    private static Retrofit retrofit = null;

    /**
     * Get Retrofit Instande
     *
     * @return retrofit Instande
     */
    private static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     * Get API Service
     */

    public static ApiService getApiService() {
        return getRetrofitClient().create(ApiService.class);
    }


}
