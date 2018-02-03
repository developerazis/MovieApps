package com.appsaja.wagiman.moviesapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wagiman on 2/2/2018.
 */

public class MovieDetail {

    @SerializedName("genres")
    private List<Genre> genres = new ArrayList<Genre>();

    @SerializedName("production_companies")
    private List<Companies> companies = new ArrayList<Companies>();

    @SerializedName("adult")
    private String adult;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("video")
    private Boolean video;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("id")
    private String id;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("runtime")
    private String duration;

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Companies> getCompanies() {
        return companies;
    }

    public String getAdult() {
        return adult;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
