package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;

public class UserGarden extends AppCompatActivity {

    private ImageButton buttonHome;
    private final Logic logic = new Logic();
    private ImageButton[] plants = new ImageButton[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_garden);

        buttonHome = findViewById(R.id.home_button);
        buttonHome.setOnClickListener(v -> logic.openActivity(UserGarden.this, Homepage.class));

        plants[0] = findViewById(R.id.plant1);
        plants[1] = findViewById(R.id.plant2);
        plants[2] = findViewById(R.id.plant3);
        plants[3] = findViewById(R.id.plant4);
        plants[4] = findViewById(R.id.plant5);
        plants[5] = findViewById(R.id.plant6);
        plants[6] = findViewById(R.id.plant7);
        plants[7] = findViewById(R.id.plant8);
        plants[8] = findViewById(R.id.plant9);
        plants[9] = findViewById(R.id.plant10);
        plants[10] = findViewById(R.id.plant11);
        plants[11] = findViewById(R.id.plant12);
        plants[12] = findViewById(R.id.plant13);
        plants[13] = findViewById(R.id.plant14);
        plants[14] = findViewById(R.id.plant15);
        plants[15] = findViewById(R.id.plant16);
        plants[16] = findViewById(R.id.plant17);
        plants[17] = findViewById(R.id.plant18);
        plants[18] = findViewById(R.id.plant19);
        plants[19] = findViewById(R.id.plant20);
        plants[20] = findViewById(R.id.plant21);
        plants[21] = findViewById(R.id.plant22);
        plants[22] = findViewById(R.id.plant23);
        plants[23] = findViewById(R.id.plant24);
        plants[24] = findViewById(R.id.plant25);
        plants[25] = findViewById(R.id.plant26);
        plants[26] = findViewById(R.id.plant27);
        plants[27] = findViewById(R.id.plant28);
        plants[28] = findViewById(R.id.plant29);
        plants[29] = findViewById(R.id.plant30);

        for (int i = 0; i < plants.length; i++) {
            SharedPreferences preferences = getSharedPreferences("prefs" + (i + 1), 0);
            int imageResource = preferences.getInt("resource" + (i + 1), 0);
            if (imageResource != 0) {
                plants[i].setImageResource(imageResource);
            }

            final int index = i; // Create final variable to access inside click listener
            plants[i].setOnClickListener(v -> {
                int resourceId = getResources().getIdentifier("plant_" + (index + 1), "drawable", getPackageName());
                MainActivity.homepagePlant = resourceId;
                SharedPreferences preferencesPlant = getSharedPreferences("prefs_homepage", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencesPlant.edit();
                editor.putInt("homepage_plant", resourceId);
                editor.apply();
                logic.openActivity(getApplicationContext(), Homepage.class);
            });


        }
    }
}
