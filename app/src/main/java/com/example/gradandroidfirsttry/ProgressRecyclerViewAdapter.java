package com.example.gradandroidfirsttry;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ProgressRecyclerViewAdapter extends RecyclerView.Adapter<ProgressRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private final List<PatientRequest> progressRequestsList;
    Context context;
    SharedPreferences pref;

    public ProgressRecyclerViewAdapter(List<PatientRequest> progressRequestsList, Context context) {
        this.progressRequestsList = progressRequestsList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.pPatientNameTextView.setText(progressRequestsList.get(position).getName());
        holder.pQuantityTextView.setText(progressRequestsList.get(position).getQuantity().toString());
        holder.pBloodGroupTextView.setText(progressRequestsList.get(position).getBloodType());
        holder.pRHTypeTextView.setText(progressRequestsList.get(position).getRHType());
        holder.pLocationTextView.setText(progressRequestsList.get(position).getCity());
        holder.nTimeTextView.setText(progressRequestsList.get(position).getCreated().toString());
        holder.trackButton.setOnClickListener(this);
        holder.trackButton.setTag(progressRequestsList.get(position));

    }

    @Override
    public int getItemCount() {
        return progressRequestsList.size();
    }

    @Override
    public void onClick(View v) {
        PatientRequest p = (PatientRequest) v.getTag();
        // pass governorate name and governorate cover within SharedPreferences
        pref = context.getSharedPreferences("requestProgress", MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = pref.edit();

        if(p.getAccepted())
            editor.putString("requestID", "Accepted");
        else
            editor.putString("requestID", p.getObjectId());

        editor.putString("city", p.getCity());
        editor.putString("bloodType", p.getBloodType());
        editor.putString("RH", p.getRHType());
        editor.apply();

        // intent to PlacesActivity
        Intent intent = new Intent(context, ProgressActivity.class);
        context.startActivity(intent);
        intent = null;
    }


    public static class ViewHolder  extends RecyclerView.ViewHolder{
        TextView pPatientNameTextView,pQuantityTextView,pBloodGroupTextView,pRHTypeTextView,pLocationTextView,nTimeTextView;
        Button trackButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pPatientNameTextView =itemView.findViewById(R.id.pPatientNameTextView);
            pQuantityTextView =itemView.findViewById(R.id.pQuantityTextView);
            pBloodGroupTextView =itemView.findViewById(R.id.pBloodGroupTextView);
            pRHTypeTextView =itemView.findViewById(R.id.pRHTypeTextView);
            pLocationTextView =itemView.findViewById(R.id.pLocationTextView);
            nTimeTextView =itemView.findViewById(R.id.nTimeTextView);
            trackButton =itemView.findViewById(R.id.trackButton);
        }
    }
}