package com.html.zuraaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/** NIM   : 10119231
 * Nama   : Muhamad Zulhaqi
 * Kelas  : IF-6
 * Tanggal Pengerjaan : 04-05-2022
 */

public class MainActivity extends AppCompatActivity {
    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,walkthrough.class);
                startActivity(intent);
                finish();
            }
        };

        // its trigger runnable after 4000 millisecond.
        mHandler.postDelayed(mRunnable,2000);

    }
}