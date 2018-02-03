package com.appsaja.wagiman.moviesapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Wagiman on 2/3/2018.
 */

public class TvResponse {
    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private List<Tv> results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Tv> getResults() {
        return results;
    }

    public void setResults(List<Tv> results) {
        this.results = results;
    }
}
