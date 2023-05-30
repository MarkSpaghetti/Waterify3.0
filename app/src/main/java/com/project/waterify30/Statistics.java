package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    int progress=0;
    private int update=0;
    private int daily_goal = 1500;
    ProgressBar progressBar;
    TextView textView;
    private ImageButton buttonHome;
    private int fiftyML=0;
    private int hundredML=0;
    private int hundredFiftyML=0;
    private int twoHundredML=0;
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPrefs", 0);
        int new_progress = sharedPreferences.getInt("progress", 0);

        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Statistics.this, Homepage.class);
            }
        });

        fiftyML = getIntent().getExtras().getInt("fifty_ml");
        hundredML = getIntent().getExtras().getInt("hundred_ml");
        hundredFiftyML = getIntent().getExtras().getInt("hundred_fifty_ml");
        twoHundredML = getIntent().getExtras().getInt("two_hundred_ml");

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view_progress);

        update = fiftyML+hundredML+hundredFiftyML+twoHundredML;
        progress = ((int) new_progress + (update*100/daily_goal));
        progressBar.setProgress(progress);
        textView.setText(String.valueOf(progress));

        SharedPreferences sharedPreferences2 = getApplicationContext().getSharedPreferences("MyPrefs", 0);
        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putInt("progress", progress);
        editor.apply();
    }
}