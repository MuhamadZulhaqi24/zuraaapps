package com.html.zuraaapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

/** NIM   : 10119231
 * Nama   : Muhamad Zulhaqi
 * Kelas  : IF-6
 * Tanggal Pengerjaan : 07-05-2022
 */

public class Profile extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Button btnAbout;
    TextView btnMail, btnFb;
    ImageView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnAbout = findViewById(R.id.btnAbout);
        btnMail = findViewById(R.id.btnEmail);
        btnFb = findViewById(R.id.btnFb);
        location = findViewById(R.id.location);

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/zul.naxzcuakep/"));
                startActivity(intent);
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String email = "muhamadzulhaqi@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(intent);
            }
        });


        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.menuProfile); //sus

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuActivity:
                        startActivity(new Intent(getApplicationContext(), Daily.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuGallery:
                        startActivity(new Intent(getApplicationContext(), Gallery.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuMusic:
                        startActivity(new Intent(getApplicationContext(), Music.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menuProfile:
                        return true;
                }
                return false;
            }
        });
    }
}