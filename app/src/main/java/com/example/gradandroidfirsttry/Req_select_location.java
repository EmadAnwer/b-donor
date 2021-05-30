package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Req_select_location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_select_location);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button next_2_req = findViewById(R.id.next_2_req);
        next_2_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Req_select_location.this,Req_upload_document_picture.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Upload you document please",Toast.LENGTH_LONG).show();

            }
        });

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.set_location_spinner1);

        //create a list of items for the spinner.
        String[] items = new String[]{ "Select your location", "Mokkattam", "Masr El-Gededa", "Rehab", "Fifth settlement ", "Madinet Nasr", "Madinity",
        "Elshrouk", "El-Obour", "Maaadi", "Masr El-Adema", };

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

    }
}