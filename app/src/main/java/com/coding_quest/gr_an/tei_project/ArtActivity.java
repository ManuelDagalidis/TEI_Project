package com.coding_quest.gr_an.tei_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ArtActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private List<Artist> artistList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        Log.d(TAG, "onCreate: started");

        // Show the custom toolbar (top bar) instead of the default one

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.artists_toolbar);
        setSupportActionBar(mainToolbar);

        recyclerView = findViewById(R.id.artists_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        artistList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(this, artistList);

        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        db.collection("artists").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for (DocumentSnapshot d : list) {

                                Artist a = d.toObject(Artist.class);
                                artistList.add(a);
                            }

                            adapter.notifyDataSetChanged();

                        }
                    }
                });
    }
}

