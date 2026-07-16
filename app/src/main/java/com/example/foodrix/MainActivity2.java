package com.example.foodrix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText; // Corrected types
    private Button loginButton, forgotButton,createnewaccount;
    private ImageView arrow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize fields and buttons
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.MoveID);
        forgotButton = findViewById(R.id.forgot_password_button);
        createnewaccount = findViewById(R.id.Move1);

        // Retrieve credentials from SharedPreferences (or Intent)
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String storedUsername = sharedPreferences.getString("username", "");
        String storedPassword = sharedPreferences.getString("password", "");

        // Login button functionality
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (storedUsername.isEmpty() || storedPassword.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "No credentials stored. Please sign up first.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!enteredUsername.contains("@gmail.com")) {
                    Toast.makeText(MainActivity2.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
                    Toast.makeText(MainActivity2.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity2.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Forgot password button functionality
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        // Create new Account button functionality
        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        //intent for back_arrow
        arrow = findViewById(R.id.back_arrow);
        // OnClickListener for the logout button
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
