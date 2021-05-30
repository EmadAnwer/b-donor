package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Organization_Registeration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organization_registeration);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }
}