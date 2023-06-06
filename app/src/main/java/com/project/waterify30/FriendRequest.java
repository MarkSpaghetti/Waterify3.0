package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FriendRequest extends AppCompatActivity {

    private ImageButton buttonExit, buttonProfile; // list of buttons
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_request);

        buttonExit = (ImageButton) findViewById(R.id.button_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendRequest.this, FriendList.class);
            }

        });

        buttonProfile = (ImageButton) findViewById(R.id.button_profile_friendNr1);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendRequest.this, FriendGarden.class);
            }

        });

        buttonProfile = (ImageButton) findViewById(R.id.button_profile_friendNr2);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendRequest.this, FriendGarden.class);
            }

        });

        buttonProfile = (ImageButton) findViewById(R.id.button_profile_friendNr3);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendRequest.this, FriendGarden.class);
            }

        });

        buttonProfile = (ImageButton) findViewById(R.id.button_profile_friendNr4);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendRequest.this, FriendGarden.class);
            }

        });
    }
}