package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Statistics extends AppCompatActivity {

    private int update=0;
    ProgressBar progressBar;
    TextView textView, daily_goal_tw;
    private ImageButton buttonHome;
    private ImageButton buttonDiagrams;
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Statistics.this, Homepage.class);
            }
        });

        buttonDiagrams = (ImageButton) findViewById(R.id.statistics_diagram_button);
        buttonDiagrams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Statistics.this, Statistics_Diagrams.class);
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view_progress);

        update = MainActivity.cup;
        if (MainActivity.daily_goal == 0)
            MainActivity.daily_progress = 0;
        else
            MainActivity.daily_progress += (int) (update*100/MainActivity.daily_goal);
        progressBar.setProgress(MainActivity.daily_progress);
        textView.setText(String.valueOf(MainActivity.daily_progress) + " %");
        MainActivity.cup = 0;

        if (MainActivity.daily_progress >= MainActivity.daily_goal && MainActivity.daily_goal > 0) {
            Toast.makeText(getApplicationContext(), "Congratulations! You accomplished your daily goal!", Toast.LENGTH_LONG).show();
            MainActivity.droplets += 5;
        }

        daily_goal_tw = (TextView) findViewById(R.id.text_view_daily_goal);
        String text = String.valueOf(MainActivity.daily_goal);
        daily_goal_tw.setText("Your daily goal is \n " + text + " ml");
    }
}