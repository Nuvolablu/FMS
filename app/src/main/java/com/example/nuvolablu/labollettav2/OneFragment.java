package com.example.nuvolablu.labollettav2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class OneFragment extends ListFragment {
    private View myFragmentView;

    private ArrayList<HomeList> home = new ArrayList<HomeList>();


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_one, container, false);
        ListView listhome = (ListView) myFragmentView.findViewById(R.id.list1);



        HomeList item = new HomeList(R.drawable.fsmpred, "analisi match");
        home.add(item);
        item = new HomeList(R.drawable.corner, "l'angolo di mimmo");
        home.add(item);
        item = new HomeList(R.drawable.fsmguru, "guru compare");
        home.add(item);
        ListviewHomeAdapter listAdapter = new ListviewHomeAdapter(getContext(), home);


        listhome.setAdapter(listAdapter);


        listhome.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0 : Toast.makeText(getActivity(), "MAMMETA", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(),ActivityNazioni.class);
                        startActivity(intent);
                        break;
                    case 1: Toast.makeText(getActivity(), "SORETA", Toast.LENGTH_SHORT).show();
                        break;
                    case 2: Toast.makeText(getActivity(), "PAT'T", Toast.LENGTH_SHORT).show();
                        break;

                }



            }
        });
        // Inflate the layout for this fragment
        return myFragmentView;

    }




}

