package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

public class ArtistDetailsResponse {

    @SerializedName("artist")
    private Artist artist;

    public ArtistDetailsResponse(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
