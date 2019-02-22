package com.coding_quest.gr_an.tei_project;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadein);


        ImageView artButton = findViewById(R.id.imageView5);
        ImageView pdlButton = findViewById(R.id.imageView10);
        TextView artText = findViewById(R.id.artText);
        TextView pedalText = findViewById(R.id.pdlText);

        artButton.startAnimation(animation);
        pdlButton.startAnimation(animation);
        artText.startAnimation(animation);
        pedalText.startAnimation(animation);

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        Glide.with(this)
                .asBitmap()
                .load("https://assets.radiox.co.uk/2018/08/flea-from-red-hot-chili-peppers-in-2007-1519741652-article-0.jpg")
                .into(artButton);

        Glide.with(this)
                .asBitmap()
                .load("https://www.stratcat.biz/images/pedal_board_11132010_950.jpg")
                .into(pdlButton);


        artButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArtActivity.class));
            }

        });


        pdlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PedalList.class);
                startActivity(intent);
            }
        });
    }
}

