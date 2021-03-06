package com.example.gradandroidfirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import java.util.HashMap;
import java.util.Map;

public class Person_Registration extends AppCompatActivity implements AsyncCallback<BackendlessUser> {

    String userID;



    private static final String USERS = "users";
//    private String TAG = "RegisterActivity";

    private String fname, lname, email, phone, username, age,
            bloodType, rhType, gender, address;
    private String password;


    public static final String TAG = "TAG";

    private TextView reg_terms_policies;
    private EditText first_name_edit, last_name_edit, phone_number_edit, username_edit, password_edit, email_edit, age_edit;
    private RadioButton radio_male_btn, radio_female_btn, radio_a_blood_type, radio_b_blood_type,
            radio_ab_blood_type, radio_o_blood_type, radio_pos_rh_type, radio_neg_rh_type, reg_terms_policies_radioButton;
    private RadioGroup radio_group_blood_type_btn, radio_group_rh_type_btn, radio_group_last_donation_time,
            terms_polices_radioGroup;
    private Spinner address_spinner;
    private CheckBox reg_terms_policies_checkbox;


    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_registration);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button back_from_reg_to_welcome = findViewById(R.id.back_to_welcome_from_reg);
        back_from_reg_to_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
//                Intent intent = new Intent(Person_Registration.this, MainActivity.class);
//                startActivity(intent);
            }
        });



        reg_terms_policies = findViewById(R.id.reg_terms_policies_btn);
        reg_terms_policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Person_Registration.this);
                builder.setTitle("Terms and Policies!");
                builder.setMessage("1-The Donor's age must Be Between 18 &amp; 65 \n \n 2-Location Must Be accessed " +
                        "\n \n 3-Diseases must not be from the Following : Malaria , Hereditary blood diseases , Diabetics, Sever Anemia , Cancer , Blood Pressure , Heart Diseases " +
                        "\n \n 4-Between every donation process must be 56 Days" );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
                        Toast.makeText(getApplicationContext(),
                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();

            }
        });

        progressBar = findViewById(R.id.progressBar);
        first_name_edit = findViewById(R.id.first_name_edit);
        last_name_edit = findViewById(R.id.last_name_edit);
        phone_number_edit = findViewById(R.id.phone_number_edit);
        username_edit = findViewById(R.id.username_edit);
        password_edit = findViewById(R.id.password_edit);
        email_edit = findViewById(R.id.email_edit);
        age_edit = findViewById(R.id.age_edit);
        radio_male_btn = findViewById(R.id.male_btn);
        radio_female_btn = findViewById(R.id.female_btn);
        radio_a_blood_type = findViewById(R.id.blood_a_btn);
        radio_b_blood_type = findViewById(R.id.blood_b_btn);
        radio_ab_blood_type = findViewById(R.id.blood_ab_btn);
        radio_o_blood_type = findViewById(R.id.blood_o_btn);
        radio_pos_rh_type = findViewById(R.id.positive_btn);
        radio_neg_rh_type = findViewById(R.id.negative_btn);
        radio_group_blood_type_btn = findViewById(R.id.blood_type_btn);
        radio_group_rh_type_btn = findViewById(R.id.rh_type_btn);
        radio_group_last_donation_time = findViewById(R.id.last_donation_time);

        terms_polices_radioGroup = findViewById(R.id.terms_polices_radioGroup);
        reg_terms_policies_radioButton = findViewById(R.id.reg_terms_policies_radioButton);


        //In Case the terms is a checkbox
