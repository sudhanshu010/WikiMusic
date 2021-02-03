package com.example.wikimusic.api;

import com.example.wikimusic.album.models.AlbumDetailsResponse;
import com.example.wikimusic.album.models.AlbumListResponse;
import com.example.wikimusic.artist.models.ArtistDetailsResponse;
import com.example.wikimusic.artist.models.ArtistListResponse;
import com.example.wikimusic.genre.models.GenreDetailsResponse;
import com.example.wikimusic.genre.models.GenreListResponse;
import com.example.wikimusic.track.models.TrackListResponse;

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

    @GET("?method=tag.gettopartists&format=json")
    Call<ArtistListResponse> getArtistList(@Query("tag") String genreName, @Query("api_key") String apiKey);

    @GET("?method=tag.gettoptracks&format=json")
    Call<TrackListResponse> getTracksList(@Query("tag") String genreName, @Query("api_key") String apiKey);

    @GET("?method=artist.getinfo&format=json")
    Call<ArtistDetailsResponse> getArtist(@Query("artist") String artistName, @Query("api_key") String apiKey);

    @GET("?method=album.getinfo&format=json")
    Call<AlbumDetailsResponse> getAlbum(@Query("album") String albumName,@Query("artist") String artistName, @Query("api_key") String apiKey);




}
