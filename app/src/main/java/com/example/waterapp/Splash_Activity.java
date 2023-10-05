package com.example.waterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textView = findViewById(R.id.textSplashScreen);
        textView.animate().translationX(1000).setDuration(1000).setStartDelay(2500);


        Thread thread =new Thread(){
            public void run(){
                try {
                    Thread.sleep(4000);
                }
                catch (Exception e ) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(Splash_Activity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        };

        thread.start();
    }
}