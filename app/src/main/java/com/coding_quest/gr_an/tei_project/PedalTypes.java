package com.coding_quest.gr_an.tei_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class PedalTypes extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";
    
    //variables
    private ArrayList<String> mPedalImage = new ArrayList<>();
    private ArrayList<String> mPedalTypes = new ArrayList<>();    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedal_list);
    }

private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
    
        mPedalImage.add("https://www.sweetwater.com/insync/media/2019/01/pedals-650x432.jpg");
        mPedalTypes.add("Overdrive- Distortion- Fuzz");

        mPedalImage.add("http://www.vintageguitar.com/wp-content/uploads/MOD_SQUAD_FEATURE.jpg");
        mPedalTypes.add("Modulation");

        mPedalImage.add("https://d6a2e7ghqts3o.cloudfront.net/AcuCustom/Sitename/DAM/510/2018GPX9CompactEchoverbPedals700-min.jpg");
        mPedalTypes.add("Delay- Reverb");

        mPedalImage.add("https://www.andertons.co.uk/wcsstore/andertons-sas/images/buyers-guide-assets/Guitar-Octave-Pedal-Guide-Andertons-Music-Co-min.JPG");
        mPedalTypes.add("Pitch Control");

        mPedalImage.add("https://www.binaural.es/wp-content/uploads/2016/03/pedales.jpg");
        mPedalTypes.add("Other FX");
    
    initRecyclerView();
    
    }
    
     private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.artists_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mPedalImage, mPedalTypes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
