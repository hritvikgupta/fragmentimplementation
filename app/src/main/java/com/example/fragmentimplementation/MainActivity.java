package com.example.fragmentimplementation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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

        //Here we have created a second same activity.xml file in the new directory
        // the new directory is not visible here but rather is in the resource folder in finder
        //Here two different ids given the xml files in which we have given portrait a portrait id
        // and vice versa

        //if phone is in portrait mode then the detailfragment is hiden and only list fragment is viewed
        // and in landscape mode we have both of them visible

        if(findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager man = this.getSupportFragmentManager();
            man.beginTransaction()
                    .hide(man.findFragmentById(R.id.fragmentContainerView4))
                    .show(man.findFragmentById(R.id.fragmentContainerView3))
                    .commit();
        }
        if(findViewById(R.id.layout_land) != null)
        {
            FragmentManager man = this.getSupportFragmentManager();
            man.beginTransaction()
                    .show(man.findFragmentById(R.id.fragmentContainerView4))
                    .show(man.findFragmentById(R.id.fragmentContainerView3))
                    .commit();
        }




    }

    @Override
    public void OnItemSelected(int index) {

        dfrag = (BlueFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView4);
        dfrag.youvGotMail(descriptions[index]);

        // Here if the phone is in portrait mode we will not been able to see the
        //description as we hide it in above so as to make it run we need to again show
        //it while clicking on to the list fragment therefore we hide list fragment
        //after clicking item on the list we will able to detail fragment that
        // we are showing
        if(findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager man = this.getSupportFragmentManager();
            man.beginTransaction()
                    .show(man.findFragmentById(R.id.fragmentContainerView4))
                    .addToBackStack(null)//After return to listfragment after back from description fragment rather closing down the app
                    .hide(man.findFragmentById(R.id.fragmentContainerView3))
                    .commit();
        }


    }
}