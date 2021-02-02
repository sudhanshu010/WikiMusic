package com.example.wikimusic.track.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrackList {

    @SerializedName("track")
    private List<Track> trackList;

    public TrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
