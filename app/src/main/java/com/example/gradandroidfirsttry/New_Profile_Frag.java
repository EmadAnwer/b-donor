package com.example.gradandroidfirsttry;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import java.util.HashMap;
import java.util.Map;



import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;


public class New_Profile_Frag extends Fragment {



    String userId;

    TextView  go_to_edit_profile, profileName, username_profile,
            email_profile, blood_type_profile, rh_type_profile,
            phoneNo_profile;


    private final String TAG = this.getClass().getName().toUpperCase();


    private Map<String, String> userMap;
    private String email;
    private String userid;
    private static final String USERS = "users";


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
       // return inflater .inflate(R.layout.new_fragment_profile, container, false);

        View v = inflater.inflate(R.layout.new_fragment_profile, container, false);


//        Intent intent = getIntent();
//        email = intent.getStringExtra("email");
//
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference userRef = rootRef.child(USERS);
//        Log.v("USERID", userRef.getKey());




        profileName = v.findViewById(R.id.profileName);
        username_profile = v.findViewById(R.id.username_profile);
        email_profile = v.findViewById(R.id.profile_email);
        blood_type_profile =v.findViewById(R.id.blood_type_profile);
        phoneNo_profile = v.findViewById(R.id.phone_profile);
        rh_type_profile = v.findViewById(R.id.rh_type_profile);



        // Read from the database
//        userRef.addValueEventListener(new ValueEventListener() {
//            String fname, email, username, phone, bloodType,rhType;
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot keyId: dataSnapshot.getChildren()) {
//                    if (keyId.child("email").getValue().equals(email)) {
//                        fname = keyId.child("fullName").getValue(String.class);
//                        username_profile = keyId.child("username").getValue(String.class);
//                        phoneNo_profile = keyId.child("phone").getValue(String.class);
//                        blood_type_profile = keyId.child("bloodType").getValue(String.class);
//                        rh_type_profile = keyId.child("rhType").getValue(String.class);
//                        break;
//                    }
//                }
//                profileName.setText(fname);
//                email_profile.setText(email);
//                username_profile.setText(username);
//                phoneNo_profile.setText(phone);
//                blood_type_profile.setText(bloodType);
//                rh_type_profile.setText(rhType);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });






        TextView go_to_edit_profile = (TextView) v.findViewById(R.id.go_to_edit_profile);

        go_to_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Edit_profile.class);
                startActivity(intent);
                intent = null;

                //make your toast here
                Toast.makeText(getContext(),"Edit Profile",Toast.LENGTH_LONG).show();
            }
        });

        return v;

    }
}


//                intent.putExtra("fName",profileName.getText().toString());
//                intent.putExtra("email",email_profile.getText().toString());
//                intent.putExtra("phone",phoneNo_profile.getText().toString());
//                intent.putExtra("username",username_profile.getText().toString());
//                intent.putExtra("bloodType",blood_type_profile.getText().toString());
//                intent.putExtra("rhType",rh_type_profile.getText().toString());