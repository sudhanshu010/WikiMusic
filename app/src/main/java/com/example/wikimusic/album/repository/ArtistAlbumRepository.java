package com.example.wikimusic.album.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.models.ArtistAlbumReponse;
import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistAlbumRepository {

    private static ArtistAlbumRepository instance;
    private MutableLiveData<List<Album>> mAlbumList;
    private ArtistAlbumReponse artistAlbumReponse;

    public static ArtistAlbumRepository getInstance(){
        if(instance == null){
            instance = new ArtistAlbumRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Album>> getmAlbumList(String artistName){
        if(mAlbumList == null){
            mAlbumList = new MutableLiveData<>();
        }
        loadData(artistName);
        return mAlbumList;
    }

    public void loadData(String artistName){
        Call<ArtistAlbumReponse> artistAlbumReponseCall = RetrofitClient.getInstance().getApi().getArtistAlbum(artistName, Constants.apiKey);
        artistAlbumReponseCall.enqueue(new Callback<ArtistAlbumReponse>() {
            @Override
            public void onResponse(Call<ArtistAlbumReponse> call, Response<ArtistAlbumReponse> response) {
                if(response.isSuccessful()){
                    artistAlbumReponse = response.body();
                    mAlbumList.postValue(artistAlbumReponse.getAlbumList().getAlbumList());
                }
            }

            @Override
            public void onFailure(Call<ArtistAlbumReponse> call, Throwable t) {

            }
        });
    }
}
