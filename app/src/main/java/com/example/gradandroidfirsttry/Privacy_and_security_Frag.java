package com.example.gradandroidfirsttry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Privacy_and_security_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Privacy_and_security_Frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Privacy_and_security_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Privacy_and_security_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Privacy_and_security_Frag newInstance(String param1, String param2) {
        Privacy_and_security_Frag fragment = new Privacy_and_security_Frag();
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
        //return inflater.inflate(R.layout.fragment_privacy_and_security_, container, false);

        View v = inflater.inflate(R.layout.fragment_privacy_and_security_, container, false);
        v.setBackgroundColor(Color.WHITE);


        ImageView back_from_privacy = (ImageView) v.findViewById(R.id.back_from_privacy);
        back_from_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),New_Setting_Frag.class);
                startActivity(intent);
                intent = null;

                //make your toast here
                Toast.makeText(getContext(),"Back to Setting",Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }
}