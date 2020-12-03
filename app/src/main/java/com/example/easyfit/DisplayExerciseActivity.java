package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

public class DisplayExerciseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_exercise);

        LinearLayout buttonMonday = (LinearLayout) findViewById(R.id.layout_monday);
        LinearLayout buttonTuesday = (LinearLayout) findViewById(R.id.layout_tuesday);


        Toolbar toolbar = (Toolbar) findViewById(R.id.exercise_toolbar);
        setActionBar(toolbar);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayExerciseActivity.this, HomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });

       buttonMonday.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent a = new Intent(DisplayExerciseActivity.this, WorkoutAct_Monday.class);

                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        buttonTuesday.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent a = new Intent(DisplayExerciseActivity.this, WorkoutTuesdayActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}