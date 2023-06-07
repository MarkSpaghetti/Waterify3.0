package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class FriendRequest extends AppCompatActivity {

    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_request);

        ImageButton buttonClose;

        buttonClose = findViewById(R.id.button_close_friend_requests);
        buttonClose.setOnClickListener(v -> logic.openActivity(FriendRequest.this, UserList.class));


    }
}
