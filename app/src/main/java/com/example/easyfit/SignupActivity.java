package com.example.easyfit;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private Button signupButton;
    private TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.ETName);
        email = (EditText) findViewById(R.id.ETEmail);
        password = (EditText) findViewById(R.id.ETPassword);
        signupButton = (Button) findViewById(R.id.btnRegister);
        loginTextView = (TextView) findViewById(R.id.alreadyLogin);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri mNewUri;

                ContentValues mNewValues = new ContentValues();
                mNewValues.put(MyContentProvider.COLUMN_USERNAME, username.getText().toString());
                mNewValues.put(MyContentProvider.COLUMN_EMAIL, email.getText().toString());
                mNewValues.put(MyContentProvider.COLUMN_PASSWORD, password.getText().toString());

                mNewUri = getContentResolver().insert(
                        MyContentProvider.CONTENT_URI, mNewValues);

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("username", username.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
            }
        });
    }
}