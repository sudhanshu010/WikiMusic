package com.example.wikimusic.models.genre;

import com.google.gson.annotations.SerializedName;

public class GenreListResponse {

    @SerializedName("toptags")
    private GenreList genreList;

    public GenreListResponse(GenreList genreList) {
        this.genreList = genreList;
    }

    public GenreList getGenreList() {
        return genreList;
    }

    public void setGenreList(GenreList genreList) {
        this.genreList = genreList;
    }
}
