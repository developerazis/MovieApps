package com.appsaja.wagiman.moviesapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Wagiman on 2/3/2018.
 */

public class TvDetail {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("genres")
    private List<Genre> genres;

    @SerializedName("first_air_date")
    private String released_date;

    @SerializedName("episode_run_time")
    private List<Integer> duration;

    @SerializedName("production_companies")
    private List<Companies> companies;

    @SerializedName("vote_average")
    private String vote;

    @SerializedName("overview")
    private String overview;

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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getReleased_date() {
        return released_date;
    }

    public void setReleased_date(String released_date) {
        this.released_date = released_date;
    }

    public List<Integer> getDuration() {
        return duration;
    }

    public void setDuration(List<Integer> duration) {
        this.duration = duration;
    }

    public List<Companies> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
