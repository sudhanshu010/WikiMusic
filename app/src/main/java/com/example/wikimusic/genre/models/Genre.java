package com.example.wikimusic.genre.models;

import com.example.wikimusic.models.DescriptionWrapper;
import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("name")
    private String name;

    @SerializedName("count")
    private long count;

    @SerializedName("reach")
    private long reach;

    @SerializedName("wiki")
    private DescriptionWrapper descriptionWrapper;

    public Genre(String name, long count, long reach, DescriptionWrapper descriptionWrapper) {
        this.name = name;
        this.count = count;
        this.reach = reach;
        this.descriptionWrapper = descriptionWrapper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getReach() {
        return reach;
    }

    public void setReach(long reach) {
        this.reach = reach;
    }

    public DescriptionWrapper getDescriptionWrapper() {
        return descriptionWrapper;
    }

    public void setDescriptionWrapper(DescriptionWrapper descriptionWrapper) {
        this.descriptionWrapper = descriptionWrapper;
    }
}
