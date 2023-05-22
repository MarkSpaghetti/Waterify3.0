package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class Requests extends AppCompatActivity {
    private ImageButton buttonExit; // list of buttons

    private Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_requests);

        buttonExit = (ImageButton) findViewById(R.id.statistics_button);
        buttonExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Requests.this, FriendList.class);
            }

        });

    }
}
