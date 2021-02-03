package com.example.wikimusic.track.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.airbnb.lottie.L;
import com.example.wikimusic.api.RetrofitClient;
import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.models.TrackListResponse;
import com.example.wikimusic.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackListRepository {

    private static TrackListRepository instance;
    private MutableLiveData<List<Track>> mTrackList;
    private TrackListResponse trackListResponse;

    public static TrackListRepository getInstance(){
        if(instance == null)
            instance = new TrackListRepository();
        return instance;
    }

    public MutableLiveData<List<Track>> getmTrackList(String genreName){
        if(mTrackList == null){
            mTrackList = new MutableLiveData<>();
        }
        loadData(genreName);
        return mTrackList;
    }

    private void loadData(String genreName){
        Call<TrackListResponse> trackListResponseCall = RetrofitClient.getInstance().getApi().getTracksList(genreName, Constants.apiKey);
        trackListResponseCall.enqueue(new Callback<TrackListResponse>() {
            @Override
            public void onResponse(Call<TrackListResponse> call, Response<TrackListResponse> response) {
                TrackListResponse trackListResponse = response.body();
                mTrackList.postValue(trackListResponse.getTrackList().getTrackList());

            }

            @Override
            public void onFailure(Call<TrackListResponse> call, Throwable t) {

            }
        });
    }
}
