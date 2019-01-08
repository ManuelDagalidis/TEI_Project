package com.coding_quest.gr_an.tei_project;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class Tab3Fragment extends Fragment {

    private List<Pedal> pedalList;
    private RecyclerView recyclerView;
    private PedalListAdapter adapter;
    private String instrument;

    private FirebaseFirestore db;
    private Context context;

    private Pedal pedal;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        // instrument = getArguments().getString("instrument");

        View view = inflater.inflate(R.layout.fragment_pedal_list, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.pdlListRecycler);
        recyclerView.setLayoutManager(layoutManager);

        pedalList = new ArrayList<>();
        adapter = new PedalListAdapter(getActivity(), pedalList);

        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        CollectionReference pedalsRef = db.collection("pedals");

        pedalsRef.whereEqualTo("type", "pitch shifter")
                 .get()
                 .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         if (!queryDocumentSnapshots.isEmpty()) {
                             List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                             for (DocumentSnapshot d : list) {
                                 Pedal p = d.toObject(Pedal.class);
                                 pedalList.add(p);
                             }

                             adapter.notifyDataSetChanged();
                         }
                     }
                 });



        return view;
    }

}
