package com.example.wikimusic.genre.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.models.GenreListResponse;
import com.example.wikimusic.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreListRepository {

    private static GenreListRepository instance;
    private GenreListResponse genreListResponse;
    private MutableLiveData<List<Genre>> genreList;

    public static GenreListRepository getInstance() {
        if (instance == null) {
            instance = new GenreListRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Genre>> getGenreList() {

        if (genreList == null) {
            genreList = new MutableLiveData<>();
            loadData();
        }
        return genreList;
    }

    private void loadData() {
        Call<GenreListResponse> genreListResponseCall = RetrofitClient.getInstance().getApi().getGenreList(Constants.apiKey);
        genreListResponseCall.enqueue(new Callback<GenreListResponse>() {
            @Override
            public void onResponse(Call<GenreListResponse> call, Response<GenreListResponse> response) {
                if (response.isSuccessful()) {
                    GenreListResponse genreListResponse = response.body();
                    genreList.postValue(genreListResponse.getGenreList().getGenreList());
                }
            }

            @Override
            public void onFailure(Call<GenreListResponse> call, Throwable t) {

            }
        });

    }

}
