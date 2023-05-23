package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UserGarden extends AppCompatActivity {

    private ImageButton buttonHome;
    private ImageView plant1;
    private Logic logic = new Logic();
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

        plant1 = findViewById(R.id.plant1);
        Intent intent = getIntent();
        int inputImage = intent.getIntExtra(Shop.KEY1, 1);
        plant1.setImageResource(inputImage);
    }
}