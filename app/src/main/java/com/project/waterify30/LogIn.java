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

public class LogIn extends AppCompatActivity {
    private final Logic logic = new Logic();


    FirebaseAuth mAuth;

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
        setContentView(R.layout.activity_log_in);

        Button buttonLogIn;
        TextView goSignUp;
        TextInputEditText editTEmail, editTPassword;
        mAuth = FirebaseAuth.getInstance();
        editTEmail = findViewById(R.id.email);
        editTPassword = findViewById(R.id.password);
        buttonLogIn = findViewById(R.id.button_login);
        goSignUp = findViewById(R.id.RegisterNow);

        goSignUp.setOnClickListener(v -> logic.openActivity(getApplicationContext(), SignUp.class));

        buttonLogIn.setOnClickListener(v -> {
            String email, password;
            email = String.valueOf(editTEmail.getText());
            password = String.valueOf(editTPassword.getText());

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(LogIn.this, "Enter email", Toast.LENGTH_LONG).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(LogIn.this, "Enter password", Toast.LENGTH_LONG).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            logic.openActivity(getApplicationContext(), Homepage.class);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}