package com.coding_quest.gr_an.tei_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter1 {


    public class  RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
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
        public View


        ImageView image;
        TextView name;


        public ViewHo


    }




}
