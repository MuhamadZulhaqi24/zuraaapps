package com.html.zuraaapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class walkthrough extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicator;
    private MaterialButton buttonOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        getSupportActionBar().hide();

        layoutOnboardingIndicator = findViewById(R.id.LayoutOnBoardingIndicator);
        buttonOnboardingAction = findViewById(R.id.buttonOnBoardAction);

        setupOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onBoardViewPage);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardindIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardindIndicator(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()){
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }
        });

    }

    private void setupOnboardingItems() {

        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem pengenalan = new OnboardingItem();
        pengenalan.setTitle("Selamat Datang di Zuraaapps");
        pengenalan.setDescription("Senang kalian bisa bergabung dengan kami");
        pengenalan.setImage(R.drawable.imagesocial);

        OnboardingItem bergabung = new OnboardingItem();
        bergabung.setTitle("Pengenalan Data Diri");
        bergabung.setDescription("Disini kita akan menjelajah profil tentang diriku");
        bergabung.setImage(R.drawable.imagetheworld);

        OnboardingItem enjoyApps = new OnboardingItem();
        enjoyApps.setTitle("Happy Watching");
        enjoyApps.setDescription("Ku harap kalian memaklumi hasil sederhana ku ini :)");
        enjoyApps.setImage(R.drawable.imagethreat);

        onboardingItems.add(pengenalan);
        onboardingItems.add(bergabung);
        onboardingItems.add(enjoyApps);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }
    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }
    private void setCurrentOnboardindIndicator(int index) {
        int childCount = layoutOnboardingIndicator.getChildCount();
        for (int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if (i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onboardingAdapter.getItemCount() - 1){
            buttonOnboardingAction.setText("Mulai");

        }else {
            buttonOnboardingAction.setText("Lanjut");
        }
    }
}
