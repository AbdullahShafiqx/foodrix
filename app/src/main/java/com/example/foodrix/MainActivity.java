package com.example.foodrix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  //  LottieAnimationView lottie1;
  TextView welcome;
    TextView qoute;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button move1 = findViewById(R.id.button1);
        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });


        Button move2 = findViewById(R.id.button2);
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });


        welcome = findViewById(R.id.welcomeTextView);
        qoute = findViewById(R.id.qoute);

       /* welcome.animate().translationY(1400).setDuration(2700).setStartDelay(0);
        qoute.animate().translationY(1400).setDuration(2700).setStartDelay(0);*/

        welcome.setTranslationY(1400); // Start off-screen
        qoute.setTranslationY(1400);

        welcome.animate().translationY(0).setDuration(2700).setStartDelay(0);
        qoute.animate().translationY(0).setDuration(2700).setStartDelay(200); // Add slight delay for a staggered effect



    }
}
