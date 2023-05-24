package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    private Logic logic = new Logic();
    private FirebaseAuth auth;
    private FirebaseUser user;
    private ImageButton buttonClose, buttonSettings;
    private Button buttonSignout;
    private TextView email,username;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth = FirebaseAuth.getInstance();
        buttonSignout = findViewById(R.id.button_logout);
        email = findViewById(R.id.email_shown);
        buttonClose = (ImageButton)findViewById(R.id.button6);
        buttonSettings = findViewById(R.id.settingsButton);
        username = findViewById(R.id.username_shown);
        user = auth.getCurrentUser();

        displayUserData();



        buttonSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                logic.openActivity(getApplicationContext(),LogIn.class);
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Profile.this, Homepage.class);
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(Profile.this, Settings.class);

            }
        });
    }

        private String ignoreEmail(){
            String email = user.getEmail();
            String username = "";
            for (char a:email.toCharArray() ) {
                if (a!='@'){
                    username += a;
                }
                else return username;
            }
            return username;
        }

        private void displayUserData(){
            if (user == null){
                logic.openActivity(getApplicationContext(),LogIn.class);
                finish();
            }
            else {
                    email.setText(user.getEmail());
                    username.setText(ignoreEmail());
            }


        }
}