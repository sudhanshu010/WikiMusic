package com.example.wikimusic.artist.models;


import com.example.wikimusic.models.images.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {

    @SerializedName("name")
    private String name;

    @SerializedName("mbid")
    public String mbid;

    @SerializedName("url")
    public String url;

    @SerializedName("streamable")
    public String streamable;

    @SerializedName("image")
    public List<Image> imageList;

    public Artist(String name, String mbid, String url, String streamable, List<Image> imageList) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
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

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
