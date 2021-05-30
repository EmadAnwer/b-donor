package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button patient = findViewById(R.id.Patient);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Patient_intro_Request.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Patient",Toast.LENGTH_LONG).show();

            }
        });

        Button donor = findViewById(R.id.Donor);
        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Intro_page_2.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Donor",Toast.LENGTH_LONG).show();

            }
        });



    }
}