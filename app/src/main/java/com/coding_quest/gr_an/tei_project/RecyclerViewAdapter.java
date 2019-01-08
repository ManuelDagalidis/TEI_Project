package com.coding_quest.gr_an.tei_project;

import android.content.Context;
import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";


    private List<Artist> artistList;
    private Context mContext;

    public RecyclerViewAdapter(Context context, List<Artist> artistList) {
        this.artistList = artistList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artists_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Artist artist = artistList.get(position);

        Glide.with(mContext)
                .asBitmap()
                .load(artist.getImgurl())
                .into(holder.artistImage);

        holder.artistName.setText(artist.getName());
        holder.artistBand.setText(artist.getBand());

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView artistImage;
        TextView artistName, artistBand;
        RelativeLayout artistlistLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistImage = itemView.findViewById(R.id.artist_thumbnail);
            artistName = itemView.findViewById(R.id.artist_name);
            artistBand = itemView.findViewById(R.id.artist_band);
            artistlistLayout = itemView.findViewById(R.id.artistlist_layout);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Artist artist = artistList.get(getAdapterPosition());
            Intent intent = new Intent(mContext, ArtistSpec.class);
            intent.putExtra("artist", artist);
            mContext.startActivity(intent);
        }
    }
}
