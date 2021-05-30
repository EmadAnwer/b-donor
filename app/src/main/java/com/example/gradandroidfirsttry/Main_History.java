package com.example.gradandroidfirsttry;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main_History extends AppCompatActivity {

    RecyclerView history_recyclerView2;
    HistoryRecyclerViewAdapter adapter;
    List<History> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_history);

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
        historyList.add(new History("Emad","A","done",new Date()));
        historyList.add(new History("Ali","B","done",new Date()));
        historyList.add(new History("Ahmed","O","done",new Date()));
        historyList.add(new History("Alaa","A","done",new Date()));
        historyList.add(new History("Alia","B","done",new Date()));
        historyList.add(new History("Hoda","O","done",new Date()));


    }
}