package com.example.openingtest.Opening;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.openingtest.MainActivity;
import com.example.openingtest.R;

/**
 * Created by qwert on 2018-02-16.
 */

public class OpeningActivity extends AppCompatActivity {


    public OpeningActivity() {

        MainActivity.firstintro = false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(OpeningActivity.this,MainActivity.class);
                startActivity(intent);

                finish();

            }
        },2000);

    }
}

