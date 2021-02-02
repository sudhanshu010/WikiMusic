package com.example.wikimusic.genre.models;

import com.google.gson.annotations.SerializedName;

public class GenreDetailsResponse {

    @SerializedName("tag")
    private Genre genre;

    public GenreDetailsResponse(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
