package com.example.gradandroidfirsttry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class New_Home_Frag extends Fragment {


    public New_Home_Frag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.new_fragment_homee, container, false);

        View v = inflater.inflate(R.layout.new_fragment_home, container, false);


        ImageView eng_ads_website = (ImageView) v.findViewById(R.id.eng_ads_website);
        eng_ads_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.brmsonline.com/blog/wellness/healthcare/2018/benefits-of-blood-donation#:~:text=Health%20benefits%20of%20donating%20blood%20include%20good%20health%20and%20reduced,cardiovascular%20health%20and%20reducing%20obesity."));
                startActivity(intent);

                //make your toast here
                Toast.makeText(getContext(),"English Ads website",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}
