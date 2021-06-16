package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Patient_intro_Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_intro_request);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView pat_new_req = findViewById(R.id.new_request_icon);
        pat_new_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_intro_Request.this,Patient_Request.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Patient Request",Toast.LENGTH_LONG).show();

            }
        });

        ImageView pat_view_history_req = findViewById(R.id.history_icon);
        pat_view_history_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_intro_Request.this,Main_History.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Patient View Request History",Toast.LENGTH_LONG).show();

            }
        });

        ImageView track_request_icon = findViewById(R.id.track_request_icon);
        track_request_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_intro_Request.this,Track_request_items.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Patient Track Request",Toast.LENGTH_LONG).show();

            }
        });
    }
}