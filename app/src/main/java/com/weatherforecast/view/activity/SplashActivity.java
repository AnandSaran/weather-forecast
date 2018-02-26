package com.weatherforecast.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.weatherforecast.R;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateNextScreen();

            }


        }, 700);
    }

    private void navigateNextScreen() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();

    }
}
