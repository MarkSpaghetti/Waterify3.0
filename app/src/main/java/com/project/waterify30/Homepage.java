package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Homepage extends AppCompatActivity  {
    private ImageButton buttonProfile, buttonStatistics, buttonSocials, buttonStore, buttonQuiz, buttonGarden, buttonDrops;

    private ImageView profilePicture;
    int droplets;
    int experience;
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profilePicture = findViewById(R.id.button_profile);
        buttonProfile = (ImageButton)findViewById(R.id.button_profile);
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

    /*
    @Override
    public void onProfilePictureUpdated(Bitmap profilePicture) {
        this.profilePicture.setImageBitmap(profilePicture);
    }

     */
}