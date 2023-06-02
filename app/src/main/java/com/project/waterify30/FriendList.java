package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FriendList extends AppCompatActivity {

    private ImageButton buttonHome, buttonSocials, buttonStatistics, buttonFriendGarden,buttonRequest; // list of buttons
    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        buttonStatistics = (ImageButton) findViewById(R.id.statistics_button);
        buttonStatistics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendList.this, Statistics.class);
            }

        });

        buttonHome = (ImageButton)findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendList.this, Homepage.class);
            }
        });

        buttonSocials = (ImageButton) findViewById(R.id.socials_button);
        buttonSocials.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendList.this, FriendList.class);
            }
        });

        buttonFriendGarden = (ImageButton) findViewById(R.id.button_profile_friendNr1);
        buttonFriendGarden.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendList.this, FriendGarden.class);
            }

        });

        buttonRequest = (ImageButton) findViewById(R.id.request_button);
        buttonRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(FriendList.this, FriendRequest.class);
            }

        });

    }

}