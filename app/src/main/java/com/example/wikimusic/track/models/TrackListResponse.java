package com.example.wikimusic.track.models;

import com.google.gson.annotations.SerializedName;

public class TrackListResponse {

    @SerializedName("tracks")
    private TrackList trackList;

    public TrackListResponse(TrackList trackList) {
        this.trackList = trackList;
    }

    public TrackList getTrackList() {
        return trackList;
    }

    public void setTrackList(TrackList trackList) {
        this.trackList = trackList;
    }
}
