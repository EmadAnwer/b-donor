package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class ProgressActivity extends AppCompatActivity {
    ConstraintLayout confirmedConstraintLayout, acceptedConstraintLayout;
    SharedPreferences pref;
    String requestID;
    DataQueryBuilder queryBuilder = DataQueryBuilder.create();
    String bloodType,address,rh_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        confirmedConstraintLayout= findViewById(R.id.confirmedConstraintLayout);
        acceptedConstraintLayout= findViewById(R.id.acceptedConstraintLayout);

        pref = getSharedPreferences("requestProgress", Context.MODE_PRIVATE);
        requestID = pref.getString("requestID","null");
        bloodType = pref.getString("bloodType","null");
        address = pref.getString("city","null");
        rh_type = pref.getString("RH","null");

        if(requestID.equals("Accepted"))
        {
            confirmedConstraintLayout.setVisibility(View.VISIBLE);
            acceptedConstraintLayout.setVisibility(View.VISIBLE);
        }
        else
            getProgress();

    }

    void getProgress(){

        queryBuilder.setWhereClause("blood_type = '"+bloodType+"' and address= '"+address+"' and rh_type = '"+rh_type+"'"+"and ownerId !='"+Backendless.UserService.loggedInUser()+"'");

        Backendless.Data.of(BackendlessUser.class).getObjectCount(queryBuilder, new AsyncCallback<Integer>() {
            @Override
            public void handleResponse(Integer response) {
                if(response != 0)
                    confirmedConstraintLayout.setVisibility(View.VISIBLE);


            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }
}