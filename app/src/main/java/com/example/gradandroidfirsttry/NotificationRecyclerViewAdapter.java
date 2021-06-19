package com.example.gradandroidfirsttry;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.messaging.MessageStatus;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class NotificationRecyclerViewAdapter extends RecyclerView.Adapter<NotificationRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    List<PatientRequest> notificationList;
    Context context;
    SharedPreferences pref;

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
            PatientRequest patientRequest = new PatientRequest();
            patientRequest.setObjectId(notificationList.get(p).getObjectId());
            patientRequest.setAccepted(true);
            notificationList.remove(p);
            notifyDataSetChanged();

            Backendless.Data.save(patientRequest, new AsyncCallback<PatientRequest>() {
                @Override
                public void handleResponse(PatientRequest response) {

                    Backendless.Data.of(BackendlessUser.class).findById(response.getOwnerId(), new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            pref = context.getSharedPreferences("userData", MODE_PRIVATE);
                            String name = pref.getString("first_name","null");
                            String phone = pref.getString("phone","null");
                            Backendless.Messaging.sendTextEmail("Your request has been accepted",
                                    "Your request has been accepted. \n\nPlease contact "+name +".\nThe contact number is "+phone, response.getEmail(), new AsyncCallback<MessageStatus>() {
                                        @Override
                                        public void handleResponse(MessageStatus response) {
                                            Log.i("Email", "response: "+response.toString());
                                        }

                                        @Override
                                        public void handleFault(BackendlessFault fault) {
                                            Log.i("Email", "handleFault: "+fault.toString());
                                        }
                                    });
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                        }
                    });



                }

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });


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


