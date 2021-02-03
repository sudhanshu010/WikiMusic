package com.example.wikimusic.track.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.track.models.Track;
import com.example.wikimusic.track.repository.ArtistTrackRepository;
import com.example.wikimusic.track.ui.TrackListListener;

import java.util.List;

public class ArtistTrackViewModel extends ViewModel {

    private MutableLiveData<List<Track>> mTrackList;
    private ArtistTrackRepository artistTrackRepository;
    private TrackListListener trackListListener;

    public void init(String artistName){
        if(mTrackList == null){
            artistTrackRepository = ArtistTrackRepository.getInstance();
            mTrackList = artistTrackRepository.getmTrackList(artistName);
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
