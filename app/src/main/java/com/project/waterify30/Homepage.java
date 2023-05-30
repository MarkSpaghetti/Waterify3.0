package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class Homepage extends AppCompatActivity implements ProfilePictureUpdateListener {
    private ImageButton buttonProfile, buttonStatistics, buttonSocials, buttonStore, buttonQuiz, buttonGarden, buttonDrops, buttonStar, closePopUp;

    private ConstraintLayout parent;
    private ImageView profilePicture;

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;

    int droplets;
    int experience;
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profilePicture = findViewById(R.id.button_profile);
        buttonProfile = (ImageButton)findViewById(R.id.button_profile);
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

        buttonStar = (ImageButton) findViewById(R.id.button_coin);
        buttonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup_coins_layout, null);

                popupWindow = new PopupWindow(container, 400, 400, true);
                popupWindow.showAtLocation(parent, Gravity.NO_GRAVITY, 500, 500);

                closePopUp = (ImageButton) findViewById(R.id.close_popup);
                closePopUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();

                    }
                });
            }
        });

    }

    @Override
    public void onProfilePictureUpdated(Bitmap profilePicture) {
        this.profilePicture.setImageBitmap(profilePicture);
    }





}
