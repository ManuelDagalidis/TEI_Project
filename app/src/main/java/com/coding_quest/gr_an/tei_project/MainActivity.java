package com.coding_quest.gr_an.tei_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button artButton = findViewById(R.id.art_button);

        artButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArtActivity.class));
            }

        });

        Button pdlButton = findViewById(R.id.pdl_btn);

        pdlButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder instrBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.pedal_instr, null);
                Button guitarBtn = (Button) mView.findViewById(R.id.guitarBtn);
                Button bassBtn = (Button) mView.findViewById(R.id.bassBtn);

                guitarBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PedalTypes.class);
                        intent.putExtra("instr", "guitar");
                        startActivity(intent);
                    }
                });

                bassBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PedalTypes.class);
                        intent.putExtra("instr", "bass");
                        startActivity(intent);
                    }

                });

                instrBuilder.setView(mView);
                AlertDialog dialog = instrBuilder.create();
                dialog.show();
            }
        });

    }
}

