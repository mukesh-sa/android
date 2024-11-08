package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private int currentSplashIndex = 0;
    private final int[] splashLayouts = {R.layout.activity_splash1, R.layout.activity_splash2, R.layout.activity_splash3};
    private final int splashDisplayDuration = 600; // 200 milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showNextSplash();
    }

    private void showNextSplash() {
        // Set the current layout
        setContentView(splashLayouts[currentSplashIndex]);

        // Increment the splash index
        currentSplashIndex++;

        // Check if there are more splash screens to show
        if (currentSplashIndex < splashLayouts.length) {
            new Handler().postDelayed(this::showNextSplash, splashDisplayDuration);
        } else {
            // If all splash screens are shown, start the main activity
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the splash screen activity
            }, splashDisplayDuration);
        }
    }
}
