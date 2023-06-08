package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PopUpWindow_coins extends AppCompatActivity {
    public static int drop = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window_coins);
    }



    public int getDroplets() {
        return drop;
    }


    public void updateDroplets(int i) {
        this.drop -=i;
    }

    public void addDroplets(int i) {
        this.drop +=i;
    }

}