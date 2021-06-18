package com.example.gradandroidfirsttry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Track_request_items extends AppCompatActivity {


    ProgressBar progressBar7;
    TextView noRequestTextView7;
    DataQueryBuilder queryBuilder;
    RecyclerView trackRequestRecyclerView;
    ProgressRecyclerViewAdapter adapter;
    List<PatientRequest> progressRequestsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_request_items_activity_);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        progressBar7 = findViewById(R.id.progressBar7);
        noRequestTextView7 = findViewById(R.id.noRequestTextView7);
        queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause("ownerId ='"+ Backendless.UserService.loggedInUser()+"'");
        //setting historyRecyclerView
        trackRequestRecyclerView = findViewById(R.id.trackRequestRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        trackRequestRecyclerView.setLayoutManager(layoutManager);
        adapter = new ProgressRecyclerViewAdapter(progressRequestsList,this);
        trackRequestRecyclerView.setAdapter(adapter);
        test();
    }


    void test()
    {
        queryBuilder.setPageSize(100);
        Backendless.Data.of(PatientRequest.class).find(queryBuilder,new AsyncCallback<List<PatientRequest>>() {
            @Override
            public void handleResponse(List<PatientRequest> response) {
                progressBar7.setVisibility(View.GONE);
                progressRequestsList.addAll(response);
                if(progressRequestsList.size() == 0)
                    noRequestTextView7.setVisibility(View.VISIBLE);

                adapter.notifyDataSetChanged();


            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });


    }
}




