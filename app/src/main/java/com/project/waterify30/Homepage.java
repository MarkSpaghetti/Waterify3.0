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
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class Homepage extends AppCompatActivity  {
    private ImageButton buttonProfile, buttonStatistics, buttonSocials, buttonStore, buttonQuiz, buttonGarden, buttonDrops;

    private ImageView profilePicture;
    int droplets = 0;
    int level = 0;
    String imagePath;
    private Bitmap originalBitmap;

    private Logic logic = new Logic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profilePicture = findViewById(R.id.button_profile);
        buttonProfile = (ImageButton)findViewById(R.id.button_profile);
        loadImageIfThere();

        buttonProfile.setOnClickListener(new View.OnClickListener(){
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
        buttonGarden.setOnClickListener(new View.OnClickListener(){
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

        buttonDrops = (ImageButton)findViewById(R.id.button_drops);
        buttonDrops.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Homepage.this, Cups.class);
            }
        });

    }

    public void buttonPopUpWindow( View view ) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = set();
        final PopupWindow popupWindow = new PopupWindow ( viewPopupwindow, 900, 900, true);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        logic.openActivity(Homepage.this, Homepage.class);
    }

    public View set(){
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


    /*
    @Override
    public void onProfilePictureUpdated(Bitmap profilePicture) {
        this.profilePicture.setImageBitmap(profilePicture);
    }

     */
}