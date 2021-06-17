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
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    EditText patient_name, patient_number, patient_age, patient_needed_quantity;

    private RadioButton patient_radio_male_btn, patient_radio_female_btn, patient_radio_a_blood_type,
            patient_radio_b_blood_type, patient_radio_ab_blood_type, patient_radio_o_blood_type,
            patient_radio_pos_rh_type, patient_radio_neg_rh_type;

    private RadioGroup patient_radio_group_blood_type_btn, patient_radio_group_rh_type_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_request);

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

        patient_name = findViewById(R.id.patient_name);
        patient_number = findViewById(R.id.patient_number);
        patient_age = findViewById(R.id.patient_age);
        patient_needed_quantity = findViewById(R.id.patient_needed_quantity);
        patient_radio_male_btn = findViewById(R.id.pat_male_btn);
        patient_radio_female_btn = findViewById(R.id.pat_female_btn);
        patient_radio_a_blood_type = findViewById(R.id.patient_blood_a_btn);
        patient_radio_b_blood_type = findViewById(R.id.patient_blood_b_btn);
        patient_radio_ab_blood_type = findViewById(R.id.patient_blood_ab_btn);
        patient_radio_o_blood_type = findViewById(R.id.patient_blood_o_btn);
        patient_radio_pos_rh_type = findViewById(R.id.patient_pos_rh_btn);
        patient_radio_neg_rh_type = findViewById(R.id.patient_neg_rh_btn);
        patient_radio_group_blood_type_btn = findViewById(R.id.patient_blood_type_btn);
        patient_radio_group_rh_type_btn = findViewById(R.id.patient_rh_type_btn);


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


        req_doc_pic=(Button)findViewById(R.id.btnSelectPhoto);
        upload_pic=(ImageView)findViewById(R.id.upload_document_pic);
        req_doc_pic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

    }


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

        final String name = patient_name.getText().toString();
        final String phone = patient_number.getText().toString();
        final int needed_quantity = Integer.parseInt(patient_needed_quantity.getText().toString());
        final int age = Integer.parseInt(patient_age.getText().toString());

        String gender = "";
        String blood_type = "";
        String rh_type = "";

        String city = city_spinner.getSelectedItem().toString();
        String hospital = hospital_spinner.getSelectedItem().toString();

        if (patient_radio_male_btn.isChecked()) {
            gender = "Male";
        } else if (patient_radio_female_btn.isChecked()) {
            gender = "Female";
        }

        if (patient_radio_a_blood_type.isChecked()) {
            blood_type = "A";
        } else if (patient_radio_b_blood_type.isChecked()) {
            blood_type = "B";
        } else if (patient_radio_ab_blood_type.isChecked()) {
            blood_type = "AB";
        } else if (patient_radio_o_blood_type.isChecked()) {
            blood_type = "O";
        }

        if (patient_radio_neg_rh_type.isChecked()) {
            rh_type = "Negative";
        } else if (patient_radio_pos_rh_type.isChecked()) {
            rh_type = "Positive";
        }

        int blood_type_group = patient_radio_group_blood_type_btn.getCheckedRadioButtonId();
        int rh_type_group = patient_radio_group_rh_type_btn.getCheckedRadioButtonId();



        if (TextUtils.isEmpty(name)) {
            patient_name.setError("Patient Name is Required.");
            return;
        }


        if (TextUtils.isEmpty(phone)) {
            patient_number.setError("First Name is Required.");
            return;
        }


        if (blood_type_group == -1) {
            Toast.makeText(Patient_Request.this, "Please insert your Blood type.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rh_type_group == -1) {
            Toast.makeText(Patient_Request.this, "Please insert your RH type.", Toast.LENGTH_SHORT).show();
            return;
        }


        patientRequest.setName(name);
        patientRequest.setPhone(phone);
        patientRequest.setBloodType(blood_type);
        patientRequest.setRHType(rh_type);
        patientRequest.setPatientAge(age);
        patientRequest.setGender(gender);
        patientRequest.setQuantity(needed_quantity);
        patientRequest.setCity(city);
        patientRequest.setHospital(hospital);
        patientRequest.setPicture_url("https://cdn.getyourguide.com/img/location/540dc894dff37-m1409674485.jpg/92.jpg");

        Backendless.Data.of(PatientRequest.class).save(patientRequest, new AsyncCallback<PatientRequest>() {
            @Override
            public void handleResponse(PatientRequest response) {

                Toast.makeText(Patient_Request.this, "Request Done!", Toast.LENGTH_LONG).show();
                onBackPressed();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(Patient_Request.this, "Error!", Toast.LENGTH_LONG).show();
            }
        });

    }
}





















//
//
//                     @Override
//                        public boolean onCreateOptionsMenu(Menu menu) {
//                       // Inflate the menu; this adds options to the action bar if it is present.
//                      getMenuInflater().inflate(R.menu.upload_doc_pic_menu, menu);
//                       return true;
//                 }
//                       private void selectImage() {
//                        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
//                        AlertDialog.Builder builder = new AlertDialog.Builder(Patient_Request.this);
//                        builder.setTitle("Add Photo!");
//                        builder.setItems(options, new DialogInterface.OnClickListener() {
//
//                        @Override
//                         public void onClick(DialogInterface dialog, int item) {
//                         if (options[item].equals("Take Photo"))
//                              {
//                                  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                                  File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
//                                  intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
//                                  startActivityForResult(intent, 1);
//                              }
//                         else if (options[item].equals("Choose from Gallery"))
//                              {
//                                  Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                                  startActivityForResult(intent, 2);
//                              }
//                         else if (options[item].equals("Cancel")) {
//                                 dialog.dismiss();
//                              }
//                        }
//                  });
//                      builder.show();
//             }
//
//     //new code
//    public void request(View view) {
//        PatientRequest patientRequest = new PatientRequest();
//
//        patientRequest.setName("Emad");
//        patientRequest.setBloodType("A");
//        patientRequest.setPhone("012222222");
//        patientRequest.setRHType("Negative");
//        patientRequest.setPatientAge(30);
//        patientRequest.setGender("Male");
//        patientRequest.setQuantity(4);
//        patientRequest.setCity("Alexandria");
//        patientRequest.setHospital("Alexandria hospital");
//        patientRequest.setPicture_url("https://cdn.getyourguide.com/img/location/540dc894dff37-m1409674485.jpg/92.jpg");
//
//        Backendless.Data.of(PatientRequest.class).save(patientRequest, new AsyncCallback<PatientRequest>() {
//            @Override
//            public void handleResponse(PatientRequest response) {
//
//                onBackPressed();
//
//            }
//
//            @Override
//            public void handleFault(BackendlessFault fault) {
//
//            }
//        });
//
//    }
//}




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

