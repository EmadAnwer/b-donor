package com.example.gradandroidfirsttry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New_Setting_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New_Setting_Frag extends Fragment {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New_Setting_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New_Setting_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static New_Setting_Frag newInstance(String param1, String param2) {
        New_Setting_Frag fragment = new New_Setting_Frag();
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
        // return inflater.inflate(R.layout.new_fragment_setting, container, false);

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.new_fragment_setting, container, false);
        v.setBackgroundColor(Color.WHITE);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


       Button logout = (Button) v.findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(getActivity(),Login_page.class);
//                startActivity(intent);
//                intent = null;

                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getActivity(),Login_page.class));
//                finish();

                //make your toast here
                Toast.makeText(getContext(),"Logout",Toast.LENGTH_LONG).show();
            }
        });

//        public void logout(View view) {
//            FirebaseAuth.getInstance().signOut();//logout
//            startActivity(new Intent(getApplicationContext(),Login.class));
//            finish();
//        }

        Button rating_btn = (Button) v.findViewById(R.id.rating_btn);
        rating_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.setting_page_frg, new Rating_Frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "Rating Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button privacy_security_btn = (Button) v.findViewById(R.id.privacy_security_btn);
        privacy_security_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.setting_page_frg, new Privacy_and_security_Frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "Privacy and Security Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });


        Button about_btn = (Button) v.findViewById(R.id.about_btn);
        about_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.setting_page_frg, new About_Frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "About Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });

        Button help_and_support_btn = (Button) v.findViewById(R.id.help_support_btn);
        help_and_support_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.setting_page_frg, new Help_and_Support_Frag());
                fragmentTransaction.addToBackStack(null);
                Toast.makeText(getActivity(), "Help and Support Fragment" , Toast.LENGTH_LONG).show();
                fragmentTransaction.commit();


            }

        });


        return v;

    }
}