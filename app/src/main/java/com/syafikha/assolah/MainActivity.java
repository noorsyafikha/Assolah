package com.syafikha.assolah;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnshowMosques;
    Button btnSet;
    Button btnNoti;
    final Context context= this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSet=(Button) findViewById(R.id.btnAlarm);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy1=new Intent(MainActivity.this,alarm.class);
                startActivity(toy1);
            }
        });


        btnshowMosques=(Button) findViewById(R.id.btnNearbyMosque);
        btnshowMosques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(toy);
            }
        });



    }

    }

