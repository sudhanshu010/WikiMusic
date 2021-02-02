package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArtistList {

    @SerializedName("artist")
    private List<Artist> artistList;

    public ArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }
}
