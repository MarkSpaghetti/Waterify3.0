package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Statistics_Diagrams extends AppCompatActivity {
    BarChart barChart; // variable for our bar chart
    BarData barData; // variable for our bar data.
    BarDataSet barDataSet; // variable for our bar data set.
    ArrayList barEntriesArrayList;  // array list for storing entries.

    ArrayList<String> labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }
}