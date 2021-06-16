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

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Patient_Request extends AppCompatActivity {

    List<String> subCategories = new ArrayList<>();


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

        Button done_req = findViewById(R.id.done_req);
        done_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Patient_Request.this,Patient_intro_Request.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Done! Now you can start tracking your request",Toast.LENGTH_LONG).show();

            }
        });

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


          req_doc_pic=(Button)findViewById(R.id.btnSelectPhoto);
          upload_pic=(ImageView)findViewById(R.id.upload_document_pic);
          req_doc_pic.setOnClickListener(new View.OnClickListener() {

                   @Override
                    public void onClick(View v) {
                       selectImage();
                      }
                   });

    }
            private void fillSpinner() {

                Spinner set_req_hospital_spinner = findViewById(R.id.set_req_hospital);
                List<String>  subCategories = new ArrayList<>();

                ArrayAdapter<String> set_req_hospital_adapter;
                set_req_hospital_adapter = new ArrayAdapter<>(this, android.R.layout
                        .simple_spinner_item, subCategories);
                set_req_hospital_adapter.setDropDownViewResource(android.R.layout
                        .simple_spinner_dropdown_item);
                set_req_hospital_spinner.setAdapter(set_req_hospital_adapter);
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

