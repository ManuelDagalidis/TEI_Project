package com.coding_quest.gr_an.tei_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AlertDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show the custom toolbar (top bar) instead of the default one

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        // Button for the Artist List

        Button artButton = findViewById(R.id.art_button);

        artButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArtActivity.class));
            }

        });

        // Button for the Pedal List, prompting an AlertDialog

        Button pdlButton = findViewById(R.id.pdl_btn);

        pdlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder instrBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.pedal_instr, null);

                Button guitarBtn = (Button) mView.findViewById(R.id.guitarBtn);
                Button bassBtn = (Button) mView.findViewById(R.id.bassBtn);

                // What happens when user clicks on Guitar Button

                guitarBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PedalTypes.class);
                        intent.putExtra("instr", "guitar");
                        startActivity(intent);
                    }
                });

                // What happens when user clicks on Bass Button

                bassBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PedalTypes.class);
                        intent.putExtra("instr", "bass");
                        startActivity(intent);
                    }

                });

                // Show the AlertDialog when the Pedal Types button has been clicked

                instrBuilder.setView(mView);
                AlertDialog dialog = instrBuilder.create();
                dialog.show();
            }
        });

    }
}

