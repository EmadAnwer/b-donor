package com.example.gradandroidfirsttry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;


public class New_Profile_Frag extends Fragment {

    DataQueryBuilder queryBuilder;
    String sprofileName, suserName, semail, sbloodType, srh_type, sphoneNo, slocation;

    SharedPreferences pref;
    public static final String TAG = "TAG";


    TextView go_to_edit_profile, nprofileName, nusername_profile,
            nemail_profile, nblood_type_profile, nrh_type_profile,
            nphoneNo_profile, nloaction;


    //    String userId;
//    private final String TAG = this.getClass().getName().toUpperCase();
//
//
//    private Map<String, String> userMap;
//    private String email;
//    private String userid;
//    private static final String USERS = "users";


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        // return inflater .inflate(R.layout.new_fragment_profile, container, false);

        View v = inflater.inflate(R.layout.new_fragment_profile, container, false);


        BackendlessUser user = null;

        pref = this.getActivity().getSharedPreferences("userData", Context.MODE_PRIVATE);

//        SharedPreferences.Editor editor = pref.edit();


        nprofileName = v.findViewById(R.id.profileName);
        nusername_profile = v.findViewById(R.id.username_profile);
        nemail_profile = v.findViewById(R.id.profile_email);
        nblood_type_profile = v.findViewById(R.id.blood_type_profile);
        nrh_type_profile = v.findViewById(R.id.rh_type_profile);
        nphoneNo_profile = v.findViewById(R.id.phone_profile);
        nloaction = v.findViewById(R.id.location_profile);


        sprofileName = pref.getString("first_name", String.valueOf(nprofileName));
        suserName = pref.getString("user_name", String.valueOf(nusername_profile));
        semail = pref.getString("email", String.valueOf(nemail_profile));
        sbloodType = pref.getString("blood_type", String.valueOf(nblood_type_profile));
        srh_type = pref.getString("rh_type", String.valueOf(nrh_type_profile));
        sphoneNo = pref.getString("phone", String.valueOf(nphoneNo_profile));
        slocation = pref.getString("address", String.valueOf(nloaction));

        nprofileName.setText(sprofileName);
        nusername_profile.setText(suserName);
        nemail_profile.setText(semail);
        nblood_type_profile.setText(sbloodType);
        nrh_type_profile.setText(srh_type);
        nphoneNo_profile.setText(sphoneNo);
        nloaction.setText(slocation);

//        user.setProperty("first_name",nprofileName);
//        user.setProperty("phone",nphoneNo_profile);
//        user.setProperty("user_name",nusername_profile);
//        user.setProperty("blood_type",nblood_type_profile);
//        user.setProperty("rh_type",nrh_type_profile);
//        user.setProperty("email", nemail_profile);



        TextView go_to_edit_profile = (TextView) v.findViewById(R.id.go_to_edit_profile);

        go_to_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Edit_profile.class);
                startActivity(intent);
                intent = null;

                //make your toast here
                Toast.makeText(getContext(), "Edit Profile", Toast.LENGTH_LONG).show();
            }
        });

        return v;

    }
}


//
//        queryBuilder = DataQueryBuilder.create();


//        getUserProfile();

//        Intent intent = getIntent();
//        email = intent.getStringExtra("email");
//
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference userRef = rootRef.child(USERS);
//        Log.v("USERID", userRef.getKey());


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



//
//    @Override
//    public void handleResponse(BackendlessUser response) {
//            Toast.makeText(getContext(), "Profile", Toast.LENGTH_LONG).show();
//        SharedPreferences.Editor editor = pref.edit();
//
//        editor.putString("nprofileName", response.getProperty("first_name").toString());
//        editor.putString("nusername_profile", response.getProperty("username").toString());
//        editor.putString("nemail_profile", response.getProperty("email").toString());
//        editor.putString("nphoneNo_profile", response.getProperty("phone").toString());
//        editor.putString("nblood_type_profile", response.getProperty("blood_type").toString());
//        editor.putString("nrh_type_profile", response.getProperty("rh_type").toString());
//        editor.apply();
//
//
//    }
//
//    @Override
//    public void handleFault(BackendlessFault fault) {
//
//        Log.i(TAG, "handleFault: "+fault.toString());
//        Toast.makeText(getContext(), "error"+fault.toString() ,Toast.LENGTH_LONG).show();
//
//    }

//    private void getUserProfile()
//    {
//
//        queryBuilder.setWhereClause("nprofileName = '"+profileName+"' and accepted = False  and nusername_profile= '"+userName+"' and nemail_profile = '"+email+"'and nblood_type_profile = '"+bloodType+"'and nrh_type_profile = '"+rh_type+"'and nphoneNo_profile = '"+phoneNo+"'");
//        Log.i("asd", "nprofileName = '"+profileName+"' and accepted = False  and nusername_profile= '"+userName+"' and nemail_profile = '"+email+"'and nblood_type_profile = '"+bloodType+"'and nrh_type_profile = '"+rh_type+"'and nphoneNo_profile = '"+phoneNo+"'");
//
//        Backendless.Data.of(PatientRequest.class).find(queryBuilder,new AsyncCallback<List<PatientRequest>>() {
//            @Override
//            public void handleResponse(List<PatientRequest> response) {
//
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



//                intent.putExtra("fName",profileName.getText().toString());
//                intent.putExtra("email",email_profile.getText().toString());
//                intent.putExtra("phone",phoneNo_profile.getText().toString());
//                intent.putExtra("username",username_profile.getText().toString());
//                intent.putExtra("bloodType",blood_type_profile.getText().toString());
//                intent.putExtra("rhType",rh_type_profile.getText().toString());