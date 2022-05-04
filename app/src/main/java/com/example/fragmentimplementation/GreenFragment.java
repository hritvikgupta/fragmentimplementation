package com.example.fragmentimplementation;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class GreenFragment extends Fragment implements ListAdapter {

    ListView list;
    String [] arr;
    LayoutInflater inflater;
    ViewGroup container;
    private ItemSelected activtiy;
    BlueFragment dfreg;
    String item;
    int pos;


    interface ItemSelected{
        void OnItemSelected(int index);
    }
    public GreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return  inflater.inflate(R.layout.fragment_green2, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = view.findViewById(R.id.list);
        arr = getResources().getStringArray(R.array.pieces);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,arr);
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //item = (String) list.getItemAtPosition(i);
                pos = i;

                //In order to access the main activity layout from here
                //without importing it we use this.getActivity()
                //therefore this.getActivity().findViewById() will run similarly.


                activtiy.OnItemSelected(0);
                Toast.makeText(getActivity(), "You Clicked On: " + i,Toast.LENGTH_SHORT).show();
                activtiy.OnItemSelected(i);
                //dfreg.youvGotMail(i);

            }
        });


    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       return null;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return pos;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activtiy = (ItemSelected) getActivity();

    }
    public void clickitems(){
        activtiy.OnItemSelected(pos);

    }




}