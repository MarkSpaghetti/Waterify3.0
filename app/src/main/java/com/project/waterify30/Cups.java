package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cups extends AppCompatActivity {

    private Button fiftyML, hundredML, hundredFiftyML, twoHundredML;
    private Logic logic = new Logic();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cups);

        fiftyML = (Button) findViewById(R.id.fifty_ml);
        fiftyML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Cups.this, Statistics.class);
                i1.putExtra("fifty_ml", 50);
                startActivity(i1);

                //TODO how to make toast to show up?
                Toast.makeText(getApplicationContext(),"Hurray, you drunk 50ml of water!", Toast.LENGTH_LONG).show();

                logic.openActivity(Cups.this,Homepage.class);
            }
        });


        hundredML = (Button) findViewById(R.id.hundred_ml);
        hundredML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Cups.this, Statistics.class);
                i2.putExtra("hundred_ml", 100);
                startActivity(i2);

                logic.openActivity(Cups.this,Homepage.class);
            }
        });

        hundredFiftyML = (Button) findViewById(R.id.hundred_fifty_ml);
        hundredFiftyML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Cups.this, Statistics.class);
                i3.putExtra("hundred_fifty_ml", 150);
                startActivity(i3);

                logic.openActivity(Cups.this,Homepage.class);
            }
        });

        twoHundredML = (Button) findViewById(R.id.two_hundred_ml);
        twoHundredML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Cups.this, Statistics.class);
                i4.putExtra("two_hundred_ml", 200);
                startActivity(i4);

                logic.openActivity(Cups.this,Homepage.class);
            }
        });
    }
}