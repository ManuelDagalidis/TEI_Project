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

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mArtistNames = new ArrayList<>();
    private ArrayList<String> mArtistImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> artistNames, ArrayList<String> artistImages) {
        this.mArtistNames = artistNames;
        this.mArtistImages = artistImages;
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

        Glide.with(mContext)
                .asBitmap()
                .load(mArtistImages.get(position))
                .into(holder.artistImage);

        holder.artistName.setText(mArtistNames.get(position));

        holder.artistlistLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " +mArtistNames.get(position));

                Intent intent = new Intent(mContext, ArtistSpec.class);
                intent.putExtra("artistImage_res", mArtistImages.get(position));
                intent.putExtra("artistName", mArtistNames.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mArtistImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView artistImage;
        TextView artistName;
        RelativeLayout artistlistLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artistImage = itemView.findViewById(R.id.artist_thumbnail);
            artistName = itemView.findViewById(R.id.artist_name);
            artistlistLayout = itemView.findViewById(R.id.artistlist_layout);
        }
    }
}
