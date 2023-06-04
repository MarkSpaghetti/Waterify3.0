package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class UserGarden extends AppCompatActivity {

    private ImageButton buttonHome;
    private Logic logic = new Logic();
    private ImageButton plant1, plant2, plant3, plant4, plant5, plant6, plant7, plant8, plant9, plant10,
    plant11, plant12, plant13, plant14, plant15, plant16, plant17, plant18, plant19, plant20,
    plant21, plant22, plant23, plant24, plant25, plant26, plant27, plant28, plant29, plant30 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_garden);


        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(UserGarden.this, Homepage.class);
            }
        });


        /*
        plant1 = (ImageButton) findViewById(R.id.plant1);
        int imageResource1 = getIntent().getIntExtra("imageResource1", 0);
        if (imageResource1 != 0) {
            // Update the image view with the new image
            plant1.setImageResource(imageResource1);
        }

        plant2 = (ImageButton) findViewById(R.id.plant2);
        int imageResource2 = getIntent().getIntExtra("imageResource2", 0);
        if (imageResource2 != 0) {
            // Update the image view with the new image
            plant2.setImageResource(imageResource2);
        }
         */

        plant1 = (ImageButton) findViewById(R.id.plant1);
        SharedPreferences preferences1 = getSharedPreferences("prefs1",0);
        int imageResource1 = preferences1.getInt("resource1", 0);
        if (imageResource1 != 0){
            plant1.setImageResource(imageResource1);
        }

        plant2 = (ImageButton) findViewById(R.id.plant2);
        SharedPreferences preferences2 = getSharedPreferences("prefs2",0);
        int imageResource2 = preferences2.getInt("resource2", 0);
        if (imageResource2 != 0){
            plant2.setImageResource(imageResource2);
        }

        plant3 = (ImageButton) findViewById(R.id.plant3);
        SharedPreferences preferences3 = getSharedPreferences("prefs3",0);
        int imageResource3 = preferences3.getInt("resource3", 0);
        if (imageResource3 != 0){
            plant3.setImageResource(imageResource3);
        }

        plant4 = (ImageButton) findViewById(R.id.plant4);
        SharedPreferences preferences4 = getSharedPreferences("prefs4",0);
        int imageResource4 = preferences4.getInt("resource4", 0);
        if (imageResource4 != 0){
            plant4.setImageResource(imageResource4);
        }

        plant5 = (ImageButton) findViewById(R.id.plant5);
        SharedPreferences preferences5 = getSharedPreferences("prefs5",0);
        int imageResource5 = preferences5.getInt("resource5", 0);
        if (imageResource5 != 0) {
            plant5.setImageResource(imageResource5);
        }

        plant6 = (ImageButton) findViewById(R.id.plant6);
        SharedPreferences preferences6 = getSharedPreferences("prefs6",0);
        int imageResource6 = preferences6.getInt("resource6", 0);
        if (imageResource6 != 0) {
            plant6.setImageResource(imageResource6);
        }

        plant7 = (ImageButton) findViewById(R.id.plant7);
        SharedPreferences preferences7 = getSharedPreferences("prefs7",0);
        int imageResource7 = preferences7.getInt("resource7", 0);
        if (imageResource7 != 0) {
            plant7.setImageResource(imageResource7);
        }

        plant8 = (ImageButton) findViewById(R.id.plant8);
        SharedPreferences preferences8 = getSharedPreferences("prefs8",0);
        int imageResource8 = preferences8.getInt("resource8", 0);
        if (imageResource8 != 0) {
            plant8.setImageResource(imageResource8);
        }

        plant9 = (ImageButton) findViewById(R.id.plant9);
        SharedPreferences preferences9 = getSharedPreferences("prefs9",0);
        int imageResource9 = preferences9.getInt("resource9", 0);
        if (imageResource9 != 0) {
            plant9.setImageResource(imageResource9);
        }

        plant10 = (ImageButton) findViewById(R.id.plant10);
        SharedPreferences preferences10 = getSharedPreferences("prefs10",0);
        int imageResource10 = preferences10.getInt("resource10", 0);
        if (imageResource10 != 0) {
            plant10.setImageResource(imageResource10);
        }

        plant11 = (ImageButton) findViewById(R.id.plant11);
        SharedPreferences preferences11 = getSharedPreferences("prefs11",0);
        int imageResource11 = preferences11.getInt("resource11", 0);
        if (imageResource11 != 0) {
            plant11.setImageResource(imageResource11);
        }

        plant12 = (ImageButton) findViewById(R.id.plant12);
        SharedPreferences preferences12 = getSharedPreferences("prefs12",0);
        int imageResource12 = preferences12.getInt("resource12", 0);
        if (imageResource12 != 0) {
            plant12.setImageResource(imageResource12);
        }

        plant13 = (ImageButton) findViewById(R.id.plant13);
        SharedPreferences preferences13 = getSharedPreferences("prefs13",0);
        int imageResource13 = preferences13.getInt("resource13", 0);
        if (imageResource13 != 0) {
            plant13.setImageResource(imageResource13);
        }

        plant14 = (ImageButton) findViewById(R.id.plant14);
        SharedPreferences preferences14 = getSharedPreferences("prefs14",0);
        int imageResource14 = preferences14.getInt("resource14", 0);
        if (imageResource14 != 0) {
            plant14.setImageResource(imageResource14);
        }

        plant15 = (ImageButton) findViewById(R.id.plant15);
        SharedPreferences preferences15 = getSharedPreferences("prefs15",0);
        int imageResource15 = preferences15.getInt("resource15", 0);
        if (imageResource15 != 0) {
            plant15.setImageResource(imageResource15);
        }

        plant16 = (ImageButton) findViewById(R.id.plant16);
        SharedPreferences preferences16 = getSharedPreferences("prefs16",0);
        int imageResource16 = preferences16.getInt("resource16", 0);
        if (imageResource16 != 0) {
            plant16.setImageResource(imageResource16);
        }

        plant17 = (ImageButton) findViewById(R.id.plant17);
        SharedPreferences preferences17 = getSharedPreferences("prefs17",0);
        int imageResource17 = preferences17.getInt("resource17", 0);
        if (imageResource17 != 0) {
            plant17.setImageResource(imageResource17);
        }

        plant18 = (ImageButton) findViewById(R.id.plant18);
        SharedPreferences preferences18 = getSharedPreferences("prefs18",0);
        int imageResource18 = preferences18.getInt("resource18", 0);
        if (imageResource18 != 0) {
            plant18.setImageResource(imageResource18);
        }

        plant19 = (ImageButton) findViewById(R.id.plant19);
        SharedPreferences preferences19 = getSharedPreferences("prefs19",0);
        int imageResource19 = preferences19.getInt("resource19", 0);
        if (imageResource19 != 0) {
            plant19.setImageResource(imageResource19);
        }

        plant20 = (ImageButton) findViewById(R.id.plant20);
        SharedPreferences preferences20 = getSharedPreferences("prefs20",0);
        int imageResource20 = preferences20.getInt("resource20", 0);
        if (imageResource20 != 0) {
            plant20.setImageResource(imageResource20);
        }

        plant21 = (ImageButton) findViewById(R.id.plant21);
        SharedPreferences preferences21 = getSharedPreferences("prefs21",0);
        int imageResource21 = preferences21.getInt("resource21", 0);
        if (imageResource21 != 0){
            plant21.setImageResource(imageResource21);
        }

        plant22 = (ImageButton) findViewById(R.id.plant22);
        SharedPreferences preferences22 = getSharedPreferences("prefs22",0);
        int imageResource22 = preferences22.getInt("resource22", 0);
        if (imageResource22 != 0){
            plant22.setImageResource(imageResource22);
        }

        plant23 = (ImageButton) findViewById(R.id.plant23);
        SharedPreferences preferences23 = getSharedPreferences("prefs23",0);
        int imageResource23 = preferences23.getInt("resource23", 0);
        if (imageResource23 != 0){
            plant23.setImageResource(imageResource23);
        }

        plant24 = (ImageButton) findViewById(R.id.plant24);
        SharedPreferences preferences24 = getSharedPreferences("prefs24",0);
        int imageResource24 = preferences24.getInt("resource24", 0);
        if (imageResource24 != 0){
            plant24.setImageResource(imageResource24);
        }

        plant25 = (ImageButton) findViewById(R.id.plant25);
        SharedPreferences preferences25 = getSharedPreferences("prefs25",0);
        int imageResource25 = preferences25.getInt("resource25", 0);
        if (imageResource25 != 0) {
            plant25.setImageResource(imageResource25);
        }

        plant26 = (ImageButton) findViewById(R.id.plant26);
        SharedPreferences preferences26 = getSharedPreferences("prefs26",0);
        int imageResource26 = preferences26.getInt("resource26", 0);
        if (imageResource26 != 0) {
            plant26.setImageResource(imageResource26);
        }

        plant27 = (ImageButton) findViewById(R.id.plant27);
        SharedPreferences preferences27 = getSharedPreferences("prefs27",0);
        int imageResource27 = preferences27.getInt("resource27", 0);
        if (imageResource27 != 0) {
            plant27.setImageResource(imageResource27);
        }

        plant28 = (ImageButton) findViewById(R.id.plant28);
        SharedPreferences preferences28 = getSharedPreferences("prefs28",0);
        int imageResource28 = preferences28.getInt("resource28", 0);
        if (imageResource28 != 0) {
            plant28.setImageResource(imageResource28);
        }

        plant29 = (ImageButton) findViewById(R.id.plant29);
        SharedPreferences preferences29 = getSharedPreferences("prefs29",0);
        int imageResource29 = preferences29.getInt("resource29", 0);
        if (imageResource29 != 0) {
            plant29.setImageResource(imageResource29);
        }

        plant30 = (ImageButton) findViewById(R.id.plant30);
        SharedPreferences preferences30 = getSharedPreferences("prefs30",0);
        int imageResource30 = preferences30.getInt("resource30", 0);
        if (imageResource30 != 0) {
            plant30.setImageResource(imageResource30);
        }


    }
}