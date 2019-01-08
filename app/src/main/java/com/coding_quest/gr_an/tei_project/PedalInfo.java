package com.coding_quest.gr_an.tei_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;



public class PedalInfo extends AppCompatActivity {



    private Pedal pedal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedal_info);

        // Get the intent from RecyclerViewAdapter

        pedal = (Pedal) getIntent().getSerializableExtra("pedal");


        // Define the views within the layout

        TextView pedalName = (TextView) findViewById(R.id.pedalName);
        TextView pedalEffect = (TextView) findViewById(R.id.pedalEffect);
        Toolbar pedalToolbar = (Toolbar) findViewById(R.id.pedal_info_toolbar);
        ImageView pedalImg = (ImageView) findViewById(R.id.pedalImg);

        // Set the view attributes with values loaded from the database

        Glide.with(this)
                .asBitmap()
                .load(pedal.getImgurl())
                .into(pedalImg);

        pedalName.setText(" " + pedal.getName() + " ");
        pedalEffect.setText(" " + pedal.getEffect() + " ");
        pedalToolbar.setTitle(pedal.getName().toUpperCase());




    }
}
