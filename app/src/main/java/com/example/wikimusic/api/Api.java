package com.example.wikimusic.api;

import com.example.wikimusic.models.genre.GenreListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://ws.audioscrobbler.com/2.0/";


    @GET("?method=tag.getTopTags&format=json")
    Call<GenreListResponse> getGenreList(@Query("api_key") String apiKey);


}
