package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("listeners")
    private String listeners;

    @SerializedName("playCount")
    private String playCount;

    public Stats(String listeners, String playCount) {
        this.listeners = listeners;
        this.playCount = playCount;
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
}
