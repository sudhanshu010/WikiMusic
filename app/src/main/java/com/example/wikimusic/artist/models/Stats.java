package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("listeners")
    private String listeners;

    @SerializedName("playcount")
    private String playCount;

    public Stats(String listeners, String playCount) {
        this.listeners = listeners;
        this.playCount = playCount;
    }

    public String getListeners() {
        int count =  Integer.parseInt(listeners);
        if(count>1000000){
            return count/1000000+"M";
        }
        if(count>1000){
            return count/1000+"K";
        }
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlayCount() {
        int count =  Integer.parseInt(playCount);
        if(count>1000000){
            return count/1000000+"M";
        }

        if(count>1000){
            return count/1000+"K";
        }
        return playCount;
    }

    public void setPlayCount(String playCount) {
        this.playCount = playCount;
    }
}
