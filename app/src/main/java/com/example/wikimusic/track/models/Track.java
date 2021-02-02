package com.example.wikimusic.track.models;

import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.models.images.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {

    @SerializedName("name")
    private String name;

    @SerializedName("duration")
    private String duration;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("url")
    private String url;

    @SerializedName("artist")
    private Artist artist;

    @SerializedName("image")
    private List<Image> imageList;

    public Track(String name, String duration, String mbid, String url, Artist artist, List<Image> imageList) {
        this.name = name;
        this.duration = duration;
        this.mbid = mbid;
        this.url = url;
        this.artist = artist;
        this.imageList = imageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
