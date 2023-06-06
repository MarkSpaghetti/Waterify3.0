package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class FriendGarden extends AppCompatActivity {

    private final Logic logic = new Logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_garden);

        ImageButton buttonHome;
        buttonHome = findViewById(R.id.home_button);

        buttonHome.setOnClickListener(v -> logic.openActivity(FriendGarden.this, Homepage.class));

    }
}