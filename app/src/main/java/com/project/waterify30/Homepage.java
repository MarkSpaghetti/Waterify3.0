package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Homepage extends AppCompatActivity {
    private ImageButton buttonProfile, buttonStatistics, buttonSocials, buttonStore, buttonQuiz, buttonGarden;

    int droplets;
    int experience;
    private Logic logic = new Logic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


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





    }
}