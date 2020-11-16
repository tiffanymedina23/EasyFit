package com.example.easyfit;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;

import android.view.MenuItem;

import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1600;

        //Variables
        Animation topAnimation, bottomAnimation, slideLeft;
        Button welcome;
        ProgressBar loading;
        ImageView log_in;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // FULLSCREEN MODE
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,SigninActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        /*
        //Animations
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
      //  slideLeft =  AnimationUtils.loadAnimation(this,R.anim.slide_left);


        welcome = findViewById(R.id.welcome_bttn);
        log_in = findViewById(R.id.easy_fit);
        loading = findViewById(R.id.progress_circular);


        log_in.setAnimation(topAnimation);
        welcome.setAnimation(bottomAnimation);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                Intent intent = new Intent(v.getContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

         */

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }
    */


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.dietMenuItem:
                startActivity(new Intent(getApplicationContext(), DisplayDietActivity.class));
                break;
            case R.id.exerciseMenuItem:
                startActivity(new Intent(getApplicationContext(), DisplayExerciseActivity.class));
                break;
            case R.id.settingsMenuItem:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
        }

        return true;
    }
}