package com.example.wikimusic.viewmodels.album;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.models.Album.Album;
import com.example.wikimusic.respository.album.AlbumListRepository;
import com.example.wikimusic.ui.album.albumList.AlbumListListener;

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
