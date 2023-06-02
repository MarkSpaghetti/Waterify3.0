package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Shop extends AppCompatActivity {

    private ImageButton buttonHome, plant1, plant2;
    private Logic logic = new Logic();

    public static final String KEY1 = "photo", KEY2 = "photo2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        PopUpWindow_coins pop = new PopUpWindow_coins();

        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Shop.this, Homepage.class);
            }
        });



        /*

        plant1 = (ImageButton) findViewById(R.id.plant1);
        plant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Shop.this, UserGarden.class);
                i1.putExtra ("imageResource1", R.drawable.plant_1);
                startActivityForResult(i1, 1);
            }
        });

        plant2 = (ImageButton) findViewById(R.id.plant2);
        plant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Shop.this, UserGarden.class);
                i2.putExtra ("imageResource2", R.drawable.plant_2);
                startActivityForResult(i2, 1);
            }
        });



        plant1 = (ImageButton) findViewById(R.id.plant1);
        plant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop.this, UserGarden.class);
                intent.putExtra(KEY1, R.drawable.plant_1);
                startActivity(intent);
            }
        });

        */


        ImageButton plant1 = findViewById(R.id.plant1);
        plant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the new image resource identifier to SharedPreferences
                SharedPreferences preferences1 = getApplicationContext().getSharedPreferences("prefs1", 0);
                SharedPreferences.Editor editor1 = preferences1.edit();
                editor1.putInt("resource1", R.drawable.plant_1);
                editor1.apply();

                // Start ActivityB
                Intent intent = new Intent(Shop.this, UserGarden.class);
                startActivity(intent);
            }
        });

        ImageButton plant2 = findViewById(R.id.plant2);
        plant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pop.getDroplets() >= 30) {
                    // Save the new image resource identifier to SharedPreferences
                    SharedPreferences preferences2 = getApplicationContext().getSharedPreferences("prefs2", 0);
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.putInt("resource2", R.drawable.plant_2);
                    editor2.apply();

                    // Start ActivityB
                    Intent intent = new Intent(Shop.this, UserGarden.class);
                    startActivity(intent);

                    //update droplets
                    pop.updateDroplets(30);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry you don't have enough droplets to buy this item", Toast.LENGTH_LONG).show();
                }
            }
        });

        ImageButton plant3 = findViewById(R.id.plant3);
        plant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the new image resource identifier to SharedPreferences
                SharedPreferences preferences3 = getApplicationContext().getSharedPreferences("prefs3", 0);
                SharedPreferences.Editor editor3 = preferences3.edit();
                editor3.putInt("resource3", R.drawable.plant_3);
                editor3.apply();

                // Start ActivityB
                Intent intent = new Intent(Shop.this, UserGarden.class);
                startActivity(intent);
            }
        });

        ImageButton plant4 = findViewById(R.id.plant4);
        plant4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the new image resource identifier to SharedPreferences
                SharedPreferences preferences4 = getApplicationContext().getSharedPreferences("prefs4", 0);
                SharedPreferences.Editor editor4 = preferences4.edit();
                editor4.putInt("resource4", R.drawable.plant_4);
                editor4.apply();

                // Start ActivityB
                Intent intent = new Intent(Shop.this, UserGarden.class);
                startActivity(intent);
            }
        });

        ImageButton plant5 = findViewById(R.id.plant5);
        plant5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the new image resource identifier to SharedPreferences
                SharedPreferences preferences5 = getApplicationContext().getSharedPreferences("prefs5", 0);
                SharedPreferences.Editor editor5 = preferences5.edit();
                editor5.putInt("resource5", R.drawable.plant_5);
                editor5.apply();

                // Start ActivityB
                Intent intent = new Intent(Shop.this, UserGarden.class);
                startActivity(intent);
            }
        });

    }
}