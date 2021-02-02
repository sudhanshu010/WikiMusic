package com.example.wikimusic.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wikimusic.models.genre.Genre;
import com.example.wikimusic.respository.GenreDetailsRepository;

public class GenreDetailsViewModel extends ViewModel {

    private GenreDetailsRepository genreDetailsRepository;
    private MutableLiveData<Genre> mGenre;
    String genreName;

    public void init(String genreName){
        if(mGenre == null){
            this.genreName = genreName;
            genreDetailsRepository = GenreDetailsRepository.getInstance();

        }
    }

    public LiveData<Genre> getGenre(){
        mGenre = genreDetailsRepository.getGenre(genreName);
        return mGenre;
    }

}
