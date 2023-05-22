package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    String[] healthItems = {"healthProblem1", "healthProblem2", "healthProblem3"};
    AutoCompleteTextView healthConEnter;
    ArrayAdapter<String> adapterHealthItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        healthConEnter = findViewById(R.id.health_con_enter);
        adapterHealthItems = new ArrayAdapter<String>(this,R.layout.list_item_health_con);
        healthConEnter.setAdapter(adapterHealthItems);

        healthConEnter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}