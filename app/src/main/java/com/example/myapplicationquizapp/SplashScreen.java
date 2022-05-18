package com.example.myapplicationquizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.airbnb.lottie.LottieAnimationView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}