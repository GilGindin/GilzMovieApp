package com.gil.gilzmovieapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                .withLogo(R.mipmap.ic_launcher)
                .withHeaderText("Welcome !!!");

        config.getHeaderTextView().setTextColor(Color.WHITE);

        View view = config.create();

        setContentView(view);

    }
}