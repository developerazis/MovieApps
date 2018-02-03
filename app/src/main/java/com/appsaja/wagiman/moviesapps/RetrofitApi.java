package com.appsaja.wagiman.moviesapps;

import com.appsaja.wagiman.moviesapps.model.MovieDetail;
import com.appsaja.wagiman.moviesapps.model.MovieResponse;
import com.appsaja.wagiman.moviesapps.model.ReviewResponse;
import com.appsaja.wagiman.moviesapps.model.TvDetail;
import com.appsaja.wagiman.moviesapps.model.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Wagiman on 1/21/2018.
 */

public interface RetrofitApi {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopMovie(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/{movie_id}")
    Call<MovieDetail> getMovieDetail(@Path("movie_id") int id, @Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlaying(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/{movie_id}/reviews")
    Call<ReviewResponse> getReview(@Path("movie_id") String id, @Query("api_key") String apiKey);

    @GET("tv/popular")
    Call<TvResponse> getPopularTv(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("tv/{tv_id}")
    Call<TvDetail> getDetailTv(@Path("tv_id") String tvid, @Query("api_key") String apiKey);

}
