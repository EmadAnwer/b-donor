package com.example.gradandroidfirsttry;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New_Notifications_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New_Notifications_Frag extends Fragment {

    Button button;

    RecyclerView notificationRecyclerView ;
    NotificationRecyclerViewAdapter adapter;
    List<Notification> notificationList = new ArrayList<>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New_Notifications_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New_Notifications_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static New_Notifications_Frag newInstance(String param1, String param2) {
        New_Notifications_Frag fragment = new New_Notifications_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      // return inflater.inflate(R.layout.new_fragment_notifications, container, false);

        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.new_fragment_notifications, container, false);

        //setting governorateRecyclerView
        test();
        notificationRecyclerView = v.findViewById(R.id.notificationRecyclerView);
        adapter = new NotificationRecyclerViewAdapter(notificationList, this);
        notificationRecyclerView.setAdapter(adapter);


       return v;

}

    private void test()
    {
        notificationList.add(new Notification("Fatma","40ml","A+","Cairo",new Date()));
        notificationList.add(new Notification("Ahmed","30ml","B+","Cairo",new Date()));
        notificationList.add(new Notification("Ali","20ml","AB-","Cairo",new Date()));
        notificationList.add(new Notification("Reem","40ml","B-","Cairo",new Date()));
        notificationList.add(new Notification("Noura","50ml","AB+","Cairo",new Date()));
        notificationList.add(new Notification("Salma","30ml","A-","Cairo",new Date()));
        notificationList.add(new Notification("Sara","20ml","O-","Cairo",new Date()));
        notificationList.add(new Notification("Khalid","20ml","O+","Cairo",new Date()));

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