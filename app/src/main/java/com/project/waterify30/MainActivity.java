package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ImageButton button;
    Logic logic;
    FirebaseUser mAuth;
   public static String imagePath;
   public static int cup;
   public static int daily_progress;
   public static  int daily_goal;
   public static int[] week = {5,2,3,6,4,2,1};
   public static int droplets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

}