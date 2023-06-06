package com.project.waterify30;

import static androidx.core.content.ContextCompat.getSystemService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Homepage extends AppCompatActivity {
    private ImageButton buttonProfile, buttonStatistics, buttonSocials, buttonStore, buttonGarden, buttonDrops;

    private ImageView profilePicture;
    String imagePath;
    private Bitmap originalBitmap;

    private Logic logic = new Logic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profilePicture = findViewById(R.id.button_profile);
        buttonProfile = (ImageButton) findViewById(R.id.button_profile);
        loadImageIfThere();

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, Profile.class);
            }
        });

        buttonStore = (ImageButton) findViewById(R.id.shop_button);
        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Homepage.this, Shop.class);
            }
        });

        buttonGarden = (ImageButton) findViewById(R.id.to_garden_button);
        buttonGarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, UserGarden.class);
            }

        });

        buttonStatistics = findViewById(R.id.statistics_button);
        buttonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Homepage.this, Statistics.class);

            }
        });

        buttonDrops = (ImageButton) findViewById(R.id.button_drops);
        buttonDrops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, Cups.class);
            }
        });

    }

    public void buttonPopUpWindow(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = set();
        final PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 900, 900, false);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //close pop-up
        viewPopupwindow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                logic.openActivity(Homepage.this, Homepage.class);
            }

        });

    }

    public View set() {
        PopUpWindow_coins pop = new PopUpWindow_coins();
        setContentView(R.layout.activity_homepage);
        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.pop_up_window_coins);

        // inflate (create) another copy of our custom layout
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.activity_pop_up_window_coins, mainLayout, false);

        // make changes to our custom layout and its subviews
        TextView txtLevel = (TextView) myLayout.findViewById(R.id.textView_level);
        txtLevel.setText("level " + Integer.toString(pop.getLevel()));
        TextView txt_droplets = myLayout.findViewById(R.id.textView_droplets);
        txt_droplets.setText(Integer.toString(pop.getDroplets()) + " droplets");

        return myLayout;
    }

    public void quizz(View view) {
        int[] q = {R.layout.quizz, R.layout.quizz_1, R.layout.quizz_2, R.layout.quizz_3, R.layout.quizz_4};
        int min = 0;
        int max = 3;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);


        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = layoutInflater.inflate(q[randomNum], null);
        final PopupWindow popupWindow = new PopupWindow(viewPopupwindow, 900, 900, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //Answers
        PopUpWindow_coins pop = new PopUpWindow_coins();
        Button yes = (Button) viewPopupwindow.findViewById(R.id.yes);
        Button no1 = (Button) viewPopupwindow.findViewById(R.id.no1);
        Button no2 = (Button) viewPopupwindow.findViewById(R.id.no2);
        Button no3 = (Button) viewPopupwindow.findViewById(R.id.no3);

        yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pop.addDroplets(10);
                Toast.makeText(getApplicationContext(), "Hurray!, you are correct. You have earned 10 droplets", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }

        });

        no1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, your answer was wrong", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }

        });

        no2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, your answer was wrong", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }

        });

        no3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, your answer was wrong", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            }

        });

    }

    public void loadImageIfThere() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        imagePath = sharedPreferences.getString("imagePath", null);
        if (imagePath != null) {
            File file = new File(imagePath);
            if (file.exists()) {
                originalBitmap = BitmapFactory.decodeFile(imagePath); // Load the original bitmap
                Bitmap circularBitmap = logic.getRoundedBitmap(originalBitmap);
                buttonProfile.setImageBitmap(circularBitmap);
            }
        }
    }


}