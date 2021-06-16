package com.example.gradandroidfirsttry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class History_Fragment extends Fragment {

    RecyclerView historyRecyclerView;
    HistoryRecyclerViewAdapter adapter;
    List<History> historyList = new ArrayList<>();


    public History_Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.main_history,container,false);
        //setting historyRecyclerView
        historyRecyclerView = view.findViewById(R.id.historyRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        historyRecyclerView.setLayoutManager(layoutManager);
        adapter = new HistoryRecyclerViewAdapter(historyList,view.getContext());
        historyRecyclerView.setAdapter(adapter);

        if(historyList.size() == 0 )
        {
            test();
        }
        return view;

    }

    void test()
    {
        historyList.add(new History("Emad","A-","done",new Date()));
        historyList.add(new History("Ali","B+","done",new Date()));
        historyList.add(new History("Ahmed","O+","done",new Date()));
        historyList.add(new History("Alaa","A+","done",new Date()));
        historyList.add(new History("Alia","B-","done",new Date()));
        historyList.add(new History("Hoda","O+","done",new Date()));
        historyList.add(new History("Hana","AB+-","done",new Date()));
        historyList.add(new History("Nora","AB-","done",new Date()));


    }
}