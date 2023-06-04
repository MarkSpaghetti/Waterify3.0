package com.project.waterify30;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Profile extends AppCompatActivity {

    private Logic logic = new Logic();
    private FirebaseAuth auth;
    private FirebaseUser user;
    private ImageButton buttonClose, buttonSettings, editProfilePic;
    private Button buttonSignout,buttonPersonalData,buttonChangeMood;
    private TextView email,username;
    private ImageView profilePicture;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    String imagePath;

    private Bitmap originalBitmap;

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
        imagePath = MainActivity.imagePath;
        buttonPersonalData = findViewById(R.id.button_personal_information);
        buttonChangeMood = findViewById(R.id.button_change_mood);

        loadImageIfThere();
        displayUserData();

        editProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        pickImageFromGallery();
                    }
                }
            }
        });

        buttonChangeMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO make pop up
            }
        });

        buttonPersonalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.openActivity(getApplicationContext(),PersonalInformation.class);
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
                //BitmapDrawable drawable = (BitmapDrawable) profilePicture.getDrawable();
                //Bitmap updatedBitmap = drawable.getBitmap();

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

            // Save the original bitmap instead of the circular bitmap
            BitmapDrawable drawable = (BitmapDrawable) profilePicture.getDrawable();
            originalBitmap = drawable.getBitmap();
            Bitmap circularBitmap = logic.getRoundedBitmap(originalBitmap);
            profilePicture.setImageBitmap(circularBitmap);
            saveImageToFile(originalBitmap); // Save the original bitmap
        }
    }

    private void saveImageToFile(Bitmap bitmap) {
        try {
            // Create a file to save the image
            File directory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            String fileName = "profile_image_" + timeStamp + ".jpg";
            File file = new File(directory, fileName);

            // Compress the bitmap and save it to the file
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();

            // Store the file path in SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("imagePath", file.getAbsolutePath());
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }








    private void displayUserData(){
        if (user == null){
            logic.openActivity(getApplicationContext(),LogIn.class);
            finish();
        }
        else {
            email.setText(user.getEmail());
            username.setText(logic.ignoreEmail(user));
        }


    }


    public void loadImageIfThere() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        imagePath = sharedPreferences.getString("imagePath", null);
        if (imagePath != null) {
            File file = new File(imagePath);
            if (file.exists()) {
                originalBitmap = BitmapFactory.decodeFile(imagePath); // Load the original bitmap
                Bitmap circularBitmap = logic.getRoundedBitmap(originalBitmap);
                profilePicture.setImageBitmap(circularBitmap);
            }
        }

    }
}