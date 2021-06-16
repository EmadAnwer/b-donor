package com.example.gradandroidfirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Intro_page_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page_3);


        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView back_from_person_org = findViewById(R.id.back_from_person_org);
        back_from_person_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intro_page_3.this,Intro_page_2.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Back From Intro 3",Toast.LENGTH_LONG).show();

            }
        });

        Button sign_as_person = findViewById(R.id.sign_person);
        sign_as_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intro_page_3.this,Person_Registration.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Person Registration",Toast.LENGTH_LONG).show();

            }
        });

        Button sign_as_org = findViewById(R.id.sign_org);
        sign_as_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intro_page_3.this,Organization_Registeration.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Organization Registration",Toast.LENGTH_LONG).show();

            }
        });
    }

    // this event will enable the back
    // function to the button on press
   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}