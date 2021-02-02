package com.example.wikimusic.api;

import com.example.wikimusic.models.Album.AlbumListResponse;
import com.example.wikimusic.models.genre.GenreDetailsResponse;
import com.example.wikimusic.models.genre.GenreListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://ws.audioscrobbler.com/2.0/";


    @GET("?method=tag.getTopTags&format=json")
    Call<GenreListResponse> getGenreList(@Query("api_key") String apiKey);

    @GET("?method=tag.getinfo&format=json")
    Call<GenreDetailsResponse> getGenre(@Query("tag") String genreName, @Query("api_key") String apiKey);

    @GET("?method=tag.gettopalbums&format=json")
    Call<AlbumListResponse> getAlbumList(@Query("tag") String genreName, @Query("api_key") String apiKey);


}
