package com.example.wikimusic.album.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.models.AlbumDetails;
import com.example.wikimusic.album.repository.AlbumDetailsRepository;

public class AlbumDetailsViewModel extends ViewModel {

    private AlbumDetailsRepository albumDetailsRepository;
    private MutableLiveData<AlbumDetails> mAlbum;
    String albumName,artistName;

    public void init(String albumName,String artistName){
        if(mAlbum == null){
            this.albumName = albumName;
            this.artistName = artistName;
            albumDetailsRepository = AlbumDetailsRepository.getInstance();
        }
    }

    public LiveData<AlbumDetails> getAlbum(){
        mAlbum = albumDetailsRepository.getmAlbum(albumName,artistName);
        return mAlbum;
    }
}
