package com.example.wikimusic.track.models;

import com.google.gson.annotations.SerializedName;

public class ArtistTrackResponse {

    @SerializedName("toptracks")
    private TrackList trackList;

    public ArtistTrackResponse(TrackList trackList) {
        this.trackList = trackList;
    }

    public TrackList getTrackList() {
        return trackList;
    }

    public void setTrackList(TrackList trackList) {
        this.trackList = trackList;
    }
}
