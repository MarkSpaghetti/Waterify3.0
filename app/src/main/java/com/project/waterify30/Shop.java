package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {

    private ImageButton buttonHome, buttonStats;
    private Logic logic = new Logic();

    public static final String KEY1 = "photo", KEY2 = "photo2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        buttonHome = (ImageButton) findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Shop.this, Homepage.class);
            }
        });


        /*        buttonStats = (ImageButton) findViewById(R.id.statistics_button);
        buttonStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Shop.this, Statistics.class);
            }
        });*/


        // setting up the buttons to buy the plants
        PopUpWindow_coins pop = new PopUpWindow_coins();

        ImageButton plant1 = findViewById(R.id.plant1);
        plant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,1);
            }
        });

        ImageButton plant2 = findViewById(R.id.plant2);
        plant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              PopUp(v,2);
            }
        });

        ImageButton plant3 = findViewById(R.id.plant3);
        plant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              PopUp(v,3);
            }
        });

        ImageButton plant4 = findViewById(R.id.plant4);
        plant4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,4);
            }
        });

        ImageButton plant5 = findViewById(R.id.plant5);
        plant5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,5);
            }
        });

        ImageButton plant6 = findViewById(R.id.plant6);
        plant6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,6);
            }
        });

        ImageButton plant7 = findViewById(R.id.plant7);
        plant7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,7);
            }
        });

        ImageButton plant8 = findViewById(R.id.plant8);
        plant5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,8);
            }
        });

        ImageButton plant9 = findViewById(R.id.plant9);
        plant9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,9);
            }
        });

        ImageButton plant10 = findViewById(R.id.plant10);
        plant10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,10);
            }
        });

        ImageButton plant11 = findViewById(R.id.plant5);
        plant11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,11);
            }
        });

        ImageButton plant12 = findViewById(R.id.plant12);
        plant12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,12);
            }
        });

        ImageButton plant13 = findViewById(R.id.plant13);
        plant13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,13);
            }
        });

        ImageButton plant14 = findViewById(R.id.plant14);
        plant14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,14);
            }
        });

        ImageButton plant15 = findViewById(R.id.plant15);
        plant15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,15);
            }
        });

        ImageButton plant16 = findViewById(R.id.plant16);
        plant16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,16);
            }
        });

        ImageButton plant17 = findViewById(R.id.plant17);
        plant17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,17);
            }
        });

        ImageButton plant18 = findViewById(R.id.plant18);
        plant18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,18);
            }
        });

        ImageButton plant19 = findViewById(R.id.plant19);
        plant19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,19);
            }
        });

        ImageButton plant20 = findViewById(R.id.plant20);
        plant20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,20);
            }
        });

        ImageButton plant21 = findViewById(R.id.plant21);
        plant21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,21);
            }
        });

        ImageButton plant22 = findViewById(R.id.plant22);
        plant22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,22);
            }
        });

        ImageButton plant23 = findViewById(R.id.plant23);
        plant23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,23);
            }
        });

        ImageButton plant24 = findViewById(R.id.plant24);
        plant24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,24);
            }
        });

        ImageButton plant25 = findViewById(R.id.plant25);
        plant25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,25);
            }
        });

        ImageButton plant26 = findViewById(R.id.plant26);
        plant26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,26);
            }
        });

        ImageButton plant27 = findViewById(R.id.plant27);
        plant27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,27);
            }
        });

        ImageButton plant28 = findViewById(R.id.plant28);
        plant28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,28);
            }
        });

        ImageButton plant29 = findViewById(R.id.plant29);
        plant29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,29);
            }
        });

        ImageButton plant30 = findViewById(R.id.plant30);
        plant30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp(v,30);
            }
        });

    }


    public View set (int i){
        PopUpWindow_Price pops = new PopUpWindow_Price();
        setContentView(R.layout.activity_shop);
        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.pop_up_window_price);

        // inflate (create) another copy of our custom layout
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.activity_pop_up_window_price, mainLayout, false);

        // make changes to our custom layout and its subviews
        TextView text = (TextView) myLayout.findViewById(R.id.text);
        text.setText("This plant costs " + Integer.toString(pops.getPrice(i)) + " droplets. Do you want to buy it?");

        return myLayout;
    }


    public void PopUp ( View view , int i) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = set(i);
        final PopupWindow popupWindow = new PopupWindow ( viewPopupwindow, 900, 900, false);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

        //choosing YES or NO
        Button yes = (Button) viewPopupwindow.findViewById(R.id.yes);
        Button no = (Button) viewPopupwindow.findViewById(R.id.no);

        no.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                logic.openActivity(Shop.this, Shop.class);
            }

        });

        yes.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                PopUpWindow_coins pop = new PopUpWindow_coins();
                PopUpWindow_Price pops = new PopUpWindow_Price();

                if (pop.getDroplets() >= pops.getPrice(i)) {
                    // Save the new image resource identifier to SharedPreferences
                    SharedPreferences preferences = getApplicationContext().getSharedPreferences(pops.getP(i), 0);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt(pops.getR(i), pops.getD(i));
                    editor.apply();

                    // Start ActivityB
                    Intent intent = new Intent(Shop.this, UserGarden.class);
                    startActivity(intent);

                    //update droplets
                    pop.updateDroplets(pops.getPrice(i));
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry you don't have enough droplets to buy this item", Toast.LENGTH_LONG).show();
                }
            }

        });

    }




}