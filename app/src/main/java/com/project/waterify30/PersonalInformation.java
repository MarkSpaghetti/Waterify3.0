package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class PersonalInformation extends AppCompatActivity {

    String[] healthItems = {"No", "Yes"};
    String[] sexItems = {"Male", "Female"};
    String[] sportItems = {"Never", "Low", "Medium", "High"};
    EditText ageET, weightET;
    int sport, result;
    Button buttonDone;
    Logic logic;

    ImageButton buttonClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        logic = new Logic();

        buttonClose = findViewById(R.id.button_close_personal_info);

        buttonClose.setOnClickListener(v -> logic.openActivity(getApplicationContext(), Profile.class));

        // health problems spinner definition
        Spinner spinnerHealth = findViewById(R.id.health_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterHealth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, healthItems);
        adapterHealth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerHealth.setAdapter(adapterHealth);

        // sport frequency spinner definition
        Spinner spinnerSports = findViewById(R.id.sport_spinner);
        ArrayAdapter<String> adapterSports = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sportItems);
        adapterSports.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSports.setAdapter(adapterSports);

        Spinner spinnerSex = findViewById(R.id.sex_spinner);
        ArrayAdapter<String> adapterSex = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sexItems);
        adapterSex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(adapterSex);

        buttonDone = findViewById(R.id.button_done);

        buttonDone.setOnClickListener(v -> {
            MainActivity.index_health = spinnerHealth.getSelectedItemPosition();
            MainActivity.index_sex = spinnerSex.getSelectedItemPosition();
            MainActivity.index_sport = spinnerSports.getSelectedItemPosition();
            ageET = findViewById(R.id.age_enter);
            weightET = findViewById(R.id.weight_enter);

            String ageText = ageET.getText().toString();
            if (ageText.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter age", Toast.LENGTH_SHORT).show();
                return;
            }
            MainActivity.age = Integer.parseInt(ageText);

            String weightText = weightET.getText().toString();
            if (weightText.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter weight", Toast.LENGTH_SHORT).show();
                return;
            }
            MainActivity.weight = Integer.parseInt(weightText);

            MainActivity.daily_goal = dailyIntakeCalculator();
            logic.openActivity(getApplicationContext(), Profile.class);
        });

    }


    private int dailyIntakeCalculator() {
        if (MainActivity.index_sport == 0) { //never
            sport = 0;
        } else if (MainActivity.index_sport == 1) { //low
            sport = 5;
        } else if (MainActivity.index_sport == 2) { //medium
            sport = 10;
        } else { //high
            sport = 15;
        }

        if (MainActivity.index_sex == 0) { //male
            result = MainActivity.weight * (40 + sport);
        } else { //female
            result = MainActivity.weight * (30 + sport);
        }

        if (MainActivity.index_health == 1) {
            double d = result * 1.3;
            result = (int) d;
        }
        return result;
    }

}
