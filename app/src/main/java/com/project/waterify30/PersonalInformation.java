package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PersonalInformation extends AppCompatActivity {

    String[] healthItems = {"No", "Yes"};
    String[] sexItems = {"Male","Female"};
    String[] sportItems = {"Never", "Low", "Medium", "High"};
    EditText ageET,weightET;
    int age, weight, sport, healthIndex, sexIndex, sportIndex, result;
    AutoCompleteTextView healthConEnter;
    ArrayAdapter<String> adapterHealthItems;
    Button buttonDone;
    Logic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        logic = new Logic();

        // health problems spinner definition
        Spinner spinnerHealth = findViewById(R.id.health_spinner);
        //spinnerHealth.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterHealth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, healthItems);
        adapterHealth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerHealth.setAdapter(adapterHealth);

        // sport frequency spinner definition
        Spinner spinnerSports = findViewById(R.id.sport_spinner);
        //spinnerSports.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapterSports = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sportItems);
        adapterSports.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSports.setAdapter(adapterSports);

        Spinner spinnerSex = findViewById(R.id.sex_spinner);
        //spinnerSex.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapterSex = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sexItems);
        adapterSex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(adapterSex);

        buttonDone = findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Saved the information selected
                //String state_health = spinnerHealth.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(), state_health, Toast.LENGTH_LONG).show();
                healthIndex = spinnerHealth.getSelectedItemPosition();
                sexIndex = spinnerSex.getSelectedItemPosition();
                sportIndex = spinnerSports.getSelectedItemPosition();
                ageET = findViewById(R.id.age_enter);
                age = Integer.parseInt(ageET.getText().toString());
                weightET = findViewById(R.id.weight_enter);
                weight = Integer.parseInt(weightET.getText().toString());
                MainActivity.daily_goal = dailyIntakeCalculator();
                logic.openActivity(PersonalInformation.this, Profile.class);
            }
        });


    }


    private int dailyIntakeCalculator(){
        //TODO implement the formula, not sure how to check the input of the users
        if (sportIndex == 0) { //never
            sport = 0;
        } else if (sportIndex == 1) { //low
            sport = 5;
        } else if (sportIndex == 2) { //medium
            sport = 10;
        }
        else { //high
            sport = 15;
        }

        if (sexIndex == 0) { //male
            result = weight * (40 + sport);
        } else { //female
            result = weight * (30 + sport);
        }

        if (healthIndex == 1) {
            double d = result * 1.3;
            result = (int) d;
        }
        return result;
    }

}
