package com.example.easyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    EditText usernameET, passwordET;
    String usernameString, passwordString;
    Button loginButton;
    TextView incorrectInputTextView, signupTextView;
    Cursor mCursor;
    String newWord;

    private MyContentProvider.MainDatabaseHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        usernameET = (EditText) findViewById(R.id.ETName);
        passwordET = (EditText) findViewById(R.id.ETPassword);
        loginButton = (Button) findViewById(R.id.btnSignIn);
        signupTextView = (TextView) findViewById(R.id.newAccount);
        incorrectInputTextView = (TextView) findViewById(R.id.incorrectInputTV);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!usernameET.getText().toString().isEmpty() && !passwordET.getText().toString().isEmpty()) {
                    usernameString = usernameET.getText().toString();
                    passwordString = passwordET.getText().toString();

                    String[] mProjection =
                            {
                                    MyContentProvider.COLUMN_PASSWORD
                            };
                    String selectionClause = null;
                    String[] selectionArgs = {""};

                    selectionClause = MyContentProvider.COLUMN_USERNAME + " = ?";
                    selectionArgs[0] = usernameString;

                    mCursor = getContentResolver().query(MyContentProvider.CONTENT_URI, mProjection, selectionClause, selectionArgs, null);

                    if(mCursor != null && mCursor.getCount()>0){
                        mCursor.moveToNext();

                        if(!passwordString.equals(mCursor.getString(0))){
                            incorrectInputTextView.setVisibility(View.VISIBLE);
                        }
                        else {

                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            intent.putExtra("username", usernameET.getText().toString());
                            startActivity(intent);
                        }
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your username and password.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
            }
        });
    }
}

