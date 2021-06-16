package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Req_select_location extends AppCompatActivity {

    List<String>  subCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_select_location);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
//        //SET City Spinner
//        //create a list of items for the spinner.
//        String[] set_req_city_items = new String[]{"Select your location", "Mokkattam", "Masr El-Gededa", "Rehab",
//                "Fifth settlement ", "Madinet Nasr", "Madinity", "Elshrouk", "El-Obour", "Maaadi",
//                "Masr El-Adema", "West El-Balad", "Sheraton", "Shobra", "Gesr El-Swis", "Elnozha", "El-Zamalk"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.


        List<String> categories = new ArrayList<>();
        categories.add("Select your location");
        categories.add("Mokkattam");
        categories.add("Fifth settlement");
        categories.add("Madinet Nasr");

        List<String>  subCategories = new ArrayList<>();

        Spinner set_req_city_spinner = findViewById(R.id.set_req_city);
        ArrayAdapter<String> set_req_city_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        set_req_city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set the spinners adapter to the previously created one.
        set_req_city_spinner.setAdapter(set_req_city_adapter);

        set_req_city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (adapterView.getItemAtPosition(position).equals("Mokkattam")) {
                    subCategories.clear();
                    subCategories.add("9th Street Clinics");
                    subCategories.add("Tabarak Childern's Hospital");
                    subCategories.add("El-Masry Specialized Hospital");
                    subCategories.add("Mokkatam Specialized Hospital");
                    fillSpinner();
                } else if (adapterView.getItemAtPosition(position).equals("Fifth settlement")) {
                    subCategories.clear();
                    subCategories.add("Air Force Specialized Hospital");
                    subCategories.add("El-Karma Hospital");
                    subCategories.add("Town Hospital");
                    subCategories.add("General Hospital Fifth Settlement");
                    fillSpinner();
                } else if (adapterView.getItemAtPosition(position).equals("Madinet Nasr")) {
                    subCategories.clear();
                    subCategories.add("Nasr city Hospital");
                    subCategories.add("Seha Al Akkad Hospital");
                    subCategories.add("Adam Hospital clinics");
                    subCategories.add("Dar El-Fouad Hospital");
                    fillSpinner();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Button next_2_req = findViewById(R.id.next_2_req);
        next_2_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Req_select_location.this, Req_upload_document_picture.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Upload you document please", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void fillSpinner ()
    {
        Spinner set_req_hospital_spinner = findViewById(R.id.set_req_hospital);
        List<String>  subCategories = new ArrayList<>();

        ArrayAdapter<String> set_req_hospital_adapter;
        set_req_hospital_adapter = new ArrayAdapter<>(this, android.R.layout
                .simple_spinner_item, subCategories);
        set_req_hospital_adapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        set_req_hospital_spinner.setAdapter(set_req_hospital_adapter);

    }


}