//        reg_terms_policies_checkbox = findViewById(R.id.reg_terms_policies_checkbox);
//        reg_terms_policies_checkbox.setChecked(true);


        address_spinner = findViewById(R.id.address_spinner);

        //address_spinner
        //get the spinner from the xml.
        Spinner address_spinner = findViewById(R.id.address_spinner);

        //create a list of items for the spinner.
        String[] address_items = new String[]{ "Select your City", "Mokkattam", "Maaadi","Fifth settlement ",
                "Madinet Nasr","Gesr El-Swis", "El-Abbasaya", "Masr El-Gededa", "Rehab", "Madinity","Elshrouk", "El-Obour",
                 "Masr El-Adema","West El-Balad", "Sheraton", "Shobra", "Elnozha", "El-Zamalk" };

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> address_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, address_items);
        //set the spinners adapter to the previously created one.
        address_spinner.setAdapter(address_adapter);


    }

    public void createAccount(View view) {
        BackendlessUser user  =  new BackendlessUser();

        final String email = email_edit.getText().toString().trim();
        String password = password_edit.getText().toString().trim();
        final String first_name = first_name_edit.getText().toString();
        final String last_name = last_name_edit.getText().toString();
        final String phone = phone_number_edit.getText().toString();
        final String username = username_edit.getText().toString();
        final int age = Integer.parseInt(age_edit.getText().toString());

        String gender = "";
        String blood_type = "";
        String rh_type = "";

        String address = address_spinner.getSelectedItem().toString();

        if (radio_male_btn.isChecked()) {
            gender = "Male";
        } else if (radio_female_btn.isChecked()) {
            gender = "Female";
        }

        if (radio_a_blood_type.isChecked()) {
            blood_type = "A";
        } else if (radio_b_blood_type.isChecked()) {
            blood_type = "B";
        } else if (radio_ab_blood_type.isChecked()) {
            blood_type = "AB";
        } else if (radio_o_blood_type.isChecked()) {
            blood_type = "O";
        }

        if (radio_neg_rh_type.isChecked()) {
            rh_type = "-ve";
        } else if (radio_pos_rh_type.isChecked()) {
            rh_type = "+ve";
        }

        int blood_type_group = radio_group_blood_type_btn.getCheckedRadioButtonId();
        int rh_type_group = radio_group_rh_type_btn.getCheckedRadioButtonId();
        int last_donation_time = radio_group_last_donation_time.getCheckedRadioButtonId();
        int terms_group = terms_polices_radioGroup.getCheckedRadioButtonId();

        if (TextUtils.isEmpty(email)) {
            email_edit.setError("Email is Required.");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            password_edit.setError("Password is Required.");
            return;
        }

        if (password.length() < 6) {
            password_edit.setError("Password Must be >= 6 Characters");
            return;
        }

        if (TextUtils.isEmpty(first_name)) {
            first_name_edit.setError("First Name is Required.");
            return;
        }

        if (TextUtils.isEmpty(last_name)) {
            last_name_edit.setError("Last Name is Required.");
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            phone_number_edit.setError("Phone number is Required.");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            username_edit.setError("username is Required.");
            return;
        }
        if (age < 18 || age > 65) {
            age_edit.setError("Your age must be between 18 and 65.");
            return;
        }

        if (blood_type_group == -1) {
            Toast.makeText(Person_Registration.this, "Please insert your Blood type.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (rh_type_group == -1) {
            Toast.makeText(Person_Registration.this, "Please insert your RH type.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (last_donation_time == -1) {
            Toast.makeText(Person_Registration.this, "Please select when was your last donation time?.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (terms_group == -1) {
            Toast.makeText(Person_Registration.this, "Please accept our terms!.", Toast.LENGTH_SHORT).show();
            return;
        }



        user.setEmail(email);
        user.setPassword(password);
        user.setProperty("first_name",first_name);
        user.setProperty("last_name",last_name);
        user.setProperty("phone",phone);
        user.setProperty("user_age",age);
        user.setProperty("user_name",username);
        user.setProperty("gender",gender);
        user.setProperty("blood_type",blood_type);
        user.setProperty("rh_type",rh_type);
        user.setProperty("address", address);


        Toast.makeText(this, "Create user!", Toast.LENGTH_SHORT).show();

        Backendless.UserService.register(user, this);




    }

    @Override
    public void handleResponse(BackendlessUser response) {
        Toast.makeText(this, "Registration Done!", Toast.LENGTH_SHORT).show();

        onBackPressed();
    }

    @Override
    public void handleFault(BackendlessFault fault) {
        Log.i(TAG, "handleFault: "+fault.toString());
        Toast.makeText(this, "Registration Failed!"+fault.toString(), Toast.LENGTH_SHORT).show();
    }
}