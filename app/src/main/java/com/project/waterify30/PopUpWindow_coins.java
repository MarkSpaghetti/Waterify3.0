package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PopUpWindow_coins extends AppCompatActivity {
    private static int level = 0;
    private static int droplets = 40;

    TextView txtLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window_coins);
        txtLevel = findViewById(R.id.textView_level);
    }


    public int getLevel(){
        return level;
    }

    public int getDroplets(){
        return droplets;
    }

    public void updateLevel(){
        this.level++;
    }

    public void updateDroplets(int i){
        this.droplets = this.droplets - i;
    }

}