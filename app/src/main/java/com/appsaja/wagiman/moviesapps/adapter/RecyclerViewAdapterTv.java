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
import com.appsaja.wagiman.moviesapps.model.Tv;

import java.util.List;

/**
 * Created by Wagiman on 2/3/2018.
 */

public class RecyclerViewAdapterTv extends RecyclerView.Adapter<RecyclerViewAdapterTv.ViewHolder> {
    List<Tv> tvList;
    Context mContext;
    ItemClickListener itemClickListener;

    public RecyclerViewAdapterTv(List<Tv> tvList, Context mContext) {
        this.tvList = tvList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleTv.setText(tvList.get(position).getTitle());
        App.setImageRs(mContext,App.BASE_URL_IMAGE+tvList.get(position).getPoster(),holder.imageTv);
    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

    public void setClick(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageTv;
        TextView titleTv;

        public ViewHolder(View itemView) {
            super(itemView);
            imageTv = itemView.findViewById(R.id.imageMovie);
            titleTv = itemView.findViewById(R.id.titleMovie);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
