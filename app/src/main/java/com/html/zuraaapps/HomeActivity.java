package com.html.zuraaapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.html.zuraaapps.databinding.ActivityMainBinding;

import java.util.Objects;

/** NIM   : 10119231
 * Nama   : Muhamad Zulhaqi
 * Kelas  : IF-6
 * Tanggal Pengerjaan : 07-05-2022
 */
public class HomeActivity extends AppCompatActivity {

   ActivityMainBinding binding;
   BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.menuHome); //sus

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menuHome:
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
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

 }

}