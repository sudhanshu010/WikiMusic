package com.example.wikimusic.artist.repository;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.models.ArtistDetailsResponse;
import com.example.wikimusic.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistDetailsRepository {

    private static ArtistDetailsRepository instance;
    private MutableLiveData<Artist> mArtist;
    private ArtistDetailsResponse artistDetailsResponse;

    public static ArtistDetailsRepository getInstance(){
        if(instance == null)
            instance = new ArtistDetailsRepository();

        return instance;
    }

    public MutableLiveData<Artist> getmArtist(String artistName){
        mArtist = new MutableLiveData<>();
        loadData(artistName);
        return mArtist;
    }

    public void loadData(String artistName){

        Call<ArtistDetailsResponse> artistDetailsResponseCall = RetrofitClient.getInstance().getApi().getArtist(artistName, Constants.apiKey);
        artistDetailsResponseCall.enqueue(new Callback<ArtistDetailsResponse>() {
            @Override
            public void onResponse(Call<ArtistDetailsResponse> call, Response<ArtistDetailsResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    mArtist.postValue(response.body().getArtist());
                }
            }

            @Override
            public void onFailure(Call<ArtistDetailsResponse> call, Throwable t) {

            }
        });
    }

}
