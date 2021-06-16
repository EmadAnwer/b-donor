package com.example.gradandroidfirsttry;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import android.widget.ListView;
import java.util.ArrayList;
import androidx.fragment.app.FragmentActivity;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class New_Request_Frag extends Fragment {

    //ListView request_history;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        // return inflater .inflate(R.layout.new_fragment_request, container, false);

        View v = inflater.inflate(R.layout.new_fragment_request, container, false);

        ImageView new_request_icon = (ImageView) v.findViewById(R.id.new_request_icon);

        new_request_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Patient_Request.class);
                startActivity(intent);
                intent = null;

                //make your toast here
                Toast.makeText(getContext(),"New Make new Request",Toast.LENGTH_LONG).show();
            }
        });

        ImageView history_icon = (ImageView) v.findViewById(R.id.history_icon);

        history_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Main_History.class);
                startActivity(intent);
                intent = null;

                //make your toast here
                Toast.makeText(getContext(),"New Make new Request",Toast.LENGTH_LONG).show();
            }
        });

        ImageView track_request_icon = (ImageView) v.findViewById(R.id.track_request_icon);

            track_request_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Track_request_items.class);
                startActivity(intent);
                intent = null;



//                public void OrderPlaced(View v ) {
//                    //startActivity(new Intent(MainActivity.this,TrackActivity.class));
//                    String orderStatus="0";
//                    Intent intent=new Intent(getActivity(),Track_request_items.class);
//                    intent.putExtra("orderStatus",orderStatus);
//                    startActivity(intent);
//                }
//
//                public void OrderConfirmed(View v) {
//                    String orderStatus="1";
//                    Intent intent=new Intent(getActivity(),Track_request_items.class);
//                    intent.putExtra("orderStatus",orderStatus);
//                    startActivity(intent);
//                }
//
//
//                public void OrderPickup(View v) {
//                    String orderStatus="3";
//                    Intent intent=new Intent(getActivity(),Track_request_items.class);
//                    intent.putExtra("orderStatus",orderStatus);
//                    startActivity(intent);
//                }
//

                //make your toast here
                Toast.makeText(getContext(),"Track the Request",Toast.LENGTH_LONG).show();
            }
        });


        return v;

    }

}



/*
        request_history=findViewById(R.id.history_icon);
        ArrayList<String>request=new ArrayList<>();
        FragmentActivity fragment1 = new FragmentActivity();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_req_frame,
                fragment1).commit();
 */




//                public void OrderProcessed(View v) {
//                    String orderStatus="2";
//                    Intent intent=new Intent(getActivity(),Track_request_items.class);
//                    intent.putExtra("orderStatus",orderStatus);
//                    startActivity(intent);
//                }