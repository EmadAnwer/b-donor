package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Trouble_login_phone_no extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trouble_login_phone_no);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button trouble_username_email_inphone = findViewById(R.id.trouble_username_email_inphone);
        trouble_username_email_inphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Trouble_login_phone_no.this,Trouble_login_username_email.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "use username",Toast.LENGTH_LONG).show();

            }
        });

        Button done_trouble_inphone = findViewById(R.id.done_trouble_inphone);
        done_trouble_inphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Trouble_login_phone_no.this,Login_page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Try login again.",Toast.LENGTH_LONG).show();

            }
        });


    }
}