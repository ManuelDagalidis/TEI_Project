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
}
