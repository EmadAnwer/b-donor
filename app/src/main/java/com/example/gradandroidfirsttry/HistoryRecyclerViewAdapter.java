package com.example.gradandroidfirsttry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>{
    private final List<History> historyList;
    Context context;

    public HistoryRecyclerViewAdapter(List<History> historyList, Context context) {
        this.historyList = historyList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.patientNameTextView.setText(historyList.get(position).getPatientName());
        holder.bloodTypeTextView.setText(historyList.get(position).getBloodType());
        holder.statusTextView.setText(historyList.get(position).getStatus());
        holder.dateTextView.setText(historyList.get(position).getDate().toString());


    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }



    public static class ViewHolder  extends RecyclerView.ViewHolder{
        TextView patientNameTextView,statusTextView,dateTextView,bloodTypeTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientNameTextView =itemView.findViewById(R.id.patientNameTextView);
            bloodTypeTextView =itemView.findViewById(R.id.bloodTypeTextView);
            statusTextView =itemView.findViewById(R.id.statusTextView);
            dateTextView =itemView.findViewById(R.id.dateTextView);

        }
    }
}