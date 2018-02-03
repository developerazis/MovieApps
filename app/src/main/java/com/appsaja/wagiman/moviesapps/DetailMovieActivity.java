package com.appsaja.wagiman.moviesapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsaja.wagiman.moviesapps.model.MovieDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wagiman on 2/2/2018.
 */

public class DetailMovieActivity extends AppCompatActivity {

    ImageView img;
    TextView titleMovie;
    TextView genreMovie;
    TextView productionMovie;
    TextView durationMovie;
    TextView voteMovie;
    TextView overviewMovie;
    TextView releaseDate;

    MovieDetail details;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        getSupportActionBar().setTitle("Detail Movie");

        binding();
        getResponse();

    }

    private void getResponse(){
        RetrofitApi api = App.getRetrofit().create(RetrofitApi.class);
        Call<MovieDetail> call = api.getMovieDetail(getIdMovie(),App.KEY_API);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                details = new MovieDetail();
                details.setId(response.body().getId());
                details.setGenres(response.body().getGenres());
                details.setCompanies(response.body().getCompanies());
                details.setPoster_path(response.body().getPoster_path());
                details.setTitle(response.body().getTitle());
                details.setOverview(response.body().getOverview());
                details.setRelease_date(response.body().getRelease_date());
                details.setVoteAverage(response.body().getVoteAverage());
                details.setDuration(response.body().getDuration());
//                Log.i("TEST",details.getTitle());
                App.setImageRs(DetailMovieActivity.this,App.BASE_URL_IMAGE+details.getPoster_path(),img);
                titleMovie.setText(details.getTitle());
                if (details.getGenres().size() > 0){
                    genreMovie.setText(details.getGenres().get(0).getName());
                }else {
                    genreMovie.setText("-");
                }
                if (details.getCompanies().size() > 0){
                    productionMovie.setText(details.getCompanies().get(0).getName());
                }else {
                    productionMovie.setText("-");
                }
                durationMovie.setText(details.getDuration()+ " minutes");
                releaseDate.setText(details.getRelease_date());
                voteMovie.setText(details.getVoteAverage().toString());
                overviewMovie.setText(details.getOverview());

            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Log.e("ERROR API", t.toString());
            }
        });

    }

    private void binding(){
        img = findViewById(R.id.imageDetail);
        titleMovie = findViewById(R.id.titleDetail);
        genreMovie = findViewById(R.id.genre);
        durationMovie = findViewById(R.id.duration);
        productionMovie = findViewById(R.id.production);
        voteMovie = findViewById(R.id.vote);
        overviewMovie = findViewById(R.id.overview);
        releaseDate = findViewById(R.id.releaseDate);

    }

    private int getIdMovie(){
        Intent i = getIntent();
        int id = Integer.parseInt(i.getStringExtra(App.TAG_ID_MOVIE));
        return id;
    }
}
