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

    int progress;
    private int update;
    private int daily_goal = 1500;
    ProgressBar progressBar;
    TextView textView;
    private ImageButton buttonHome, buttonDiagrams;
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
        MainActivity.daily_progress += (int) (update*100/daily_goal);
        progressBar.setProgress(MainActivity.daily_progress);
        textView.setText(String.valueOf(MainActivity.daily_progress));
    }
}