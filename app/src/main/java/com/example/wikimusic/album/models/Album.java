package com.example.wikimusic.album.models;

import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.models.images.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {

    @SerializedName("name")
    private String name;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("url")
    private String url;

    @SerializedName("")
    private Artist artist;

    @SerializedName("image")
    private List<Image> imageList;

    public Album(String name, String mbid, String url, List<Image> imageList) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.imageList = imageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
