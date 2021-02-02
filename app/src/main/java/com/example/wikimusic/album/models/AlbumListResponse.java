package com.example.wikimusic.album.models;

import com.google.gson.annotations.SerializedName;

public class AlbumListResponse {

    @SerializedName("albums")
    private AlbumList albumList;

    public AlbumListResponse(AlbumList albumList) {
        this.albumList = albumList;
    }

    public AlbumList getAlbumList() {
        return albumList;
    }

    public void setAlbumList(AlbumList albumList) {
        this.albumList = albumList;
    }


}
