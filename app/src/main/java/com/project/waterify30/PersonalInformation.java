package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PersonalInformation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] healthItems = { "No", "Yes"};

    String[] sexItems = {"Sex","Male","Female"};
    String[] sportItems = {"Select sport frequency", "Never", "Low", "Medium", "High"};
    TextInputEditText age,weight;
    AutoCompleteTextView healthConEnter;
    ArrayAdapter<String> adapterHealthItems;



    Button buttonDone;
    Logic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        logic = new Logic();

        buttonDone = findViewById(R.id.button_done);





        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Saved the information selected

                logic.openActivity(PersonalInformation.this, Profile.class);
            }
        });


        // health problems spinner definition
        Spinner spinnerHealth = findViewById(R.id.health_spinner);
        spinnerHealth.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapterHealth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, healthItems);
        adapterHealth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerHealth.setAdapter(adapterHealth);

        // sport frequency spinner definition
        Spinner spinnerSports = findViewById(R.id.sport_spinner);
        spinnerSports.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapterSports = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sportItems);
        adapterSports.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSports.setAdapter(adapterSports);

        Spinner spinnerSex = findViewById(R.id.sex_spinner);
        spinnerSex.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapterSex = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,sexItems);
        adapterSex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(adapterSex);
    }

    private int dailyIntakeCalculator(){
        //TODO implement the formula, not sure how to check the input of the users
        return 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
   //     Toast.makeText(getApplicationContext(), healthItems[position], Toast.LENGTH_LONG).show();
     //   Toast.makeText(getApplicationContext(), sportItems[position], Toast.LENGTH_LONG).show();
        // TODO here I need to save the chosen item into some global variable to use in statistics
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
