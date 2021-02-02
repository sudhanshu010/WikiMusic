package com.example.wikimusic.album.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.album.models.Album;
import com.example.wikimusic.album.repository.AlbumListRepository;
import com.example.wikimusic.album.ui.AlbumListListener;

import java.util.List;

public class AlbumListViewModel extends ViewModel {

    private MutableLiveData<List<Album>> mAlbumList;
    private AlbumListRepository albumListRepository;
    private AlbumListListener albumListListener;

    public void init(String genreName){
        if(mAlbumList == null){
            albumListRepository = AlbumListRepository.getInstance();
            mAlbumList = albumListRepository.getmAlbumList(genreName);
            albumListListener = null;
        }
    }

    public LiveData<List<Album>> getAlbumList(){
        return mAlbumList;
    }

    public void setAlbumListListener(AlbumListListener albumListListener){
        this.albumListListener = albumListListener;
    }

    public void onCardSelected(Album album){
        if(albumListListener!=null)
            albumListListener.onAlbumSelected(album);
    }

}
