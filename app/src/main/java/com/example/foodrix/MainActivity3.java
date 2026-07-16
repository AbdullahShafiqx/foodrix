package com.example.foodrix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Initialize views
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.passwordconfirm);

        Button signUpButton = findViewById(R.id.moveback);

        // OnClickListener for the sign-up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Username and password cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!username.contains("@gmail.com")) {
                    Toast.makeText(MainActivity3.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.equals(confirmPassword)) {
                    // Save credentials in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();

                    Toast.makeText(MainActivity3.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

                    // Navigate to the login activity (MainActivity2)
                    Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity3.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Navigate back to the login activity
        Button alreadyHaveAccountButton = findViewById(R.id.alreadyaccount);
        alreadyHaveAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
