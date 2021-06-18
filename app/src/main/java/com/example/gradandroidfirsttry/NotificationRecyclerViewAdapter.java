package com.example.gradandroidfirsttry;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationRecyclerViewAdapter extends RecyclerView.Adapter<NotificationRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    List<PatientRequest> notificationList;
    Context context;

    public NotificationRecyclerViewAdapter(List<PatientRequest> notificationList, Context context) {
        this.notificationList = notificationList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.patientNameTextView.setText(notificationList.get(position).getName());
        holder.quantityTextView.setText(notificationList.get(position).getQuantity().toString());
        holder.bloodGroupTextView.setText(notificationList.get(position).getBloodType());
        holder.rhTypeTextView.setText(notificationList.get(position).getRHType());
        holder.locationTextView.setText(notificationList.get(position).getCity());
        holder.timeTextView.setText(notificationList.get(position).getCreated().toString());
        holder.acceptImageView.setOnClickListener(this);
        holder.nRejectImageView.setOnClickListener(this);
        holder.nRejectImageView.setTag(position);
        holder.acceptImageView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.acceptImageView)
        {
            int p = (int) v.getTag();
            Toast.makeText(context, "accepted TODO", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.nRejectImageView)
        {
            int p = (int) v.getTag();

            notificationList.remove(p);
            notifyDataSetChanged();
        }
    }


    public static class ViewHolder  extends RecyclerView.ViewHolder{
        TextView patientNameTextView,quantityTextView,bloodGroupTextView,rhTypeTextView,locationTextView,timeTextView;
        ImageView acceptImageView,nRejectImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientNameTextView= itemView.findViewById(R.id.nPatientNameTextView);
            quantityTextView= itemView.findViewById(R.id.nQuantityTextView);
            bloodGroupTextView= itemView.findViewById(R.id.nBloodGroupTextView);
            rhTypeTextView= itemView.findViewById(R.id.nRHTypeTextView);
            locationTextView= itemView.findViewById(R.id.nLocationTextView);
            timeTextView= itemView.findViewById(R.id.nTimeTextView);
            acceptImageView= itemView.findViewById(R.id.acceptImageView);
            nRejectImageView= itemView.findViewById(R.id.nRejectImageView);





        }
    }
}


