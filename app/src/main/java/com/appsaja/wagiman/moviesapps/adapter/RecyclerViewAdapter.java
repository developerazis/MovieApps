package com.appsaja.wagiman.moviesapps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsaja.wagiman.moviesapps.App;
import com.appsaja.wagiman.moviesapps.R;
import com.appsaja.wagiman.moviesapps.implement.ItemClickListener;
import com.appsaja.wagiman.moviesapps.model.Movie;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Wagiman on 1/21/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Movie> movies;
    Context mContext;
    ItemClickListener itemClickListener;

    public RecyclerViewAdapter(List<Movie> movies, Context mContext) {
        this.movies = movies;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleMovie.setText(movies.get(position).getTitle());
        App.setImageRs(holder.itemView.getContext(),App.BASE_URL_IMAGE+movies.get(position).getPoster_path(),holder.imageMovie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setClick(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageMovie;
        TextView  titleMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            imageMovie = itemView.findViewById(R.id.imageMovie);
            titleMovie = itemView.findViewById(R.id.titleMovie);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
