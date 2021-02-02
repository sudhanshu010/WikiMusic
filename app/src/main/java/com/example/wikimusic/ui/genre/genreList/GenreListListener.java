package com.example.wikimusic.ui.genre.genreList;

import com.example.wikimusic.models.genre.Genre;

public interface GenreListListener {

    void onStarted();
    void onSuccess();
    void onFailure();
    void onGenreSelected(Genre genre);

}
