package com.example.wikimusic.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.respository.GenreListRepository;
import com.example.wikimusic.ui.Genre.GenreListListener;

import java.util.List;

public class GenreListViewModel extends ViewModel {

    private MutableLiveData<List<Genre>> mGenreList;
    private GenreListRepository mGenreListRepository;
    private GenreListListener genreListListener;

    public void init(){
        if(mGenreList ==null) {
            mGenreListRepository = mGenreListRepository.getInstance();
            mGenreList = mGenreListRepository.getGenreList();
            genreListListener = null;
        }
    }

    public LiveData<List<Genre>> getGenreList(){
        return mGenreList;
    }

    public void setGenreListListener(GenreListListener genreListListener){
        this.genreListListener = genreListListener;
    }

    public void onCardSelected(Genre genre){
        if(genreListListener != null)
            genreListListener.onSelected();
        Log.i("Sudhanshu","Hey");

    }
}
