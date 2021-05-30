package com.example.gradandroidfirsttry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class New_Notifications_Frag extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
       // return inflater .inflate(R.layout.new_fragment_setting, container, false);

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.new_fragment_notifications, container, false);

        Button new_home_frag = (Button) v.findViewById(R.id.new_setting_frag);
        new_home_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make your toast here
                Toast.makeText(getContext(),"New Notification Frag",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}


