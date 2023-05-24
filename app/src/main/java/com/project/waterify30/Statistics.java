package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    private int progress = 0;
    private int update = 0;
    private int daily_goal = 1500;
    ProgressBar progressBar;
    TextView textView;
    private ImageButton buttonHome;
    private int fiftyML = 0;
    private int hundredML = 0;
    private int hundredFiftyML = 0;
    private int twoHundredML = 0;
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

        fiftyML = getIntent().getExtras().getInt("fifty_ml");
        hundredML = getIntent().getExtras().getInt("hundred_ml");
        hundredFiftyML = getIntent().getExtras().getInt("hundred_fifty_ml");
        twoHundredML = getIntent().getExtras().getInt("two_hundred_ml");

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view_progress);

        update = fiftyML+hundredML+hundredFiftyML+twoHundredML;
        progress = ((int) progress + (update*100/daily_goal));
        progressBar.setProgress(progress);
        textView.setText(String.valueOf(progress));

        update = 0;
        fiftyML = 0;
        hundredML = 0;
        hundredFiftyML = 0;
        twoHundredML = 0;

    }
}