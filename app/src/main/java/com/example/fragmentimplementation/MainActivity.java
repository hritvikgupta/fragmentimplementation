package com.example.fragmentimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

/*
Ths solution to the unanimously closing of the app is wriiten here
// use the fragment manger in the main to pass the data from one
fragment to another
https://www.tutorialspoint.com/how-to-pass-data-from-one-fragment-to-another-fragment-in-android#:~:text=How%20to%20pass%20data%20from%20one%20fragment%20to%20another%20fragment%20in%20android%3F,-AndroidMobile%20Development&text=Step%201%20%E2%88%92%20Create%20a%20new,xml.
 */
public class MainActivity extends AppCompatActivity implements GreenFragment.ItemSelected {

    String [] descriptions;
    TextView tvDescription;
    BlueFragment dfrag;
    GreenFragment lv;
    LinearLayout viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descriptions = getResources().getStringArray(R.array.descriptions);



    }

    @Override
    public void OnItemSelected(int index) {

        dfrag = (BlueFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView4);
        dfrag.youvGotMail(descriptions[index]);


    }
}