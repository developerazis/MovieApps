package com.appsaja.wagiman.moviesapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wagiman on 2/1/2018.
 */

public class ReviewResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("results")
    private List<Review> result = new ArrayList<Review>();

    public ReviewResponse() {
    }

    public ReviewResponse(int id, List<Review> result) {
        this.id = id;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Review> getResult() {
        return result;
    }

    public void setResult(List<Review> result) {
        this.result = result;
    }
}
