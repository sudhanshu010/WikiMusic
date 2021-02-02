package com.example.wikimusic.genre.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.genre.models.Genre;
import com.example.wikimusic.genre.repository.GenreListRepository;
import com.example.wikimusic.genre.ui.GenreListListener;

import java.util.List;

public class GenreListViewModel extends ViewModel {

    private MutableLiveData<List<Genre>> mGenreList;
    private GenreListRepository genreListRepository;
    private GenreListListener genreListListener;

    public void init(){
        if(mGenreList ==null) {
            genreListRepository = GenreListRepository.getInstance();
            mGenreList = genreListRepository.getGenreList();
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
            genreListListener.onGenreSelected(genre);
    }
}