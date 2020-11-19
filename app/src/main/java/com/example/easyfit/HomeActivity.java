package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView greetingTextView;
    Button dietButton, exerciseButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        greetingTextView = (TextView) findViewById(R.id.welcome);
        dietButton = (Button) findViewById(R.id.dietButton);
        exerciseButton = (Button) findViewById(R.id.exerciseButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");

        greetingTextView.setText("Welcome, " + username + "!");


        dietButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DisplayDietActivity.class));
            }
        });

        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DisplayExerciseActivity.class));
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
            }
        });



    }
}