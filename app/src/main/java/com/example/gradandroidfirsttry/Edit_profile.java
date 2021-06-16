package com.example.gradandroidfirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class Edit_profile extends AppCompatActivity {

    public static final String TAG = "TAG";

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    StorageReference storageReference;

    EditText edit_name_profile, edit_username_profile, edit_email_profile, edit_phone_profile;
    Button done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent data = getIntent();
        final String profileName = data.getStringExtra("profileName");
        String email_profile = data.getStringExtra("email_profile");
        String phone = data.getStringExtra("phoneNo_profile");
        String phoneNo_profile = data.getStringExtra("username_profile");
        String blood_type_profile= data.getStringExtra("blood_type_profile");


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        storageReference = FirebaseStorage.getInstance().getReference();

        edit_name_profile = findViewById(R.id.edit_name_profile);
        edit_username_profile = findViewById(R.id.edit_username_profile);
        edit_email_profile = findViewById(R.id.edit_Email_profile);
        edit_phone_profile = findViewById(R.id.edit_phone_profile);


        done = findViewById(R.id.Done_btn);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_name_profile.getText().toString().isEmpty() || edit_email_profile.getText().toString().isEmpty() || edit_phone_profile.getText().toString().isEmpty()){
                    Toast.makeText(Edit_profile.this, "One or Many fields are empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                final String email = edit_email_profile.getText().toString();
                user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docRef = fStore.collection("users").document(user.getUid());
                        Map<String,Object> edited = new HashMap<>();
                        edited.put("email",email);
                        edited.put("fName",edit_name_profile.getText().toString());
                        edited.put("phone",edit_phone_profile.getText().toString());
                        edited.put("username",edit_username_profile.getText().toString());

                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Edit_profile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        });
                        Toast.makeText(Edit_profile.this, "Email is changed.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Edit_profile.this,   e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });




    }
}