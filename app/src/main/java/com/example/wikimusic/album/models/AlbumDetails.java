package com.example.wikimusic.album.models;

import com.example.wikimusic.artist.models.Artist;
import com.example.wikimusic.genre.models.GenreList;
import com.example.wikimusic.models.DescriptionWrapper;
import com.example.wikimusic.models.images.Image;
import com.example.wikimusic.track.models.TrackList;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumDetails {

    @SerializedName("name")
    private String name;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("url")
    private String url;

    @SerializedName("artist")
    private String artistName;

    @SerializedName("listeners")
    private String listeners;

    @SerializedName("playcount")
    private String playCount;

    @SerializedName("tracks")
    private TrackList trackList;

    @SerializedName("tags")
    private GenreList genreList;

    @SerializedName("wiki")
    private DescriptionWrapper descriptionWrapper;

    @SerializedName("image")
    private List<Image> imageList;

    public AlbumDetails(String name, String mbid, String url, String artistName, String listeners, String playCount, TrackList trackList, GenreList genreList, DescriptionWrapper descriptionWrapper, List<Image> imageList) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.artistName = artistName;
        this.listeners = listeners;
        this.playCount = playCount;
        this.trackList = trackList;
        this.genreList = genreList;
        this.descriptionWrapper = descriptionWrapper;
        this.imageList = imageList;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlayCount() {
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }

    public TrackList getTrackList() {
        return trackList;
    }

    public void setTrackList(TrackList trackList) {
        this.trackList = trackList;
    }

    public GenreList getGenreList() {
        return genreList;
    }

    public void setGenreList(GenreList genreList) {
        this.genreList = genreList;
    }

    public DescriptionWrapper getDescriptionWrapper() {
        return descriptionWrapper;
    }

    public void setDescriptionWrapper(DescriptionWrapper descriptionWrapper) {
        this.descriptionWrapper = descriptionWrapper;
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
