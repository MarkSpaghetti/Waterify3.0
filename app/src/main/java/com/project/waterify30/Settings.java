package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {


    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button feedbackButton;
        ImageButton closeButton;
        closeButton = findViewById(R.id.button_close_settings);
        closeButton.setOnClickListener(v -> logic.openActivity(getApplicationContext(), Profile.class));
        feedbackButton = findViewById(R.id.Feedback);
        feedbackButton.setOnClickListener(v -> openReviewWindow());



    }

    private void openReviewWindow() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);

        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Couldn't launch the Play Store", Toast.LENGTH_LONG).show();
        }
    }
}
