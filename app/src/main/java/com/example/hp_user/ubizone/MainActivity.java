package com.example.hp_user.ubizone;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CustomSwip customSwip;
    private Handler handler = new Handler();
    private int position = 0;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (position >= 3) {
                position = 0;
            } else {
                position = position + 1;
            }
            viewPager.setCurrentItem(position, true);
            handler.postDelayed(runnable, 8000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        customSwip = new CustomSwip(this);
        viewPager.setAdapter(customSwip);

        this.setTypeface(R.id.btn_bares);
        this.setTypeface(R.id.btn_eventos);
        this.setTypeface(R.id.btn_restaurantes);
    }

    private void setTypeface(int id) {
        FancyButton btn = (FancyButton) findViewById(id);
        btn.setCustomTextFont("HMONE.ttf");
    }

    @Override
    public void onPause() {
        super.onPause();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        handler.postDelayed(runnable, 10000);
    }

}
