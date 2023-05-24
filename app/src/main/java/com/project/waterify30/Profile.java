package com.project.waterify30;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    private Logic logic = new Logic();
    private FirebaseAuth auth;
    private FirebaseUser user;
    private ImageButton buttonClose, buttonSettings, editProfilePic;
    private Button buttonSignout;
    private TextView email,username;
    private ImageView profilePicture;
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
        profilePicture = findViewById(R.id.profile_picture);
        editProfilePic = findViewById(R.id.edit_profile_pic);
        user = auth.getCurrentUser();

        displayUserData();

        editProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions,PERMISSION_CODE);
                    }
                    else{
                        pickImageFromGallery();
                    }
                }
                else {
                }
            }
        });

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

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            profilePicture.setImageURI(data.getData());
            profilePicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
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