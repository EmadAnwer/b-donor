package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.push.DeviceRegistrationResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Backendless.initApp(this, "4C0A565C-FA08-8679-FF8C-87FF43138500", "E4CAB4A8-B10A-4960-83B9-4AC1F8E3602A");



//
//        List<String> channels = new ArrayList<>();
//        channels.add( "default" );
//        Backendless.Messaging.registerDevice(channels, new AsyncCallback<DeviceRegistrationResult>() {
//            @Override
//            public void handleResponse(DeviceRegistrationResult response) {
//                Toast.makeText(MainActivity.this, "Device registered!",
//                        Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void handleFault(BackendlessFault fault) {
//                Toast.makeText( MainActivity.this, "Error registering " + fault.getMessage(),
//                        Toast.LENGTH_LONG).show();
//            }
//        });


        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button Wel_to_registration = findViewById(R.id.Wel_to_registration);
        Wel_to_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Person_Registration.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Registration",Toast.LENGTH_LONG).show();

            }
        });

        Button Wel_to_login = findViewById(R.id.Wel_to_login);
        Wel_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Login_page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Login",Toast.LENGTH_LONG).show();

            }
        });



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "Push notification demo. You tapped a notification", Toast.LENGTH_LONG).show();
    }
}