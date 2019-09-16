package com.gil.gilzmovieapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.parseColor("#06026B"))
                .withBackgroundResource(R.drawable.purplebackground)
                .withFooterText("Welcome !!!");

        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextSize(30);

        View view = config.create();

        setContentView(view);

    }
}
