package com.appsaja.wagiman.moviesapps.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsaja.wagiman.moviesapps.App;
import com.appsaja.wagiman.moviesapps.DetailMovieActivity;
import com.appsaja.wagiman.moviesapps.R;
import com.appsaja.wagiman.moviesapps.RetrofitApi;
import com.appsaja.wagiman.moviesapps.ReviewActivity;
import com.appsaja.wagiman.moviesapps.adapter.RecyclerViewAdapter;
import com.appsaja.wagiman.moviesapps.adapter.SpaceItem;
import com.appsaja.wagiman.moviesapps.implement.ItemClickListener;
import com.appsaja.wagiman.moviesapps.model.Movie;
import com.appsaja.wagiman.moviesapps.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wagiman on 1/29/2018.
 */

public class NowPlayingFragment extends Fragment implements ItemClickListener {


    View nowPlayingView;
    RecyclerViewAdapter rAdapter;
    RecyclerView rView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    List<Movie> movieList = new ArrayList<>();

    public NowPlayingFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        nowPlayingView = inflater.inflate(R.layout.main_layout, container, false);
        rView = (RecyclerView) nowPlayingView.findViewById(R.id.recycler);
        getMovieFromApi();

        return nowPlayingView;
    }

    public void getMovieFromApi(){
        rAdapter = new RecyclerViewAdapter(movieList,getActivity().getApplicationContext());
        rView.setHasFixedSize(true);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        rView.setLayoutManager(staggeredGridLayoutManager);
        rView.setAdapter(rAdapter);

        SpaceItem spaceItem = new SpaceItem(2);
        rView.addItemDecoration(spaceItem);
        RetrofitApi retrofitApi = App.getRetrofit().create(RetrofitApi.class);
        for (int x =1; x<= 5; x++){
            Call<MovieResponse> call = retrofitApi.getNowPlaying(App.KEY_API,x);
            call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movieList.addAll(response.body().getResults());
                rAdapter.notifyDataSetChanged();
//                List<Movie> movieList = response.body().getResults();
                Log.d("RESULTS", "Page: " + response.body().getPage() + "\n"
                +"Total Page: "+response.body().getTotalPages() +"\n" + "Total result: "+ response.body().getTotal_results()+"\n"+
                "Movies : "+movieList.get(3).getTitle());
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("ERROR API", t.toString());
            }
        });
      }

      rAdapter.setClick(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Intent intent = new Intent(getActivity(), DetailMovieActivity.class);
        intent.putExtra(App.TAG_ID_MOVIE, movieList.get(pos).getId());
//        intent.putExtra(App.TAG_PATH_MOVIE, movieList.get(pos).getPoster_path());
         startActivity(intent);
    }
}
