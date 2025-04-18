package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set a delay for the splash screen
        new Handler().postDelayed(() -> {
            // Start the main game activity
            Intent intent = new Intent(splashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close the splash activity
        }, 3000); // Delay in milliseconds (3000ms = 3 seconds)
    }
}
