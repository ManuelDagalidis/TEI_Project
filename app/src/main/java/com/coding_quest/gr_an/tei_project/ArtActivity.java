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
        mArtistNames.add("JOHN FRUSCIANTE");

        mArtistImages.add("https://hips.hearstapps.com/esquireuk.cdnds.net/15/37/original/original-kurt-cobain-style-43-jpg-151570f5.jpg");
        mArtistNames.add("KURT COBAIN");

        mArtistImages.add("https://mm.aiircdn.com/140/981036.jpg");
        mArtistNames.add("MARCUS MILLER");

        mArtistImages.add("https://www.aceshowbiz.com/images/wennpic/rage-against-the-machine-performing-at-sydney-entertainment-centre-10.jpg");
        mArtistNames.add("TOM MORELLO");

        mArtistImages.add("https://ksassets.timeincuk.net/wp/uploads/sites/55/2017/08/GettyImages-84894709-920x584.jpg");
        mArtistNames.add("JIMMY HENDRIX");

        mArtistImages.add("https://d15v4l58k2n80w.cloudfront.net/file/1396975600/29513508319/width=1280/height=720/format=JPG/fit=crop/crop=0x378+4037x2273/rev=3/t=402494/e=never/k=6f568f2d/DavidGilmourByBrianRasic_274.jpg");
        mArtistNames.add("DAVID GILMOUR");

        mArtistImages.add("http://img.wennermedia.com/social/essentials-f731032e-5ccb-4ae7-a755-923166cc967e.jpg");
        mArtistNames.add("CHRIS CORNELL");

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
