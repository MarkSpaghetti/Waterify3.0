package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class Homepage extends AppCompatActivity {
    private ImageButton buttonProfile, buttonStatistics, buttonSocials, buttonStore, buttonQuiz, buttonGarden, buttonDrops;

    int droplets;
    int experience;
    private Logic logic = new Logic();

    String imagePath;
    private Bitmap originalBitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        buttonProfile = (ImageButton)findViewById(R.id.button_profile);
        loadImageIfThere();
        buttonProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, Profile.class);
            }
        });

        buttonStore = (ImageButton) findViewById(R.id.shop_button);
        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Homepage.this, Shop.class);
            }
        });

        buttonGarden = (ImageButton) findViewById(R.id.to_garden_button);
        buttonGarden.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, UserGarden.class);
            }

        });

        buttonStatistics = findViewById(R.id.statistics_button);
        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Homepage.this, Statistics.class);

            }
        });

        buttonDrops = (ImageButton)findViewById(R.id.button_drops);
        buttonDrops.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, Cups.class);
            }
        });




    }


    public void loadImageIfThere() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        imagePath = sharedPreferences.getString("imagePath", null);
        if (imagePath != null) {
            File file = new File(imagePath);
            if (file.exists()) {
                originalBitmap = BitmapFactory.decodeFile(imagePath); // Load the original bitmap
                Bitmap circularBitmap = logic.getRoundedBitmap(originalBitmap);
                buttonProfile.setImageBitmap(circularBitmap);
            }
        }

    }

}