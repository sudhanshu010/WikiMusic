package com.example.wikimusic.models.genre;

import com.google.gson.annotations.SerializedName;

public class GenreDescriptionWrapper {

    @SerializedName("summary")
    private String genreDesrciption;

    public GenreDescriptionWrapper(String genreDesrciption) {
        this.genreDesrciption = genreDesrciption;
    }

    public String getGenreDesrciption() {
        return genreDesrciption;
    }

    public void setGenreDesrciption(String genreDesrciption) {
        this.genreDesrciption = genreDesrciption;
    }
}
