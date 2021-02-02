package com.example.wikimusic.respository.genre;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.models.genre.GenreDetailsResponse;
import com.example.wikimusic.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreDetailsRepository {

    private static GenreDetailsRepository instance;
    private MutableLiveData<Genre> mGenre;
    private GenreDetailsResponse genreDetailsResponse;

    public static GenreDetailsRepository getInstance(){

        if(instance == null){
            instance = new GenreDetailsRepository();
        }
        return instance;
    }

    public MutableLiveData<Genre> getGenre(String genreName){

        mGenre = new MutableLiveData<>();
        loadData(genreName);
        return mGenre;
    }

    public void loadData(String genreName){

        Call<GenreDetailsResponse> genreListResponseCall = RetrofitClient.getInstance().getApi().getGenre(genreName,Constants.apiKey);
        genreListResponseCall.enqueue(new Callback<GenreDetailsResponse>() {
            @Override
            public void onResponse(Call<GenreDetailsResponse> call, Response<GenreDetailsResponse> response) {
                if(response.body()!=null) {
                    mGenre.postValue(response.body().getGenre());
                }
            }

            @Override
            public void onFailure(Call<GenreDetailsResponse> call, Throwable t) {
            }
        });
    }
}
