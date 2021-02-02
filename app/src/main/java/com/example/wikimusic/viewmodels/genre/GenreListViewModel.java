package com.example.wikimusic.viewmodels.genre;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.respository.genre.GenreListRepository;
import com.example.wikimusic.ui.genre.genreList.GenreListListener;

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
