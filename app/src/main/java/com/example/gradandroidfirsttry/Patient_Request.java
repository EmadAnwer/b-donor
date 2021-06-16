package com.example.gradandroidfirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Patient_Request extends AppCompatActivity {

//    List<String> subCategories = new ArrayList<>();

    Spinner city_spinner, hospital_spinner;

    ArrayList<String> arrayList_city;
    ArrayAdapter<String> arrayAdapter_city;

    ArrayList<String> arrayList_mokkattam, arrayList_fifthSettelment,
            arrayList_madinetNasr;
    ArrayAdapter<String> arrayAdapter_hospital;


    Button req_doc_pic;
    ImageView upload_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_request);

        /* // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);  */

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView back_from_pat_req1 = findViewById(R.id.back_from_pat_req1);
        back_from_pat_req1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Request.this,Patient_intro_Request.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Back",Toast.LENGTH_LONG).show();

            }
        });

        city_spinner = (Spinner)findViewById(R.id.set_req_city);
        hospital_spinner = (Spinner)findViewById(R.id.set_req_hospital);

        arrayList_city = new ArrayList<>();
        arrayList_city.add("Mokkattam");
        arrayList_city.add("Fifth Settlement");
        arrayList_city.add("Madinet Nasr");


        arrayAdapter_city = new ArrayAdapter<>(getApplication(),
                android.R.layout.simple_spinner_item, arrayList_city);
        city_spinner.setAdapter(arrayAdapter_city);

        //======== hospital spinner process starts =========
        arrayList_mokkattam = new ArrayList<>();
        arrayList_mokkattam.add("9th Street Clinics");
        arrayList_mokkattam.add("Tabarak Childern's Hospital");
        arrayList_mokkattam.add("El-Masry Specialized Hospital");
        arrayList_mokkattam.add("Mokkatam Specialized Hospital");


        arrayList_fifthSettelment = new ArrayList<>();
        arrayList_fifthSettelment.add("Air Force Specialized Hospital");
        arrayList_fifthSettelment.add("El-Karma Hospital");
        arrayList_fifthSettelment.add("Town Hospital");
        arrayList_fifthSettelment.add("General Hospital Fifth Settlement");


        arrayList_madinetNasr = new ArrayList<>();
        arrayList_madinetNasr.add("Nasr city Hospital");
        arrayList_madinetNasr.add("Seha Al Akkad Hospital");
        arrayList_madinetNasr.add("Adam Hospital clinics");
        arrayList_madinetNasr.add("Dar El-Fouad Hospital");



        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    arrayAdapter_hospital = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_mokkattam);

                }

                if (position==1)
                {
                    arrayAdapter_hospital = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_fifthSettelment);

                }

                if (position==2)
                {
                    arrayAdapter_hospital = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_madinetNasr);

                }

                hospital_spinner.setAdapter(arrayAdapter_hospital);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    /*    Button done_req = findViewById(R.id.done_req);
        done_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Request.this,Patient_intro_Request.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Done! Now you can start tracking your request",Toast.LENGTH_LONG).show();

            }
        });*/

//        List<String> categories = new ArrayList<>();
//        categories.add("Select your location");
//        categories.add("Mokkattam");
//        categories.add("Fifth settlement");
//        categories.add("Madinet Nasr");
//
//        List<String>  subCategories = new ArrayList<>();
//
//        Spinner set_req_city_spinner = findViewById(R.id.set_req_city);
//        ArrayAdapter<String> set_req_city_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
//        set_req_city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //set the spinners adapter to the previously created one.
//        set_req_city_spinner.setAdapter(set_req_city_adapter);
//
//        set_req_city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//
//                if (adapterView.getItemAtPosition(position).equals("Mokkattam")) {
//                    subCategories.clear();
//                    subCategories.add("9th Street Clinics");
//                    subCategories.add("Tabarak Childern's Hospital");
//                    subCategories.add("El-Masry Specialized Hospital");
//                    subCategories.add("Mokkatam Specialized Hospital");
//                    fillSpinner();
//                } else if (adapterView.getItemAtPosition(position).equals("Fifth settlement")) {
//                    subCategories.clear();
//                    subCategories.add("Air Force Specialized Hospital");
//                    subCategories.add("El-Karma Hospital");
//                    subCategories.add("Town Hospital");
//                    subCategories.add("General Hospital Fifth Settlement");
//                    fillSpinner();
//                } else if (adapterView.getItemAtPosition(position).equals("Madinet Nasr")) {
//                    subCategories.clear();
//                    subCategories.add("Nasr city Hospital");
//                    subCategories.add("Seha Al Akkad Hospital");
//                    subCategories.add("Adam Hospital clinics");
//                    subCategories.add("Dar El-Fouad Hospital");
//                    fillSpinner();
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


          req_doc_pic=(Button)findViewById(R.id.btnSelectPhoto);
          upload_pic=(ImageView)findViewById(R.id.upload_document_pic);
          req_doc_pic.setOnClickListener(new View.OnClickListener() {

                   @Override
                    public void onClick(View v) {
                       selectImage();
                      }
                   });

    }


//        private void fillSpinner() {
//
//            Spinner set_req_hospital_spinner = findViewById(R.id.set_req_hospital);
//            List<String>  subCategories = new ArrayList<>();
//
//            ArrayAdapter<String> set_req_hospital_adapter;
//            set_req_hospital_adapter = new ArrayAdapter<>(this, android.R.layout
//                    .simple_spinner_item, subCategories);
//            set_req_hospital_adapter.setDropDownViewResource(android.R.layout
//                    .simple_spinner_dropdown_item);
//            set_req_hospital_spinner.setAdapter(set_req_hospital_adapter);
//        }


                     @Override
                        public boolean onCreateOptionsMenu(Menu menu) {
                       // Inflate the menu; this adds options to the action bar if it is present.
                      getMenuInflater().inflate(R.menu.upload_doc_pic_menu, menu);
                       return true;
                 }
                       private void selectImage() {
                        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
                        AlertDialog.Builder builder = new AlertDialog.Builder(Patient_Request.this);
                        builder.setTitle("Add Photo!");
                        builder.setItems(options, new DialogInterface.OnClickListener() {

                        @Override
                         public void onClick(DialogInterface dialog, int item) {
                         if (options[item].equals("Take Photo"))
                              {
                                  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                  File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                                  intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                                  startActivityForResult(intent, 1);
                              }
                         else if (options[item].equals("Choose from Gallery"))
                              {
                                  Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                  startActivityForResult(intent, 2);
                              }
                         else if (options[item].equals("Cancel")) {
                                 dialog.dismiss();
                              }
                        }
                  });
                      builder.show();
             }

     //new code
    public void request(View view) {
        PatientRequest patientRequest = new PatientRequest();

        patientRequest.setName("Emad");
        patientRequest.setBloodType("A");
        patientRequest.setPhone("012222222");
        patientRequest.setRHType("Negative");
        patientRequest.setPatientAge(30);
        patientRequest.setGender("Male");
        patientRequest.setQuantity(4);
        patientRequest.setCity("Alexandria");
        patientRequest.setHospital("Alexandria hospital");
        patientRequest.setPicture_url("https://cdn.getyourguide.com/img/location/540dc894dff37-m1409674485.jpg/92.jpg");

        Backendless.Data.of(PatientRequest.class).save(patientRequest, new AsyncCallback<PatientRequest>() {
            @Override
            public void handleResponse(PatientRequest response) {

                onBackPressed();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }
}

   /*  // this event will enable the back
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

