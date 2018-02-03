package com.appsaja.wagiman.moviesapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wagiman on 2/3/2018.
 */

public class Tv {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
