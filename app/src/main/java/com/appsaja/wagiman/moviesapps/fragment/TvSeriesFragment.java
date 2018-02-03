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
import com.appsaja.wagiman.moviesapps.DetailTvActivity;
import com.appsaja.wagiman.moviesapps.R;
import com.appsaja.wagiman.moviesapps.RetrofitApi;
import com.appsaja.wagiman.moviesapps.adapter.RecyclerViewAdapterTv;
import com.appsaja.wagiman.moviesapps.adapter.SpaceItem;
import com.appsaja.wagiman.moviesapps.implement.ItemClickListener;
import com.appsaja.wagiman.moviesapps.model.MovieResponse;
import com.appsaja.wagiman.moviesapps.model.Tv;
import com.appsaja.wagiman.moviesapps.model.TvResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wagiman on 1/30/2018.
 */

public class TvSeriesFragment extends Fragment implements ItemClickListener {

    View tvSeriesView;
    RecyclerViewAdapterTv rAdapter;
    RecyclerView rView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    List<Tv> tvList = new ArrayList<>();

    public TvSeriesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tvSeriesView = inflater.inflate(R.layout.main_layout,container, false);
        rView = tvSeriesView.findViewById(R.id.recycler);
        getTvFromApi();
        return tvSeriesView;
    }

    public void getTvFromApi(){
        rAdapter = new RecyclerViewAdapterTv(tvList,getActivity().getApplicationContext());
        rAdapter.setClick(this);
        rView.setHasFixedSize(true);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        rView.setLayoutManager(staggeredGridLayoutManager);
        rView.setAdapter(rAdapter);

        SpaceItem spaceItem = new SpaceItem(2);
        rView.addItemDecoration(spaceItem);
        RetrofitApi retrofitApi = App.getRetrofit().create(RetrofitApi.class);
        for (int x =1; x<= 5; x++){
            Call<TvResponse> call = retrofitApi.getPopularTv(App.KEY_API,x);
            call.enqueue(new Callback<TvResponse>() {
                @Override
                public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                    tvList.addAll(response.body().getResults());
                    rAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<TvResponse> call, Throwable t) {
                    Log.e("ERROT API", t.toString());
                }
            });
        }
    }


    @Override
    public void onClick(View v, int pos) {
        Intent intent = new Intent(getActivity(), DetailTvActivity.class);
        intent.putExtra(App.TAG_ID_TV, tvList.get(pos).getId());
        startActivity(intent);
    }
}
