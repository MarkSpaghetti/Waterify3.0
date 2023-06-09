package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Cups extends AppCompatActivity {


    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button fiftyML, hundredML, hundredFiftyML, twoHundredML;
        ImageButton buttonClose;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cups);

        buttonClose = findViewById(R.id.button_close_cupsize);

        buttonClose.setOnClickListener(v -> logic.openActivity(getApplicationContext(), Homepage.class));

        fiftyML = findViewById(R.id.fifty_ml);
        logic.setClickListener(fiftyML, 50, "Hurray, you drank 50ml of water!", getApplicationContext());

        hundredML = findViewById(R.id.hundred_ml);
        logic.setClickListener(hundredML, 100, "Hurray, you drank 100ml of water!", getApplicationContext());

        hundredFiftyML = findViewById(R.id.hundred_fifty_ml);
        logic.setClickListener(hundredFiftyML, 150, "Hurray, you drank 150ml of water!", getApplicationContext());

        twoHundredML = findViewById(R.id.two_hundred_ml);
        logic.setClickListener(twoHundredML, 200, "Hurray, you drank 200ml of water!", getApplicationContext());

    }
}