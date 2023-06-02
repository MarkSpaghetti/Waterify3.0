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

   public static int[] week = {2,6,3,4,5,8,4};
   //public static int day = 0;
   //public static String prevDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

}