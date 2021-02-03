package com.example.wikimusic.artist.models;


import com.example.wikimusic.genre.models.GenreList;
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

    @SerializedName("similar")
    private SimilarArtist similarArtitst;

    @SerializedName("tags")
    private GenreList genreList;

    @SerializedName("stats")
    private Stats stats;

    @SerializedName("bio")
    private Bio bio;

    public Artist(String name, String mbid, String url, String streamable, List<Image> imageList, SimilarArtist similarArtitst, GenreList genreList, Stats stats, Bio bio) {
        this.name = name;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.imageList = imageList;
        this.similarArtitst = similarArtitst;
        this.genreList = genreList;
        this.stats = stats;
        this.bio = bio;
    }

    public Bio getBio() {
        return bio;
    }

    public void setBio(Bio bio) {
        this.bio = bio;
    }

    public SimilarArtist getSimilarArtitst() {
        return similarArtitst;
    }

    public void setSimilarArtitst(SimilarArtist similarArtitst) {
        this.similarArtitst = similarArtitst;
    }

    public GenreList getGenreList() {
        return genreList;
    }

    public void setGenreList(GenreList genreList) {
        this.genreList = genreList;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
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
