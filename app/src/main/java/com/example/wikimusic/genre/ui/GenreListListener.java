package com.example.wikimusic.genre.ui;

import com.example.wikimusic.genre.models.Genre;

public interface GenreListListener {

    void onStarted();
    void onSuccess();
    void onFailure();
    void onGenreSelected(Genre genre);

}
