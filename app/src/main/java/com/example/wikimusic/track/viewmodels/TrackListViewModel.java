package com.example.wikimusic.track.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.repository.TrackListRepository;
import com.example.wikimusic.track.ui.TrackListListener;

import java.util.List;

public class TrackListViewModel extends ViewModel {

    private MutableLiveData<List<Track>> mTrackList;
    private TrackListRepository trackListRepository;
    private TrackListListener trackListListener;

    public void init(String genreName){
        if(mTrackList == null){
            trackListRepository = TrackListRepository.getInstance();
            mTrackList = trackListRepository.getmTrackList(genreName);
            trackListListener = null;
        }
    }

    public LiveData<List<Track>> getTrackList(){
        return mTrackList;
    }

    public void setTrackListListener(TrackListListener trackListListener){
        this.trackListListener = trackListListener;
    }

    public void onCardSelected(Track track){
        if(trackListListener!=null)
            trackListListener.onTrackSelected(track);
    }
}
