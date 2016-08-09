package com.example.hp_user.ubizone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    mehdi.sakout.fancybuttons.FancyButton eventos;

    private ViewPager viewPager;
    private customSwip customSwip;
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

        eventos = (mehdi.sakout.fancybuttons.FancyButton) findViewById(R.id.btn_eventos);
        eventos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        customSwip = new customSwip(this);
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
