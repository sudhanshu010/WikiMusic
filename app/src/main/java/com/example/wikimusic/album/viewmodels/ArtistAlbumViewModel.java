package com.example.wikimusic.album.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.repository.ArtistAlbumRepository;
import com.example.wikimusic.album.ui.AlbumListListener;
import com.example.wikimusic.track.models.Track;

import java.util.List;

public class ArtistAlbumViewModel extends ViewModel {

    private MutableLiveData<List<Album>> mAlbumList;
    private ArtistAlbumRepository artistAlbumRepository;
    private AlbumListListener albumListListener;

    public void init(String artistName){
        if(mAlbumList == null){
            artistAlbumRepository = ArtistAlbumRepository.getInstance();
            mAlbumList = artistAlbumRepository.getmAlbumList(artistName);
            albumListListener = null;
        }
    }

    public LiveData<List<Album>> getAlbumList(){
        return mAlbumList;
    }

    public void setAlbumListListener(AlbumListListener albumListListener){
        this.albumListListener = albumListListener;
    }

    public void OnCardSelected(Album album){
        if(albumListListener!=null)
            albumListListener.onAlbumSelected(album);
    }
}
