package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main_Track_Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_track_request_activity_);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}