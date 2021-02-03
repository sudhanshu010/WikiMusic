package com.example.wikimusic.album.models;

import com.google.gson.annotations.SerializedName;

public class ArtistAlbumReponse {

    @SerializedName("topalbums")
    private AlbumList albumList;

    public ArtistAlbumReponse(AlbumList albumList) {
        this.albumList = albumList;
    }

    public AlbumList getAlbumList() {
        return albumList;
    }

    public void setAlbumList(AlbumList albumList) {
        this.albumList = albumList;
    }
}
