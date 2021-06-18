package com.example.gradandroidfirsttry;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main_History extends AppCompatActivity {

    RecyclerView history_recyclerView2;
    HistoryRecyclerViewAdapter adapter;
    List<PatientRequest> historyList = new ArrayList<>();
    ProgressBar progressBar4;
    TextView noRequestTextView2;
    DataQueryBuilder queryBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_history);
        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        progressBar4 = findViewById(R.id.progressBar4);
        noRequestTextView2 = findViewById(R.id.noRequestTextView2);
        queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause("ownerId ='"+Backendless.UserService.loggedInUser()+"'");
        //setting historyRecyclerView
        history_recyclerView2 = findViewById(R.id.history_recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        history_recyclerView2.setLayoutManager(layoutManager);
        adapter = new HistoryRecyclerViewAdapter(historyList,this);
        history_recyclerView2.setAdapter(adapter);


        test();


    }
    void test()
    {
        Backendless.Data.of(PatientRequest.class).find(queryBuilder,new AsyncCallback<List<PatientRequest>>() {
            @Override
            public void handleResponse(List<PatientRequest> response) {
                progressBar4.setVisibility(View.GONE);
                historyList.addAll(response);
                if(historyList.size() == 0)
                    noRequestTextView2.setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });


    }
}