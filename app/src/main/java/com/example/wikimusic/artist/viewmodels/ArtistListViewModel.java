package com.example.wikimusic.artist.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.artist.repository.ArtistListRepository;
import com.example.wikimusic.artist.ui.ArtistListListener;

import java.util.List;

public class ArtistListViewModel extends ViewModel {

    private MutableLiveData<List<Artist>> mArtistList;
    private ArtistListRepository artistListRepository;
    private ArtistListListener artistListListener;

    public void init(String genreName){
        if(mArtistList == null){
            artistListRepository = ArtistListRepository.getInstance();
            mArtistList = artistListRepository.getmArtistList(genreName);
            artistListListener = null;
        }
    }

    public LiveData<List<Artist>> getArtistList(){
        return mArtistList;
    }

    public void setArtistListListener(ArtistListListener artistListListener){
        this.artistListListener = artistListListener;
    }

    public void onCardSelected(Artist artist){
        if(artistListListener!=null)
            artistListListener.onArtistSelected(artist);
    }

}
