package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Cups extends AppCompatActivity {

    private Button fiftyML, hundredML, hundredFiftyML, twoHundredML;
    private ImageButton buttonClose;
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cups);

        fiftyML = (Button) findViewById(R.id.fifty_ml);

        buttonClose = findViewById(R.id.button_close_cupsize);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(getApplicationContext(), Homepage.class);
            }
        });
        fiftyML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.cup = 50;
                Toast.makeText(getApplicationContext(), "Hurray, you drunk 50ml of water!", Toast.LENGTH_LONG).show();

                logic.openActivity(Cups.this, Homepage.class);
            }
        });


        hundredML = (Button) findViewById(R.id.hundred_ml);
        hundredML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.cup = 100;
                Toast.makeText(getApplicationContext(), "Hurray, you drunk 100ml of water!", Toast.LENGTH_LONG).show();

                logic.openActivity(Cups.this, Homepage.class);
            }
        });

        hundredFiftyML = (Button) findViewById(R.id.hundred_fifty_ml);
        hundredFiftyML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.cup = 150;
                Toast.makeText(getApplicationContext(), "Hurray, you drunk 150ml of water!", Toast.LENGTH_LONG).show();
                logic.openActivity(Cups.this, Homepage.class);
            }
        });

        twoHundredML = (Button) findViewById(R.id.two_hundred_ml);
        twoHundredML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.cup = 200;
                Toast.makeText(getApplicationContext(), "Hurray, you drunk 200ml of water!", Toast.LENGTH_LONG).show();

                logic.openActivity(Cups.this, Homepage.class);
            }
        });
    }
}