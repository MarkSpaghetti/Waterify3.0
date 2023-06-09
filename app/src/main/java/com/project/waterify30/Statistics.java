package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Statistics extends AppCompatActivity {


    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        ImageButton buttonDiagrams, buttonHome;
        int update;
        ProgressBar progressBar;
        TextView textView, daily_goal_tw;

        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(v -> logic.openActivity(Statistics.this, Homepage.class));

        buttonDiagrams = (ImageButton) findViewById(R.id.statistics_diagram_button);
        buttonDiagrams.setOnClickListener(v -> logic.openActivity(Statistics.this, Statistics_Diagrams.class));

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view_progress);

        update = MainActivity.cup;
        if (MainActivity.daily_goal == 0)
            MainActivity.daily_progress = 0;
        else
            MainActivity.daily_progress += (int) (update * 100 / MainActivity.daily_goal);
        progressBar.setProgress(MainActivity.daily_progress);
        textView.setText(getString(R.string.daily_progress_text, MainActivity.daily_progress));
        MainActivity.cup = 0;

        if (MainActivity.daily_progress >= MainActivity.daily_goal && MainActivity.daily_goal > 0) {
            Toast.makeText(getApplicationContext(), "Congratulations! You accomplished your daily goal!", Toast.LENGTH_LONG).show();
            MainActivity.droplets += 5;
        }

        daily_goal_tw = (TextView) findViewById(R.id.text_view_daily_goal);
        String text = String.valueOf(MainActivity.daily_goal);
        daily_goal_tw.setText(getString(R.string.daily_goal_text, text));
    }
}