package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UserGarden extends AppCompatActivity {

    private ImageButton buttonHome;
    private Logic logic = new Logic();
    private ImageButton plant1, plant2, plant3, plant4, plant5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_garden);


        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(UserGarden.this, Homepage.class);
            }
        });


        /*
        plant1 = (ImageButton) findViewById(R.id.plant1);
        int imageResource1 = getIntent().getIntExtra("imageResource1", 0);
        if (imageResource1 != 0) {
            // Update the image view with the new image
            plant1.setImageResource(imageResource1);
        }

        plant2 = (ImageButton) findViewById(R.id.plant2);
        int imageResource2 = getIntent().getIntExtra("imageResource2", 0);
        if (imageResource2 != 0) {
            // Update the image view with the new image
            plant2.setImageResource(imageResource2);
        }
         */

        plant1 = (ImageButton) findViewById(R.id.plant1);
        SharedPreferences preferences1 = getSharedPreferences("prefs1",0);
        int imageResource1 = preferences1.getInt("resource1", 0);
        if (imageResource1 != 0){
            plant1.setImageResource(imageResource1);
        }

        plant2 = (ImageButton) findViewById(R.id.plant2);
        SharedPreferences preferences2 = getSharedPreferences("prefs2",0);
        int imageResource2 = preferences2.getInt("resource2", 0);
        if (imageResource2 != 0){
            plant2.setImageResource(imageResource2);
        }

        plant3 = (ImageButton) findViewById(R.id.plant3);
        SharedPreferences preferences3 = getSharedPreferences("prefs3",0);
        int imageResource3 = preferences3.getInt("resource3", 0);
        if (imageResource3 != 0){
            plant3.setImageResource(imageResource3);
        }

        plant4 = (ImageButton) findViewById(R.id.plant4);
        SharedPreferences preferences4 = getSharedPreferences("prefs4",0);
        int imageResource4 = preferences4.getInt("resource4", 0);
        if (imageResource4 != 0){
            plant4.setImageResource(imageResource4);
        }

        plant5 = (ImageButton) findViewById(R.id.plant5);
        SharedPreferences preferences5 = getSharedPreferences("prefs5",0);
        int imageResource5 = preferences5.getInt("resource5", 0);
        if (imageResource5 != 0) {
            plant5.setImageResource(imageResource5);
        }


    }
}