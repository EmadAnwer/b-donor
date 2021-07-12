package com.example.gradandroidfirsttry;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Analytics_Reports_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Analytics_Reports_fragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Analytics_Reports_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Analytics_Reports_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Analytics_Reports_fragment newInstance(String param1, String param2) {
        Analytics_Reports_fragment fragment = new Analytics_Reports_fragment();
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
        // return inflater.inflate(R.layout.analytics__reports_fragment, container, false);

        View v = inflater.inflate(R.layout.analytics__reports_fragment, container, false);
        v.setBackgroundColor(Color.WHITE);


        Button ab_pos = (Button) v.findViewById(R.id.AB_positive_report);
        ab_pos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new AB_pos_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "AB + Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button ab_neg = (Button) v.findViewById(R.id.AB_negative_report);
        ab_neg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new AB_neg_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "AB - Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button o_pos = (Button) v.findViewById(R.id.O_positive_report);
        o_pos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new O_pos_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "O + Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button o_neg = (Button) v.findViewById(R.id.O_negative_report);
        o_neg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new O_neg_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "O - Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button b_pos = (Button) v.findViewById(R.id.B_positive_report);
        b_pos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new B_pos_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "B + Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });


        Button b_neg = (Button) v.findViewById(R.id.B_negative_report);
        b_neg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new B_neg_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "B - Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });


        Button a_pos = (Button) v.findViewById(R.id.A_positive_report);
        a_pos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new A_pos_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "A + Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button a_neg = (Button) v.findViewById(R.id.A_negative_report);
        a_neg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.analytic_reports, new A_neg_report_frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "A - Reports Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });


        return v;

    }
}