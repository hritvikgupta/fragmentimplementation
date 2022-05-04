package com.example.fragmentimplementation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GreenFragment.ItemSelected {

    ArrayList<String> descriptions;
    TextView tvDescription;
    BlueFragment dfrag;
    GreenFragment lv;
    LinearLayout viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descriptions = new ArrayList<String>();
        descriptions.add("You Have Clicked On item 1");
        descriptions.add("You Have Clicked On item 2");


    }

    @Override
    public void OnItemSelected(int index) {

        dfrag = (BlueFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView4);
        dfrag.youvGotMail(descriptions.get(index));


    }
}