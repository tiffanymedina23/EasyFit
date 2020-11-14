package com.example.easyfit;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

        //Variables
        Animation topAnimation, bottomAnimation, slideLeft;
        TextView sp_tv;
        Button welcome;
        ProgressBar loading;
        ImageView log_in;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // FULLSCREEN MODE
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animations
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.slide_left);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        slideLeft =  AnimationUtils.loadAnimation(this,R.anim.slide_left);
    }



}