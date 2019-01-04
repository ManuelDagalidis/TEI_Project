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

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter2";

    private ArrayList<String> mPedalImage = new ArrayList<>();
    private ArrayList<String> mPedalTypes = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter2(Context context, ArrayList<String> pedalImage, ArrayList<String> pedalTypes) {
        this.mPedalImage = pedalImage;
        this.mPedalTypes = pedalTypes;
        this.mContext = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i ) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pedal_list, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                    .asBitmap()
                    .load(mPedalImage.get(position))
                    .into(holder.pedalImage);

        holder.pedalTypes.setText(mPedalTypes.get(position));

            holder.pedallistLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: clicked on: " +mPedalImage.get(position));

                    Intent intent = new Intent(mContext, ArtistSpec.class);
                    intent.putExtra("pedalTypes_res", mPedalTypes.get(position));
                    intent.putExtra("pedalImage", mPedalImage.get(position));
                    mContext.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() { return mPedalTypes.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            ImageView pedalImage;
            TextView pedalTypes;
            RelativeLayout pedallistLayout;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                pedalImage = itemView.findViewById(R.id.artist_thumbnail);
                pedalTypes = itemView.findViewById(R.id.artist_name);
                pedallistLayout = itemView.findViewById(R.id.artistlist_layout);
            }
        }
    }



















