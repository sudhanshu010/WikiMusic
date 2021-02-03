package com.example.wikimusic.models;

import com.google.gson.annotations.SerializedName;

public class DescriptionWrapper {

    @SerializedName("summary")
    private String description;

    public DescriptionWrapper(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
