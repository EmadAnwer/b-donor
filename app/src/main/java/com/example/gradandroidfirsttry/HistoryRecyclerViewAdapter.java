package com.example.gradandroidfirsttry;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>{
    private final List<PatientRequest> historyList;
    Context context;

    public HistoryRecyclerViewAdapter(List<PatientRequest> historyList, Context context) {
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

        holder.patientNameTextView.setText(historyList.get(position).getName());
        holder.bloodTypeTextView.setText(historyList.get(position).getBloodType());

        if(historyList.get(position).getAccepted())
        {
            holder.statusTextView.setText("Accepted");
            holder.statusTextView.setTextColor(Color.GREEN);
        }
        else {
            if(historyList.get(position).getDeleted())
                holder.statusTextView.setText("Deleted");
            else
                holder.statusTextView.setText("pending");

            holder.statusTextView.setTextColor(Color.RED);

        }

        holder.dateTextView.setText(historyList.get(position).getCreated().toString());

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