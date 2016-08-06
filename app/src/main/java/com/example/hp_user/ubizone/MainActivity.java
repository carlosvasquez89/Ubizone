package com.example.hp_user.ubizone;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewFlipper;
import android.view.View;

public class MainActivity extends AppCompatActivity {
        ViewFlipper viewFlipper;

        ViewPager viewPager;
        customSwip  customSwip;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            viewPager=(ViewPager)findViewById(R.id.viewPager);
            customSwip=new customSwip(this);
            viewPager.setAdapter(customSwip);



        }




    }

