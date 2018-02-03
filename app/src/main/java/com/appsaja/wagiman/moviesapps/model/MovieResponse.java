package com.appsaja.wagiman.moviesapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wagiman on 1/23/2018.
 */

public class MovieResponse {
    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private List<Movie> results = new ArrayList<Movie>();

    @SerializedName("total_results")
    private Integer total_results;

    @SerializedName("total_pages")
    private Integer totalPages;



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
