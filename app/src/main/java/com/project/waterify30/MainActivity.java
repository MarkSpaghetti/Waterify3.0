package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    boolean logIn = true;
    private ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenStart();


    }
    void screenStart(){

        Intent intent;
        if (this.logIn){
            intent = new Intent(MainActivity.this, Homepage.class);
        }
        else {
            intent = new Intent(MainActivity.this, Profile.class);
        }
        startActivity(intent);

    }
}