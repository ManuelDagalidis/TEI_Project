package com.coding_quest.gr_an.tei_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ArtistSpec extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArtistPedalAdapter adapter;
    private List<Pedal> pedalList;
    private ArrayList<String> pedals;

    private FirebaseFirestore db;

    private Artist artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artists_spec);

        // Get the intent from RecyclerViewAdapter

        artist = (Artist) getIntent().getSerializableExtra("artist");

        pedals = artist.getPedals();

        // Define the views within the layout

        TextView artistName = (TextView) findViewById(R.id.artistName);
        TextView artistBand = (TextView) findViewById(R.id.artistBand);
        TextView sName = (TextView) findViewById(R.id.name);
        TextView sBand = (TextView) findViewById(R.id.band);
        Toolbar artistToolbar = (Toolbar) findViewById(R.id.spec_toolbar);
        ImageView artistImage = (ImageView) findViewById(R.id.artistImg);

        // Set the view attributes with values loaded from the database

        Glide.with(this)
                .asBitmap()
                .load(artist.getImgurl())
                .into(artistImage);

        artistName.setText(" " + artist.getName() + " ");
        artistBand.setText(" " + artist.getBand() + " ");
        sName.setText(" name ");
        sBand.setText(" band ");
        artistToolbar.setTitle(artist.getName().toUpperCase());

        // Initialize the RecyclerView Adapter for the artists_spec layout

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.pedalRecycler);
        recyclerView.setLayoutManager(layoutManager);

        pedalList = new ArrayList<>();
        adapter = new ArtistPedalAdapter(this, pedalList);

        recyclerView.setAdapter(adapter);

        // Get instance from Firestore

        db = FirebaseFirestore.getInstance();

        for (int i = 0; i < pedals.size(); i++)
        {
            db.collection("pedals").document(pedals.get(i)).get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            Pedal p = documentSnapshot.toObject(Pedal.class);
                            pedalList.add(p);
                            adapter.notifyDataSetChanged();
                        }
                    });
/*
            if(i == (pedals.size() - 1))
            {
                adapter.notifyDataSetChanged();
            }
*/
        }


    }
}
