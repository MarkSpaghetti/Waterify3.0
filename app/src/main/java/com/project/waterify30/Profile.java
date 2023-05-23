package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Profile extends AppCompatActivity {

    ImageView profilePicture;
    private ImageButton buttonClose;
    FirebaseAuth auth;
    Button buttonSignout;
    TextView email;
    TextView username;
    FirebaseUser user;
    private Logic logic = new Logic();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth = FirebaseAuth.getInstance();
        buttonSignout = findViewById(R.id.button_logout);
        email = findViewById(R.id.email_shown);
        username = findViewById(R.id.username_shown);
        user = auth.getCurrentUser();
        if (user == null){
            logic.openActivity(getApplicationContext(),LogIn.class);
            finish();
        }
        else {
            email.setText(user.getEmail());
            username.setText(getUsername());
        }




        buttonSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                logic.openActivity(getApplicationContext(),LogIn.class);

            }
        });

        buttonClose = (ImageButton)findViewById(R.id.button6);
        buttonClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(Profile.this, Homepage.class);
            }
        });
    }
    private String getUsername(){
        String email = user.getEmail();
        String username = "";
        for (char a : email.toCharArray()) {
            if (a!='@'){
                username += a;
            }
            else return username;
        }
        return username;
    }
}