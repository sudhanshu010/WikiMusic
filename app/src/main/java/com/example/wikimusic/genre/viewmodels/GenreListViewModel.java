package com.example.wikimusic.genre.viewmodels;

import android.util.Log;

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
    private MutableLiveData<Boolean> expand;

    public void init(){
        if(mGenreList ==null) {
            genreListRepository = GenreListRepository.getInstance();
            mGenreList = genreListRepository.getGenreList();
            genreListListener = null;
            expand = new MutableLiveData<>();
            expand.postValue(false);
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

    public void OnExpandClicked()
    {
        Log.i("Sudhanshu","clicked");
        expand.postValue(!expand.getValue());
    }

    public MutableLiveData<Boolean> getExpand(){
        return expand;
    }

}