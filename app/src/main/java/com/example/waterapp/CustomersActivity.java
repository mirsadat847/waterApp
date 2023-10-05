package com.example.waterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.waterapp.databinding.ActivityCustomersBinding;

public class CustomersActivity extends DrawerBaseActivity {

    ActivityCustomersBinding activityCustomersBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCustomersBinding = activityCustomersBinding.inflate(getLayoutInflater());
        setContentView(activityCustomersBinding.getRoot());
        allocateActivityTitle("Customer");
    }
}