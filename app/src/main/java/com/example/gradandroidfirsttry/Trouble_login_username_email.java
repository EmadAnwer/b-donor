package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Trouble_login_username_email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trouble_login_username_email);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        Button trouble_phone_no_inuser = findViewById(R.id.trouble_phone_no_inuser);
        trouble_phone_no_inuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Trouble_login_username_email.this,Trouble_login_phone_no.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "use phone no.",Toast.LENGTH_LONG).show();

            }
        });

        Button done_trouble_inuser = findViewById(R.id.done_trouble_inuser);
        done_trouble_inuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Trouble_login_username_email.this,Login_page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Try login again.",Toast.LENGTH_LONG).show();

            }
        });

    }
}