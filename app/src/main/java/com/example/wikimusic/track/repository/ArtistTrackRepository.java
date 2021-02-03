package com.example.wikimusic.track.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.track.models.ArtistTrackResponse;
import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistTrackRepository {

    private static ArtistTrackRepository instance;
    private MutableLiveData<List<Track>> mTrackList;
    private ArtistTrackResponse artistTrackResponse;

    public static ArtistTrackRepository getInstance(){
        if(instance == null)
            instance = new ArtistTrackRepository();

        return instance;
    }

    public MutableLiveData<List<Track>> getmTrackList(String artistName){
        if(mTrackList == null){
            mTrackList = new MutableLiveData<>();
        }
        loadData(artistName);
        return mTrackList;
    }

    public  void loadData(String artistName){

        Call<ArtistTrackResponse> artistTrackResponseCall = RetrofitClient.getInstance().getApi().getArtistTrack(artistName, Constants.apiKey);
        artistTrackResponseCall.enqueue(new Callback<ArtistTrackResponse>() {
            @Override
            public void onResponse(Call<ArtistTrackResponse> call, Response<ArtistTrackResponse> response) {
                if(response.isSuccessful()){
                    artistTrackResponse = response.body();
                    mTrackList.postValue(artistTrackResponse.getTrackList().getTrackList());
                }
            }

            @Override
            public void onFailure(Call<ArtistTrackResponse> call, Throwable t) {

            }
        });

    }


}
