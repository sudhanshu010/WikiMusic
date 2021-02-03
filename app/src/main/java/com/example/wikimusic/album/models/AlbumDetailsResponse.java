package com.example.wikimusic.album.models;

import com.google.gson.annotations.SerializedName;

public class AlbumDetailsResponse {

    @SerializedName("album")
    private AlbumDetails album;

    public AlbumDetailsResponse(AlbumDetails album) {
        this.album = album;
    }

    public AlbumDetails getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDetails album) {
        this.album = album;
    }
}
