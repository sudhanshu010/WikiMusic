package com.example.wikimusic.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.models.genre.GenreList;
import com.example.wikimusic.respository.GenreListRepository;

import java.util.List;

public class GenreListViewModel extends ViewModel {

    private MutableLiveData<List<Genre>> mGenreList;
    private GenreListRepository mGenreListRepository;

    public void init(){
        if(mGenreList ==null) {
            mGenreListRepository = mGenreListRepository.getInstance();
            mGenreList = mGenreListRepository.getGenreList();
        }
    }

    public LiveData<List<Genre>> getGenreList(){
        return mGenreList;
    }
}
