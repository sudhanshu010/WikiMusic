package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SimilarArtist {


    @SerializedName("artist")
    private List<Artist> similarArtist;

    public SimilarArtist(List<Artist> similarArtist) {
        this.similarArtist = similarArtist;
    }

    public List<Artist> getSimilarArtist() {
        return similarArtist;
    }

    public void setSimilarArtist(List<Artist> similarArtist) {
        this.similarArtist = similarArtist;
    }
}
