package com.example.wikimusic.models.genre;

import com.google.gson.annotations.SerializedName;

public class Genre {

    @SerializedName("name")
    public String name;

    @SerializedName("count")
    private long count;

    @SerializedName("reach")
    private long reach;

    public Genre(String name, long count, long reach) {
        this.name = name;
        this.count = count;
        this.reach = reach;
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
}
