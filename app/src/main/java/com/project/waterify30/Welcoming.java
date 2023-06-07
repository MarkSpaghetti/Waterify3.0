package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Welcoming extends AppCompatActivity {
    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcoming);

        Button buttonNext;

        buttonNext = (Button) findViewById(R.id.button_next);
        buttonNext.setOnClickListener(v-> logic.openActivity(Welcoming.this, PersonalInformation.class));
    }
}