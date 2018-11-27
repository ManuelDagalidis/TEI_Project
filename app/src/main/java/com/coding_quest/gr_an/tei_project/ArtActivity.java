package com.coding_quest.gr_an.tei_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ArtActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //variables
    private ArrayList<String> mArtistImages = new ArrayList<>();
    private ArrayList<String> mArtistNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);
        Log.d(TAG, "onCreate: started");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mArtistImages.add("https://assets.radiox.co.uk/2018/08/flea-from-red-hot-chili-peppers-in-2007-1519741652-article-0.jpg");
        mArtistNames.add("FLEA");

        mArtistImages.add("https://assets.radiox.co.uk/2018/04/john-frusciante-with-red-hot-chili-peppers-in-2006-1517578088-article-0.jpg");
        mArtistNames.add("FRUSCIANTE");

        mArtistImages.add("https://hips.hearstapps.com/esquireuk.cdnds.net/15/37/original/original-kurt-cobain-style-43-jpg-151570f5.jpg");
        mArtistNames.add("KURT COBAIN");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.artists_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mArtistNames, mArtistImages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
