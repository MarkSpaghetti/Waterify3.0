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
   public static int[] week = {2050,2130,2340,1600,2460,2100,1970};
   public static int droplets = PopUpWindow_coins.drop;
   public static int age = 0;
   public static int weight = 0;
   public static int index_health = 0;
   public static int index_sex = 0;
   public static int index_sport = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

}