package com.example.gradandroidfirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.Fault;
import com.backendless.exceptions.BackendlessFault;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.text.SimpleDateFormat;


public class Login_page extends AppCompatActivity implements AsyncCallback<BackendlessUser> {

    public static final String TAG = "TAG";

    EditText password_edit, email_edit;

    ProgressBar progressBar;
    SharedPreferences pref;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        pref = getSharedPreferences("userData", Context.MODE_PRIVATE);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        progressBar = findViewById(R.id.progressBar);

        password_edit = findViewById(R.id.password_edit);
        email_edit = findViewById(R.id.email_edit);

        ImageView back_from_login = findViewById(R.id.back_from_login);
        back_from_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login_page.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Back From Intro",Toast.LENGTH_LONG).show();

            }
        });

        TextView forget_password = findViewById(R.id.forget_password);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login_page.this,Trouble_login_username_email.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Forget Password",Toast.LENGTH_LONG).show();

            }
        });


        Button login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email_edit.getText().toString().trim();
                String password = password_edit.getText().toString().trim();



//                Intent intent = new Intent(Login_page.this,New_bottom_navigation_menu.class);
//                startActivity(intent);
//
//                Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();

                if(TextUtils.isEmpty(email)){
                    email_edit.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    password_edit.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    password_edit.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user

                Backendless.UserService.login(email,password,Login_page.this,true);

                Toast.makeText(Login_page.this, "Login user!", Toast.LENGTH_LONG).show();


            }
        });

    }


    @Override
    public void handleResponse(BackendlessUser response) {
        Toast.makeText(Login_page.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("first_name", response.getProperty("first_name").toString());
        editor.putString("last_name", response.getProperty("last_name").toString());
        editor.putString("email", response.getProperty("email").toString());
        editor.putString("address", response.getProperty("address").toString());
        editor.putString("phone", response.getProperty("phone").toString());
        editor.putInt("user_age", (Integer) response.getProperty("user_age"));
        editor.putString("user_name", response.getProperty("user_name").toString());
        editor.putString("gender", response.getProperty("gender").toString());
        editor.putString("blood_type", response.getProperty("blood_type").toString());
        editor.putString("rh_type", response.getProperty("rh_type").toString());



        if(response.getProperty("lastDonationDate") != null)
        {

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String lastDonationDate = formatter.format(response.getProperty("lastDonationDate"));
            editor.putString("lastDonationDate", lastDonationDate);
        }
        else
            editor.putString("lastDonationDate", "null");

        editor.apply();


        startActivity(new Intent(getApplicationContext(),New_bottom_navigation_menu.class));

    }

    @Override
    public void handleFault(BackendlessFault fault) {

        Log.i(TAG, "handleFault: "+fault.toString());
        Toast.makeText(Login_page.this, "error"+fault.toString() ,Toast.LENGTH_LONG).show();

        progressBar.setVisibility(View.GONE);
    }
}