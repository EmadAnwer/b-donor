package com.example.gradandroidfirsttry;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class New_Profile_Frag extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
       // return inflater .inflate(R.layout.new_fragment_profile, container, false);

        View v = inflater.inflate(R.layout.new_fragment_profile, container, false);

        TextView go_to_edit_profile = (TextView) v.findViewById(R.id.go_to_edit_profile);

        go_to_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Edit_profile.class);
                startActivity(intent);
                intent = null;

                //make your toast here
                Toast.makeText(getContext(),"Edit Profile",Toast.LENGTH_LONG).show();
            }
        });

        return v;

    }
}
