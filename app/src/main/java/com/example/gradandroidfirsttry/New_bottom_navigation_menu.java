package com.example.gradandroidfirsttry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class New_bottom_navigation_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_bottom_navigation_menu);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        BottomNavigationView bottomNav = findViewById(R.id.new_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.new_navigation_home:
                            selectedFragment = new New_Home_Frag();
                           break;
                        case R.id.new_navigation_profile:
                            selectedFragment = new New_Profile_Frag();
                            break;
                        case R.id.new_navigation_request:
                            selectedFragment = new New_Request_Frag();
                            break;
                        case R.id.new_navigation_notifications:
                            selectedFragment = new New_Notifications_Frag();
                            break;
                        case R.id.new_navigation_setting:
                            selectedFragment = new New_Setting_Frag();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.new_fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

}