package com.example.gradandroidfirsttry;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class New_Notifications_Frag extends Fragment {
    ProgressBar progressBar3;
    Button button;
    String bloodType,address,rh_type;


    TextView noRequestTextView;
    DataQueryBuilder queryBuilder;
    RecyclerView notificationRecyclerView ;
    NotificationRecyclerViewAdapter adapter;
    ArrayList<PatientRequest> notificationList = new ArrayList<>();
    SharedPreferences pref;


    public New_Notifications_Frag() {
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
       View v = inflater.inflate(R.layout.new_fragment_notifications, container, false);
        pref = this.getActivity().getSharedPreferences("userData", Context.MODE_PRIVATE);
        bloodType = pref.getString("blood_type","null");
        address = pref.getString("address","null");
        rh_type = pref.getString("rh_type","null");

        progressBar3 = v.findViewById(R.id.progressBar3);
        noRequestTextView = v.findViewById(R.id.noRequestTextView);
        queryBuilder = DataQueryBuilder.create();
        //setting governorateRecyclerView
        notificationRecyclerView = v.findViewById(R.id.notificationRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false);
        notificationRecyclerView.setLayoutManager(layoutManager);
        adapter = new NotificationRecyclerViewAdapter(notificationList,v.getContext());
        notificationRecyclerView.setAdapter(adapter);
        getUserNotifications();

       return v;

}

    private void getUserNotifications()
    {

        queryBuilder.setWhereClause("bloodType = '"+bloodType+"' and accepted = False  and city= '"+address+"' and RHType = '"+rh_type+"'"+"and ownerId !='"+Backendless.UserService.loggedInUser()+"'");
        Log.i("asd", "bloodType = '"+bloodType+"' and accepted = False  and city= '"+address+"' and RHType = '"+rh_type+"'");

        Backendless.Data.of(PatientRequest.class).find(queryBuilder,new AsyncCallback<List<PatientRequest>>() {
            @Override
            public void handleResponse(List<PatientRequest> response) {
                progressBar3.setVisibility(View.GONE);
                notificationList.addAll(response);
                if(notificationList.size() == 0)
                    noRequestTextView.setVisibility(View.VISIBLE);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }
}













//        Button new_home_frag = (Button) v.findViewById(R.id.new_setting_frag);
//        new_home_frag.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //make your toast here
//                Toast.makeText(getContext(),"New Notification Frag",Toast.LENGTH_LONG).show();
//            }
//        });

    /*    button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
        return v;
    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_active_24) //set icon for notification
                        .setContentTitle("Notifications Example") //set title of notification
                        .setContentText("This is a notification message")//this is notification message
                        .setAutoCancel(true) // makes auto cancel of notification
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification


        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "This is a notification message");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }*/