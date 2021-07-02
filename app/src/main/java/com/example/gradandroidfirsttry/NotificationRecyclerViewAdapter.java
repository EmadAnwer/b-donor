package com.example.gradandroidfirsttry;

import android.annotation.SuppressLint;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class NotificationRecyclerViewAdapter extends RecyclerView.Adapter<NotificationRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    List<PatientRequest> notificationList;
    Context context;
    SharedPreferences pref;
    TextView noRequestTextView;
    RecyclerView notificationRecyclerView;
    public NotificationRecyclerViewAdapter(List<PatientRequest> notificationList, Context context,TextView noRequestTextView,RecyclerView notificationRecyclerView) {
        this.notificationList = notificationList;
        this.context = context;
        this.noRequestTextView = noRequestTextView;
        this.notificationRecyclerView = notificationRecyclerView;

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
        holder.bloodGroupTextView.setText(notificationList.get(position).getBloodType());
        holder.rhTypeTextView.setText(notificationList.get(position).getRHType());
        holder.locationTextView.setText(notificationList.get(position).getCity());
        holder.hospitalTextView.setText(notificationList.get(position).getHospital());
        holder.phoneNoTextView.setText(notificationList.get(position).getPhone());
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
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String lastDonationDate = formatter.format(date);

            PatientRequest patientRequest = new PatientRequest();
            patientRequest.setObjectId(notificationList.get(p).getObjectId());
            patientRequest.setAccepted(true);
            notificationRecyclerView.setVisibility(View.INVISIBLE);
            noRequestTextView.setText("Thank you for your donation, new requests will appear to you after 56 days from the day of your donation");
            noRequestTextView.setVisibility(View.VISIBLE);

            Backendless.Data.save(patientRequest, new AsyncCallback<PatientRequest>() {
                @Override
                public void handleResponse(PatientRequest response) {
                    pref = context.getSharedPreferences("userData", MODE_PRIVATE);
                    String name = pref.getString("first_name","null");
                    String phone = pref.getString("phone","null");
                    AcceptedRequests acceptedRequest = new AcceptedRequests();
                    acceptedRequest.setDonorName(name);
                    acceptedRequest.setDonorPhone(phone);
                    acceptedRequest.setPatientName(notificationList.get(p).getName());
                    acceptedRequest.setPatientRHType(notificationList.get(p).getRHType());
                    acceptedRequest.setPatientBloodType(notificationList.get(p).getBloodType());
                    acceptedRequest.setPatientHospital(notificationList.get(p).getHospital());
                    acceptedRequest.setPatientPhone(notificationList.get(p).getPhone());
                    acceptedRequest.setCity(notificationList.get(p).getCity());



                    Backendless.Data.of(AcceptedRequests.class).save(acceptedRequest, new AsyncCallback<AcceptedRequests>() {
                        @Override
                        public void handleResponse(AcceptedRequests response) {

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                        }
                    });
                    Backendless.Data.of(BackendlessUser.class).findById(response.getOwnerId(), new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {
                            Backendless.Messaging.sendTextEmail("Your request has been accepted",
                                    "Your request has been accepted. \n\nPlease contact "+name +".\nThe contact number is "+phone, response.getEmail(), new AsyncCallback<MessageStatus>() {
                                        @Override
                                        public void handleResponse(MessageStatus response) {
                                            Log.i("Email", "response: "+response.toString());
                                            notificationList.clear();
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

                    Backendless.Data.of(BackendlessUser.class).findById(Backendless.UserService.loggedInUser(), new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {


                            response.setProperty("lastDonationDate",date);
                            Backendless.Data.of(BackendlessUser.class).save(response, new AsyncCallback<BackendlessUser>() {
                                @Override
                                public void handleResponse(BackendlessUser response) {
                                    pref = context.getSharedPreferences("userData", MODE_PRIVATE);
                                    @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = pref.edit();
                                    editor.putString("lastDonationDate", lastDonationDate);
                                    editor.apply();

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

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });




        }
        else if (v.getId() == R.id.nRejectImageView)
        {
            int p = (int) v.getTag();

            notificationList.remove(p);
            if(notificationList.size() == 0)
                noRequestTextView.setVisibility(View.VISIBLE);
            notifyDataSetChanged();
        }
    }


    public static class ViewHolder  extends RecyclerView.ViewHolder{
        TextView patientNameTextView, quantityTextView, bloodGroupTextView, rhTypeTextView, locationTextView, hospitalTextView, phoneNoTextView, timeTextView;
        ImageView acceptImageView,nRejectImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientNameTextView= itemView.findViewById(R.id.nPatientNameTextView);
            quantityTextView= itemView.findViewById(R.id.nQuantityTextView);
            bloodGroupTextView= itemView.findViewById(R.id.nBloodGroupTextView);
            rhTypeTextView= itemView.findViewById(R.id.nRHTypeTextView);
            locationTextView= itemView.findViewById(R.id.nLocationTextView);
            hospitalTextView= itemView.findViewById(R.id.nHospitalTextView);
            phoneNoTextView= itemView.findViewById(R.id.nPhoneNoTextView);
            timeTextView= itemView.findViewById(R.id.nTimeTextView);
            acceptImageView= itemView.findViewById(R.id.acceptImageView);
            nRejectImageView= itemView.findViewById(R.id.nRejectImageView);





        }
    }
}


