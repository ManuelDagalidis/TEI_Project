package com.coding_quest.gr_an.tei_project;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.support.v7.app.AlertDialog;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable btn_img1 = getDrawable(R.drawable.artists);
        Drawable shape = getDrawable(R.drawable.rounded_rectangle);


        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        final Animation animationClk = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        final Animation animationEnd = AnimationUtils.loadAnimation(this, R.anim.zoomout);


        final FrameLayout artButton = findViewById(R.id.artists_frame);
        final FrameLayout pdlButton = findViewById(R.id.pedals_frame);
        final FrameLayout chnButton = findViewById(R.id.chain_frame);
        final FrameLayout strButton = findViewById(R.id.stores_frame);
        final FrameLayout nwsButton = findViewById(R.id.news_frame);
        final FrameLayout topButton = findViewById(R.id.toprated_frame);


        //TextView artText = findViewById(R.id.artText);
        //TextView pedalText = findViewById(R.id.pdlText);

        //artButton.startAnimation(animation);
        //pdlButton.startAnimation(animation);
        //artText.startAnimation(animation);
        //pedalText.startAnimation(animation);

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        //artButton.setImageResource(R.drawable.artists);

        //Glide.with(this)
        //        .asBitmap()
        //        .load("https://www.stratcat.biz/images/pedal_board_11132010_950.jpg")
        //        .into(pdlButton);


        artButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pdlButton.startAnimation(animation);
                chnButton.startAnimation(animation);
                strButton.startAnimation(animation);
                nwsButton.startAnimation(animation);
                topButton.startAnimation(animation);
                startActivity(new Intent(MainActivity.this, ArtActivity.class));
            }

        });


        pdlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pdlButton.startAnimation(animationClk);
                pdlButton.startAnimation(animationEnd);
                Intent intent = new Intent(MainActivity.this, PedalList.class);
                startActivity(intent);
            }
        });
/*
        protected void fadeAnimation {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }

*/
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}

