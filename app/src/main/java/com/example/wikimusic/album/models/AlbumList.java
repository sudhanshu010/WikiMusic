package com.example.wikimusic.album.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumList {

    @SerializedName("album")
    private List<Album> albumList;

    public AlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
