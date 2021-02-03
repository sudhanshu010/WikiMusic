package com.example.wikimusic.album.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.models.AlbumDetails;
import com.example.wikimusic.album.models.AlbumDetailsResponse;
import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumDetailsRepository {

    private static AlbumDetailsRepository instance;
    private MutableLiveData<AlbumDetails> mAlbum;
    private AlbumDetailsResponse albumDetailsResponse;

    public static AlbumDetailsRepository getInstance(){
        if(instance == null)
            instance = new AlbumDetailsRepository();

        return instance;
    }

    public MutableLiveData<AlbumDetails> getmAlbum(String albumName,String artistName){
        mAlbum = new MutableLiveData<>();
        loadData(albumName,artistName);
        return mAlbum;
    }

    public void loadData(String albumName,String artistName){

        Call<AlbumDetailsResponse> albumDetailsResponseCall = RetrofitClient.getInstance().getApi().getAlbum(albumName,artistName, Constants.apiKey);
        albumDetailsResponseCall.enqueue(new Callback<AlbumDetailsResponse>() {
            @Override
            public void onResponse(Call<AlbumDetailsResponse> call, Response<AlbumDetailsResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    mAlbum.postValue(response.body().getAlbum());
                }
            }

            @Override
            public void onFailure(Call<AlbumDetailsResponse> call, Throwable t) {

            }
        });

    }
}
