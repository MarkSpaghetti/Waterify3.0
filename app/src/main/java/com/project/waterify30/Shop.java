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

    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ImageButton buttonHome, buttonStats;
        buttonHome = findViewById(R.id.home_button);
        buttonHome.setOnClickListener(v -> logic.openActivity(Shop.this, Homepage.class));


        buttonStats = findViewById(R.id.statistics_button);
        buttonStats.setOnClickListener(v -> logic.openActivity(getApplicationContext(), Statistics.class));

        // setting up the buttons to buy the plants
        ImageButton[] plantButtons = {
                findViewById(R.id.plant1),
                findViewById(R.id.plant2),
                findViewById(R.id.plant3),
                findViewById(R.id.plant4),
                findViewById(R.id.plant5),
                findViewById(R.id.plant6),
                findViewById(R.id.plant7),
                findViewById(R.id.plant8),
                findViewById(R.id.plant9),
                findViewById(R.id.plant10),
                findViewById(R.id.plant11),
                findViewById(R.id.plant12),
                findViewById(R.id.plant13),
                findViewById(R.id.plant14),
                findViewById(R.id.plant15),
                findViewById(R.id.plant16),
                findViewById(R.id.plant17),
                findViewById(R.id.plant18),
                findViewById(R.id.plant19),
                findViewById(R.id.plant20),
                findViewById(R.id.plant21),
                findViewById(R.id.plant22),
                findViewById(R.id.plant23),
                findViewById(R.id.plant24),
                findViewById(R.id.plant25),
                findViewById(R.id.plant26),
                findViewById(R.id.plant27),
                findViewById(R.id.plant28),
                findViewById(R.id.plant29),
                findViewById(R.id.plant30)
        };

        for (int i = 0; i < plantButtons.length; i++) {
            final int plantIndex = i + 1;
            plantButtons[i].setOnClickListener(v -> PopUp(v, plantIndex));

        }


        for (int i = 0; i < plantButtons.length; i++) {
            final int plantIndex = i + 1;
            plantButtons[i].setOnClickListener(v -> PopUp(v, plantIndex));
        }
    }

    public void PopUp(View view, int i) {
        View viewPopUpWindow = set(i);
        final PopupWindow popupWindow = new PopupWindow(viewPopUpWindow, 900, 900, false);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // choosing YES or NO
        Button yes = viewPopUpWindow.findViewById(R.id.yes);
        Button no = viewPopUpWindow.findViewById(R.id.no);

        no.setOnClickListener(v -> {
            popupWindow.dismiss();
            logic.openActivity(Shop.this, Shop.class);
        });

        yes.setOnClickListener(v -> {
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

                // update droplets
                pop.updateDroplets(pops.getPrice(i));
            } else {
                Toast.makeText(getApplicationContext(), "Sorry you don't have enough droplets to buy this item", Toast.LENGTH_LONG).show();
            }
        });
    }

    public View set(int i) {
        PopUpWindow_Price pops = new PopUpWindow_Price();
        setContentView(R.layout.activity_shop);
        ConstraintLayout mainLayout = findViewById(R.id.pop_up_window_price);

        // inflate (create) another copy of our custom layout
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.activity_pop_up_window_price, mainLayout, false);

        // make changes to our custom layout and its subviews
        TextView text = myLayout.findViewById(R.id.text);
        text.setText(getResources().getString(R.string.plant_cost, pops.getPrice(i)));

        return myLayout;
    }
}
