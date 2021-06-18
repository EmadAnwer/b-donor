package com.example.gradandroidfirsttry;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Change_password_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Change_password_Frag extends Fragment {

    EditText currentPasswordEditText,newPasswordEditText,reTypeNewPasswordEditText;
    Button passwordButton,cancelButton;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Change_password_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Change_password_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Change_password_Frag newInstance(String param1, String param2) {
        Change_password_Frag fragment = new Change_password_Frag();
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
       // return inflater.inflate(R.layout.change_password_fragment_, container, false);

        View v = inflater.inflate(R.layout.change_password_fragment_, container, false);
        v.setBackgroundColor(Color.WHITE);


        currentPasswordEditText = v.findViewById(R.id.currentPasswordEditText);
        newPasswordEditText = v.findViewById(R.id.newPasswordEditText);
        reTypeNewPasswordEditText = v.findViewById(R.id.reTypeNewPasswordEditText);
        passwordButton= v.findViewById(R.id.passwordButton);
        cancelButton= v.findViewById(R.id.cancelButton);
        ImageView back_from_changepassword = v.findViewById(R.id.back_from_changepassword);


        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPasswordEditText.getText().toString().isEmpty() ||
                        newPasswordEditText.getText().toString().isEmpty() ||
                        reTypeNewPasswordEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(), "Please complete all data", Toast.LENGTH_SHORT).show();
                    return ;
                }

                else if (! newPasswordEditText.getText().toString().equals(reTypeNewPasswordEditText.getText().toString())){
                    Toast.makeText(getActivity(), "password and re-type password is not match", Toast.LENGTH_SHORT).show();
                    return ;}

                else {

                    FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.change_password_frag, new Privacy_and_security_Frag());
                    fragmentTransaction.commit();

                    // Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();

                    Toast.makeText(getActivity(), "password change successfully", Toast.LENGTH_SHORT).show();
                    return ;}

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.change_password_frag, new Privacy_and_security_Frag());
                fragmentTransaction.commit();


                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();

            }
        });


        back_from_changepassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.change_password_frag, new Privacy_and_security_Frag());
                fragmentTransaction.commit();

            }

        });

        return v;
    }
}