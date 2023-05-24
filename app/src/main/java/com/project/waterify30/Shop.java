package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Shop extends AppCompatActivity {

    private ImageButton buttonHome;
    private Logic logic = new Logic();

    public static final String KEY1 = "photo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Shop.this, Homepage.class);
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

    }
}