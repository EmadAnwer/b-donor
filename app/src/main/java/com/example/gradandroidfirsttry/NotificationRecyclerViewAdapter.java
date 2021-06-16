package com.example.gradandroidfirsttry;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationRecyclerViewAdapter extends RecyclerView.Adapter<NotificationRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "PricesRecyclerVie";
    private final List<Notification> notificationList;
    SharedPreferences pref;
    New_Notifications_Frag context;

    public NotificationRecyclerViewAdapter(List<Notification> notificationList, New_Notifications_Frag context) {
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

        holder.patientNameTextView.setText(notificationList.get(position).getPatientName());
        holder.quantityTextView.setText(notificationList.get(position).getQuantity());
        holder.bloodGroupTextView.setText(notificationList.get(position).getBloodType());
        holder.locationTextView.setText(notificationList.get(position).getLocation());
        holder.timeTextView.setText(notificationList.get(position).getDate().toString());

    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }



    public static class ViewHolder  extends RecyclerView.ViewHolder{
        TextView patientNameTextView,quantityTextView,bloodGroupTextView,locationTextView,timeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientNameTextView= itemView.findViewById(R.id.patientNameTextView);
            quantityTextView= itemView.findViewById(R.id.quantityTextView);
            bloodGroupTextView= itemView.findViewById(R.id.bloodGroupTextView);
            locationTextView= itemView.findViewById(R.id.locationTextView);
            timeTextView= itemView.findViewById(R.id.timeTextView);





        }
    }
}


