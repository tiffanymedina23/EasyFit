package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {
    EditText ageET, feetET, inchesET, weightET;
    RadioButton maleRB, femaleRB, burnFatRB, maintainWeightRB, gainStrengthRB;
    Button saveChangesButton, signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ageET = (EditText) findViewById(R.id.ageEditText);
        feetET = (EditText) findViewById(R.id.feetEditText);
        inchesET = (EditText) findViewById(R.id.inchesEditText);
        weightET = (EditText) findViewById(R.id.weightEditText);
        maleRB = (RadioButton) findViewById(R.id.maleRadioButton);
        femaleRB = (RadioButton) findViewById(R.id.femaleRadioButton);
        burnFatRB = (RadioButton) findViewById(R.id.burnFatRadioButton);
        maintainWeightRB = (RadioButton) findViewById(R.id.maintainWeightRadioButton);
        gainStrengthRB = (RadioButton) findViewById(R.id.gainStrengthRadioButton);


        Toolbar toolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        setActionBar(toolbar);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

                saveChangesButton = (Button)findViewById(R.id.saveChangesButton);
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                finish();
            }
        });

        signOutButton = (Button)findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SigninActivity.class));
                finish();
            }
        });
    }
}