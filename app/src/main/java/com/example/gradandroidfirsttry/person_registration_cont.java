package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class person_registration_cont extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_registration_cont);


        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button done_registration = findViewById(R.id.done_reg);
        done_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(person_registration_cont.this,Login_page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Done Registeration",Toast.LENGTH_LONG).show();

            }
        });

        TextView reg_terms_policies_btn = findViewById(R.id.reg_terms_policies_btn);
        reg_terms_policies_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(person_registration_cont.this,popup.class);
                startActivity(intent);


            }
        });

    }
}