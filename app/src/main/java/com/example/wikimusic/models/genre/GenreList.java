package com.example.wikimusic.models.genre;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreList {

    @SerializedName("tag")
    private List<Genre> genreList;

    public GenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
