package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Button feedbackButton;
    ImageButton closeButton;
    Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        closeButton = findViewById(R.id.button_close_settings);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(getApplicationContext(), Profile.class);
            }
        });

        feedbackButton = findViewById(R.id.Feedback);

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
            }
        });
    }
}
