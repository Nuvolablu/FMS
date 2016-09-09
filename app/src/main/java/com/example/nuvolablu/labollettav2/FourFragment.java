package com.example.nuvolablu.labollettav2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class FourFragment extends Fragment {

    private View myFragmentView;

    private ArrayList<HomeList> home = new ArrayList<HomeList>();

    public FourFragment() {
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
        myFragmentView = inflater.inflate(R.layout.fragment_four, container, false);
        ListView listhome = (ListView) myFragmentView.findViewById(R.id.ListFragFour);



        HomeList item = new HomeList(R.drawable.quizzone, "ultime dai campi");
        home.add(item);
        item = new HomeList(R.drawable.teams, "notizie da fsm");
        home.add(item);
        ListviewHomeAdapter listAdapter = new ListviewHomeAdapter(getContext(), home);


        listhome.setAdapter(listAdapter);
        return myFragmentView;
    }
}
