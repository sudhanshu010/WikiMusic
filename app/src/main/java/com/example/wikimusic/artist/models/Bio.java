package com.example.wikimusic.artist.models;

import com.google.gson.annotations.SerializedName;

public class Bio {

    @SerializedName("published")
    private String published;

    @SerializedName("summary")
    private String summary;

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bio(String published, String summary, String content) {
        this.published = published;
        this.summary = summary;
        this.content = content;
    }

    @SerializedName("content")
    private String content;
}
