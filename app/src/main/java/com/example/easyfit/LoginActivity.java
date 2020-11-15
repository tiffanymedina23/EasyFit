package com.example.easyfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Password;
    private Button SignUp;
    private Button AlreadyLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        //signs up new user
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //uploads data to the database on button click
                    String email = Email.getText().toString().trim();
                    String pass = Password.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //send email verification
                               firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                   @Override
                                   public void onComplete(@NonNull Task<Void> task) {
                                       if(task.isSuccessful()){
                                           Toast.makeText(LoginActivity.this, "A verification has been sent to your email", Toast.LENGTH_SHORT).show();
                                           startActivity(new Intent(LoginActivity.this, SigninActivity.class));
                                       }
                                       else {

                                           Toast.makeText(LoginActivity.this, "Could Not Register", Toast.LENGTH_SHORT).show();
                                             }
                                   }
                               });

                            }

                        }
                    });
                }

            }
        });

        //goes to Main Activity
        AlreadyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SigninActivity.class));
            }
        });

    }

    private void setupUIViews() {
        Name = (EditText) findViewById(R.id.ETName);
        Email = (EditText) findViewById(R.id.ETEmail);
        Password = (EditText) findViewById(R.id.ETPassword);
        SignUp = (Button) findViewById(R.id.btnRegister);
        AlreadyLogin = (Button) findViewById(R.id.alreadyLogin);
    }

    private Boolean validate() {
        //makes sure username and password are filled out
        Boolean result = false;
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT);
        } else {
            result = true;
        }
        return result;
    }

}