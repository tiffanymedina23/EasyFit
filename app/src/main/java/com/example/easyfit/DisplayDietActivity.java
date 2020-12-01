package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class DisplayDietActivity extends AppCompatActivity {
    Integer gender, pounds, feet, inches, age, height, calories, fatGrams, carbsGrams, proteinGrams, fatCalories, carbsCalories, proteinCalories;
    Double bmr;
    TextView caloriesTV, fatTV, carbsTV, proteinTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_diet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.diet_toolbar);
        setActionBar(toolbar);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayDietActivity.this, HomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });

        //get user's data (user sample data for now)

        //sample data for 6' 200lb male
        gender = 0;
        pounds = 200;
        feet = 6;
        inches = 0;
        age = 20;

        //convert height
        height = (12 * feet) + inches;

        //calculate bmr
        if(gender == 0){
            bmr = 655 + (4.35 * pounds) + (4.7 * height) - (4.7 * age);
        } else {
            bmr = 66 + (6.23 * pounds) + (12.7 * height) - (6.8 * age);
        }

        //calculate total calories (Harris Benedict Formula)
        calories = (int)(bmr * 1.55);

        //calculate macronutrient calories
        fatCalories = (int)(calories * 0.2);
        carbsCalories = (int)(calories * 0.4);
        proteinCalories = (int)(calories * 0.4);

        //calculate macronutrient grams
        fatGrams = fatCalories / 9;
        carbsGrams = carbsCalories / 4;
        proteinGrams = proteinCalories / 4;

        //set textviews
        caloriesTV = (TextView)findViewById(R.id.caloriesTV);
        fatTV = (TextView)findViewById(R.id.fatTV);
        carbsTV = (TextView)findViewById(R.id.carbsTV);
        proteinTV = (TextView)findViewById(R.id.proteinTV);

        caloriesTV.setText("TOTAL CALORIES : " + calories + "CAL");
        fatTV.setText(fatGrams + "g FAT ................ (" + fatCalories + " CAL)");
        carbsTV.setText(carbsGrams + "g CARBS .......... (" + carbsCalories + " CAL)");
        proteinTV.setText(proteinGrams + "g PROTEIN ....... (" + proteinCalories + " CAL)");







    }
}