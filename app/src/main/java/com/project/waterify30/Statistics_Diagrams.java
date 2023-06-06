package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class Statistics_Diagrams extends AppCompatActivity {

    private ImageButton closeButton;

    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_diagrams);

        closeButton = findViewById(R.id.diagram_close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Statistics_Diagrams.this, Statistics.class);

            }
        });

        BarChart barChart = (BarChart) findViewById(R.id.DailyBarChart);

        int[] week = MainActivity.week;

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, week[0]));
        entries.add(new BarEntry(1f, week[1]));
        entries.add(new BarEntry(2f, week[2]));
        entries.add(new BarEntry(3f, week[3]));
        entries.add(new BarEntry(4f, week[4]));
        entries.add(new BarEntry(5f, week[5]));
        entries.add(new BarEntry(6f, week[6]));

        BarDataSet barDataSet = new BarDataSet(entries, "Cells: ");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("Mon");
        labels.add("Tue");
        labels.add("Wed");
        labels.add("Thu");
        labels.add("Fri");
        labels.add("Sat");
        labels.add("Sun");

        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        BarData theData = new BarData(barDataSet);//----Line of error
        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.animateY(2000);
    }

}