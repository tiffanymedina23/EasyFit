package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });

        saveChangesButton = (Button)findViewById(R.id.saveChangesButton);
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ageInput, sexInput, feetInput, inchesInput, weightInput, goalInput;

                ContentValues mUpdateValues = new ContentValues();

                mUpdateValues.put(MyContentProvider.COLUMN_AGE, ageET.getText().toString().trim());
                mUpdateValues.put(MyContentProvider.COLUMN_FEET, feetET.getText().toString().trim());
                mUpdateValues.put(MyContentProvider.COLUMN_INCHES, inchesET.getText().toString().trim());
                mUpdateValues.put(MyContentProvider.COLUMN_WEIGHT, weightET.getText().toString().trim());

                if(maleRB.isChecked()){
                    mUpdateValues.put(MyContentProvider.COLUMN_SEX, "0");
                }
                else {
                    mUpdateValues.put(MyContentProvider.COLUMN_SEX, "1");
                }

                if(burnFatRB.isChecked()){
                    mUpdateValues.put(MyContentProvider.COLUMN_GOAL, "0");
                }
                else if(maintainWeightRB.isChecked()){
                    mUpdateValues.put(MyContentProvider.COLUMN_GOAL, "1");
                }
                else {
                    mUpdateValues.put(MyContentProvider.COLUMN_GOAL, "2");
                }

                String mSelectionClause = MyContentProvider.COLUMN_USERNAME + "=" + username;

                int mRowsUpdated = getContentResolver().update(MyContentProvider.CONTENT_URI, mUpdateValues,
                        mSelectionClause, null);

                Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
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