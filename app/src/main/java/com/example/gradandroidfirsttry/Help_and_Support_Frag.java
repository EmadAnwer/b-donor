package com.example.gradandroidfirsttry;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
 * Use the {@link Help_and_Support_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Help_and_Support_Frag extends Fragment {

    Button req_for_blood, terms_and_policies, track_request, see_history, change_password, edit_profile;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Help_and_Support_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Help_and_Support_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Help_and_Support_Frag newInstance(String param1, String param2) {
        Help_and_Support_Frag fragment = new Help_and_Support_Frag();
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
        // return inflater.inflate(R.layout.help_and__support_fragment_, container, false);

        View v = inflater.inflate(R.layout.help_and__support_fragment_, container, false);
        v.setBackgroundColor(Color.WHITE);


        req_for_blood = v.findViewById(R.id.q1);
        terms_and_policies = v.findViewById(R.id.terms);
        track_request = v.findViewById(R.id.q2);
        see_history = v.findViewById(R.id.q3);
        change_password = v.findViewById(R.id.q4);
        edit_profile = v.findViewById(R.id.q5);

        terms_and_policies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Terms and Policies!");
                builder.setMessage("1-The Donor's age must Be Between 18 &amp; 65 \n \n 2-Location Must Be accessed " +
                        "\n \n 3-Diseases must not be from the Following : Malaria , Hereditary blood diseases , Diabetics, Sever Anemia , Cancer , Blood Pressure , Heart Diseases " +
                        "\n \n 4-Between every donation process must be 56 Days" );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
//                        Toast.makeText(getActivity(),
//                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();
            }
        });

        req_for_blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("How to make a Request");
                builder.setMessage("1- Click on request button   " +
                        "\n \n 2- Choose new request  " +
                        "\n \n 3- Fill Request Form " +
                        "\n \n 4- After inserting all data click finish  " );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
//                        Toast.makeText(getActivity(),
//                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();
            }
        });

        track_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("How to Track the Requests");
                builder.setMessage("1-Click on request button   " +
                        "\n \n 2- Choose Track request  " +
                        "\n \n 3- Choose which Request you want to track " +
                        "\n \n 4- New page will appear with your request's current status " );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
//                        Toast.makeText(getActivity(),
//                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();
            }
        });

        see_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("How to check your History");
                builder.setMessage("1- Click on History button   " +
                        "\n \n 2- List Of your  Requests Will Appear  " );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
//                        Toast.makeText(getActivity(),
//                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();
            }
        });

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("How to change my password");
                builder.setMessage("1- Click on Setting  button " +
                        "\n \n 2- Choose privacy &amp; security  " +
                        "\n \n 3- Choose change password " +
                        "\n \n 4- After typing new password click on update password button" );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
//                        Toast.makeText(getActivity(),
//                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("How to edit my profile information");
                builder.setMessage("1- Click on Profile button  " +
                        "\n \n 2- Choose privacy &amp; security  " +
                        "\n \n 3- Tap on  Edit Profile " +
                        "\n \n 4- After Editing press on Done " );

                // Setting OK Button
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
//                        Toast.makeText(getActivity(),
//                                "You accept our terms and policies", Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                builder.show();
            }
        });




        ImageView back_from_help_support = (ImageView) v.findViewById(R.id.back_from_help_support);
        back_from_help_support.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.help_support_frag, new New_Setting_Frag());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                Toast.makeText(getActivity(), "Back to Setting" , Toast.LENGTH_LONG).show();

            }

        });

        return v;
    }
}