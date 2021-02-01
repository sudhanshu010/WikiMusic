package com.example.wikimusic.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private final Api api;

    private RetrofitClient()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api =  retrofit.create(Api.class);

    }

    public static synchronized RetrofitClient getInstance()
    {
        if (instance == null)
        {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getApi()
    {
        return api;
    }
}
