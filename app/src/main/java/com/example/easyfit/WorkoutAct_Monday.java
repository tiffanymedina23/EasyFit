package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WorkoutAct_Monday extends AppCompatActivity {
    TextView titlepage, subtitlepage, btnexercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_act__monday);

        btnexercise = (TextView) findViewById(R.id.btnexercise);

       btnexercise.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct_Monday.this, StartWorkoutActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }
}