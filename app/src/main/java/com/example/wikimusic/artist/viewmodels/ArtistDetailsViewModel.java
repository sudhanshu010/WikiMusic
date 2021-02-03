package com.example.wikimusic.artist.viewmodels;

import android.widget.LinearLayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.repository.ArtistDetailsRepository;

public class ArtistDetailsViewModel extends ViewModel {

    private ArtistDetailsRepository artistDetailsRepository;
    private MutableLiveData<Artist> mArtist;
    String artistName;

    public void init(String artistName){
        if(mArtist == null){
            this.artistName = artistName;
            artistDetailsRepository = ArtistDetailsRepository.getInstance();
        }
    }

    public LiveData<Artist> getArtist(){
        mArtist = artistDetailsRepository.getmArtist(artistName);
        return mArtist;
    }
}
