package com.example.gradandroidfirsttry;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Rating_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Rating_Frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Rating_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Rating_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Rating_Frag newInstance(String param1, String param2) {
        Rating_Frag fragment = new Rating_Frag();
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
        //return inflater.inflate(R.layout.fragment_rating_, container, false);

        View v = inflater.inflate(R.layout.fragment_rating_, container, false);
        v.setBackgroundColor(Color.WHITE);

        Button done_rating = (Button) v.findViewById(R.id.done_rating);
        done_rating.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.navigate_to_Rating, new New_Setting_Frag());
                fragmentTransaction.commit();

                Toast.makeText(getActivity(), "Done Rating" , Toast.LENGTH_LONG).show();

            }

        });
        

        ImageView back_from_rating = (ImageView) v.findViewById(R.id.back_from_rating);
        back_from_rating.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.navigate_to_Rating, new New_Setting_Frag());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Toast.makeText(getActivity(), "Back to Setting" , Toast.LENGTH_LONG).show();

            }

        });

        return v;

    }
}