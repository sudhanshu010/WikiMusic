package com.example.wikimusic.artist.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.models.ArtistListResponse;
import com.example.wikimusic.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistListRepository {

    private static ArtistListRepository instance;
    private ArtistListResponse artistListResponse;
    private MutableLiveData<List<Artist>> mArtistList;

    public static ArtistListRepository getInstance(){
        if(instance==null)
            instance = new ArtistListRepository();
        return instance;
    }

    public MutableLiveData<List<Artist>> getmArtistList(String genreName){
        if(mArtistList == null){
            mArtistList = new MutableLiveData<>();
            loadData(genreName);
        }
        return mArtistList;
    }

    private void loadData(String genreName){

        Call<ArtistListResponse> artistListResponseCall = RetrofitClient.getInstance().getApi().getArtistList(genreName, Constants.apiKey);
        artistListResponseCall.enqueue(new Callback<ArtistListResponse>() {
            @Override
            public void onResponse(Call<ArtistListResponse> call, Response<ArtistListResponse> response) {
                if(response.isSuccessful()){
                    ArtistListResponse artistListResponse = response.body();
                    mArtistList.postValue(artistListResponse.getArtistList().getArtistList());
                }
            }

            @Override
            public void onFailure(Call<ArtistListResponse> call, Throwable t) {

            }
        });
    }

}
