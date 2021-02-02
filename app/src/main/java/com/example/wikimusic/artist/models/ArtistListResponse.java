package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

public class ArtistListResponse {

    @SerializedName("topartists")
    private ArtistList artistList;

    public ArtistListResponse(ArtistList artistList) {
        this.artistList = artistList;
    }

    public ArtistList getArtistList() {
        return artistList;
    }

    public void setArtistList(ArtistList artistList) {
        this.artistList = artistList;
    }
}
