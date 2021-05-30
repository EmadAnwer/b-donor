package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Person_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_registration);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        Button cont_registration = findViewById(R.id.cont_person_reg);
        cont_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Person_Registration.this,person_registration_cont.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Con't Registeration",Toast.LENGTH_LONG).show();

            }
        });
    }
}