package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

public class Intro_page_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page2);

        /* // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);  */

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView back_from_register_login = findViewById(R.id.back_from_register_login);
        back_from_register_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intro_page_2.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Back From Intro 2",Toast.LENGTH_LONG).show();

            }
        });

        // 1st button
        ImageView signup = findViewById(R.id.registeration_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intro_page_2.this,Intro_page_3.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "SignUp",Toast.LENGTH_LONG).show();

            }
        });
        // 2nd button
        ImageView login = findViewById(R.id.loin_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intro_page_2.this,Login_page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Login",Toast.LENGTH_LONG).show();
            }
        }); //end of buttons

    }

    /* // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    } */




}