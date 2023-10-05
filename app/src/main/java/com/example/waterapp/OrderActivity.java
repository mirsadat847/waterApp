package com.example.waterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.waterapp.databinding.ActivityOrderBinding;

public class OrderActivity extends DrawerBaseActivity {

    ActivityOrderBinding activityOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding = activityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateActivityTitle("Orders");
    }
}