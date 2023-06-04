package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] healthItems = {"Select health issue", "healthProblem1", "healthProblem2", "healthProblem3", "healthProblem4"};
    String[] sportItems = {"Select sport frequency", "sport1", "sport2", "sport3", "sport4"};
    AutoCompleteTextView healthConEnter;
    ArrayAdapter<String> adapterHealthItems;
    ImageButton closebutton;

    Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        closebutton = findViewById(R.id.settings_close_button);

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Settings.this, Profile.class);
            }
        });

        // health problems spinner definition
        Spinner spinner1 = (Spinner) findViewById(R.id.health_spinner);
        spinner1.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,healthItems);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        // sport frequency spinner definition
        Spinner spinner2 = (Spinner) findViewById(R.id.sport_spinner);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,healthItems);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),healthItems[position] , Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), sportItems[position], Toast.LENGTH_LONG).show();
        // TODO here I need to save the chosen item into some global variable to use in statistics
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

