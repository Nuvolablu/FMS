package com.example.nuvolablu.labollettav2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TwoFragment extends ListFragment {
    private View myFragmentView;
    private ArrayList<HomeList> home = new ArrayList<HomeList>();
    public TwoFragment() {
        // Required empty public constructor
    }

    public static TwoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragmentView = inflater.inflate(R.layout.fragment_two, container, false);
        ListView listhome = (ListView) myFragmentView.findViewById(R.id.list2);



        HomeList item = new HomeList(R.drawable.results, "risultati");
        home.add(item);
        item = new HomeList(R.drawable.scores, "classifiche");
        home.add(item);
        item = new HomeList(R.drawable.stats, "statistiche");
        home.add(item);
        item = new HomeList(R.drawable.teams, "squadre");
        home.add(item);
        ListviewHomeAdapter listAdapter = new ListviewHomeAdapter(getContext(), home);

        listhome.setAdapter(listAdapter);



        listhome.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 3:
                        Intent intent = new Intent(getActivity(),ActivityNazioni.class);
                        startActivity(intent);
                        break;

                }



            }
        });
        // Inflate the layout for this fragment
        return myFragmentView;
    }

}
