package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class PopUpWindow_Price extends AppCompatActivity {

    private int[] prices = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    private String[] r = {"resource1", "resource2", "resource3", "resource4", "resource5", "resource6", "resource7", "resource8", "resource9", "resource10",
            "resource11", "resource12", "resource13", "resource14", "resource15", "resource16", "resource17", "resource18", "resource19", "resource20",
            "resource21", "resource22", "resource23", "resource24", "resource25", "resource26", "resource27", "resource28", "resource29", "resource30" };
    private int[] d = {R.drawable.plant_1, R.drawable.plant_2, R.drawable.plant_3, R.drawable.plant_4, R.drawable.plant_5, R.drawable.plant_6, R.drawable.plant_7, R.drawable.plant_8, R.drawable.plant_9, R.drawable.plant_10,
            R.drawable.plant_11, R.drawable.plant_12, R.drawable.plant_13, R.drawable.plant_14, R.drawable.plant_15, R.drawable.plant_16, R.drawable.plant_17, R.drawable.plant_18, R.drawable.plant_19, R.drawable.plant_20,
            R.drawable.plant_21, R.drawable.plant_22, R.drawable.plant_23, R.drawable.plant_24, R.drawable.plant_25, R.drawable.plant_26, R.drawable.plant_27, R.drawable.plant_28, R.drawable.plant_29, R.drawable.plant_30 };

    private String[] p = { "prefs1", "prefs2", "prefs3", "prefs4", "prefs5", "prefs6", "prefs7", "prefs8", "prefs9", "prefs10",
            "prefs11", "prefs12", "prefs13", "prefs14", "prefs15", "prefs16", "prefs17", "prefs18", "prefs19", "prefs20",
            "prefs21", "prefs22", "prefs23", "prefs24", "prefs25", "prefs26", "prefs27", "prefs28", "prefs29", "prefs30" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window_price);
    }

    public int getPrice(int i){
        int pos = i-1;
        return prices[pos];
    }

    public String getR(int i){
        int pos = i-1;
        return r[pos];
    }

    public int getD(int i){
        int pos = i-1;
        return d[pos];
    }

    public String getP(int i){
        int pos = i-1;
        return p[pos];
    }
}