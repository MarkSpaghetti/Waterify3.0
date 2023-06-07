package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private final Logic logic = new Logic();
    TextInputEditText editTEmail, editTPassword;
    Button buttonSignup;
    private FirebaseAuth mAuth;
    TextView goLogIn;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            logic.openActivity(getApplicationContext(), Homepage.class);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        editTEmail = findViewById(R.id.email);
        editTPassword = findViewById(R.id.password);
        buttonSignup = findViewById(R.id.button_signup);
        goLogIn = findViewById(R.id.LoginNow);

        goLogIn.setOnClickListener(v -> {
            logic.openActivity(SignUp.this, LogIn.class);
            finish();
        });

        buttonSignup.setOnClickListener(v -> {
            String email, password;
            email = String.valueOf(editTEmail.getText());
            password = String.valueOf(editTPassword.getText());

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(SignUp.this, "Enter email", Toast.LENGTH_LONG).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(SignUp.this, "Enter password", Toast.LENGTH_LONG).show();
                return;
            }
            if (password.length() < 6) {
                Toast.makeText(SignUp.this, "Password should be at least 6 characters long", Toast.LENGTH_LONG).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "The authentication was successful",
                                    Toast.LENGTH_SHORT).show();
                            mAuth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(taskSignIn -> {
                                        if (taskSignIn.isSuccessful()) {
                                            logic.openActivity(getApplicationContext(), Welcoming.class);
                                            finish();
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(SignUp.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}