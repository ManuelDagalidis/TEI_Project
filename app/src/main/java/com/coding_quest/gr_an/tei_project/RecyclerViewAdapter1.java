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

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

        private static final String TAG = "RecyclerViewAdapter1";

        private ArrayList<String> mPedalNames = new ArrayList<>();
        private ArrayList<String> mPedalImages = new ArrayList<>();
        private Context mContext;


        public RecyclerViewAdapter1(Context context, ArrayList<String> pedalNames, ArrayList<String> pedalImages) {

            this.mPedalNames = pedalNames;
            this.mPedalImages = pedalImages;
            this.mContext = context;

        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_artist_spec, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            Log.d(TAG, "onBindViewHolder: called.");

            Glide.with(mContext)
                    .asBitmap()
                    .load(mPedalImages.get(position))
                    .into(holder.pedalImage);

            holder.pedalName.setText(mPedalNames.get(position));

            holder.artistpedalLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: clicked on: " + mPedalNames.get(position));

                    Intent intent = new Intent(mContext, Pedal.class);
                    intent.putExtra("pedalImage_res", mPedalImages.get(position));
                    intent.putExtra("pedalName", mPedalNames.get(position));
                    mContext.startActivity(intent);
                }
            });


        }


        @Override
        public int getItemCount() {
            return mPedalImages.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView pedalImage;
            TextView pedalName;
            RelativeLayout artistpedalLayout;

            public ViewHolder(@NonNull View itemView) {

                super(itemView);
                pedalImage = itemView.findViewById(R.id.pedal_image);
                pedalName = itemView.findViewById(R.id.pedal_name);
                artistpedalLayout = itemView.findViewById(R.id.artistspec_layout);
            }

        }


    }
