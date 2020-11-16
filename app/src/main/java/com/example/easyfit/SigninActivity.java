package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private Button SignIn;
    private TextView NewAccount;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        //signs up new user
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, HomeActivity.class));

                if (validate()) {
                    //uploads data to the database on button click
                    String email = Email.getText().toString().trim();
                    String pass = Password.getText().toString().trim();
                }

            }
        });

        //goes to Main Activity
        NewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
            }
        });

    }

    private void setupUIViews() {
        Email = (EditText) findViewById(R.id.ETEmail);
        Password = (EditText) findViewById(R.id.ETPassword);
        SignIn = (Button) findViewById(R.id.btnSignIn);
        NewAccount = (TextView) findViewById(R.id.newAccount);
    }

    private Boolean validate() {
        //makes sure username and password are filled out
        Boolean result = false;
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT);
        } else {
            result = true;
        }
        return result;
    }

}

