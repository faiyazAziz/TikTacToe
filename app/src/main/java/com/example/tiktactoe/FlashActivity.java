package com.example.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        Intent iNext = new Intent(FlashActivity.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(iNext);
                finish();
            }
        },4100);
    }
}