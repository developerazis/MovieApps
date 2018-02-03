package com.appsaja.wagiman.moviesapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsaja.wagiman.moviesapps.model.Review;
import com.appsaja.wagiman.moviesapps.model.ReviewResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wagiman on 2/1/2018.
 */

public class ReviewActivity extends AppCompatActivity {

    private String id;
    private String path_poster;


    private ImageView img;
    private TextView textContent;

    List<Review> review ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_movie);
        getSupportActionBar().setTitle("Review");

        getIntentMovie();
        Log.i("TEST", id+" : "+path_poster);
        binding();
        App.setImageRs(this,App.BASE_URL_IMAGE+path_poster,img);

        getContent();

    }

    private void getContent(){
        RetrofitApi retrofitApi = App.getRetrofit().create(RetrofitApi.class);
        Call<ReviewResponse> responseCall = retrofitApi.getReview(id, App.KEY_API);
        responseCall.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
//                review = response.body().getResult();
//                textContent.setText(review.get(0).getContent());
                Log.i("SIZE",String.valueOf(response.body().getResult().size()));
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {
                Log.e("ERROR API", t.toString());
            }
        });
    }

    private void getIntentMovie(){
        Intent i = getIntent();
        id = i.getStringExtra(App.TAG_ID_MOVIE);
        path_poster = i.getStringExtra(App.TAG_PATH_MOVIE);


    }

    private void binding(){
        img = findViewById(R.id.imageReview);
        textContent = findViewById(R.id.contentReview);
    }


}
