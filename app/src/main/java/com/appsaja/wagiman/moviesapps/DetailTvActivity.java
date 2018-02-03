package com.appsaja.wagiman.moviesapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsaja.wagiman.moviesapps.model.TvDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wagiman on 2/3/2018.
 */

public class DetailTvActivity extends AppCompatActivity {

    ImageView img;
    TextView titleTv;
    TextView genreTv;
    TextView productionTv;
    TextView durationTv;
    TextView voteTv;
    TextView overviewTv;
    TextView releaseDate;

    TvDetail tvDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        getSupportActionBar().setTitle("Detail TV");

        binding();

        getResponse();
    }

    private void binding(){
        img = findViewById(R.id.imageDetail);
        titleTv = findViewById(R.id.titleDetail);
        genreTv = findViewById(R.id.genre);
        durationTv = findViewById(R.id.duration);
        productionTv = findViewById(R.id.production);
        voteTv = findViewById(R.id.vote);
        overviewTv = findViewById(R.id.overview);
        releaseDate = findViewById(R.id.releaseDate);
    }

    private void getResponse(){
        RetrofitApi retrofitApi = App.getRetrofit().create(RetrofitApi.class);
        Call<TvDetail> call = retrofitApi.getDetailTv(getIdTv(),App.KEY_API);
        call.enqueue(new Callback<TvDetail>() {
            @Override
            public void onResponse(Call<TvDetail> call, Response<TvDetail> response) {
//                String genre = "";
                tvDetail = new TvDetail();
                tvDetail.setPoster(response.body().getPoster());
                tvDetail.setTitle(response.body().getTitle());
                tvDetail.setGenres(response.body().getGenres());
                tvDetail.setDuration(response.body().getDuration());
                tvDetail.setCompanies(response.body().getCompanies());
                tvDetail.setVote(response.body().getVote());
                tvDetail.setOverview(response.body().getOverview());
                tvDetail.setReleased_date(response.body().getReleased_date());

                App.setImageRs(DetailTvActivity.this,App.BASE_URL_IMAGE+tvDetail.getPoster(),img);
                titleTv.setText(tvDetail.getTitle());
                durationTv.setText(tvDetail.getDuration().get(0)+" minute");

                if (tvDetail.getCompanies().size() > 0){
                    productionTv.setText(tvDetail.getCompanies().get(0).getName());
                }else {
                    productionTv.setText("-");
                }
                voteTv.setText(tvDetail.getVote());
                overviewTv.setText(tvDetail.getOverview());
                releaseDate.setText(tvDetail.getReleased_date());

                if (tvDetail.getGenres().size() > 0){
//                    for (int x = 0; x < tvDetail.getGenres().size(); x++){
//                        genre = genre + tvDetail.getGenres().get(x).getName()+", ";
//                    }
                    genreTv.setText(tvDetail.getGenres().get(0).getName());
                }else {
                    genreTv.setText("-");
                }
            }

            @Override
            public void onFailure(Call<TvDetail> call, Throwable t) {
                Log.e("ERROR API", t.toString());
            }
        });
    }


    public String getIdTv() {
        Intent i = getIntent();
        String idTv = i.getStringExtra(App.TAG_ID_TV);
        return idTv;
    }
}
