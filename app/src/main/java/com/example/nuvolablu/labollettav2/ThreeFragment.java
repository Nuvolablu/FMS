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


public class ThreeFragment extends Fragment {
    private View myFragmentView;

    private ArrayList<HomeList> home = new ArrayList<HomeList>();

    public ThreeFragment() {
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

        myFragmentView = inflater.inflate(R.layout.fragment_three, container, false);
        ListView listhome = (ListView) myFragmentView.findViewById(R.id.ListFragThree);



        HomeList item = new HomeList(R.drawable.refree, "chat");
        home.add(item);
        item = new HomeList(R.drawable.tifo, "squadre del cuore");
        home.add(item);
        item = new HomeList(R.drawable.quizzone, "il quizzone");
        home.add(item);
        ListviewHomeAdapter listAdapter = new ListviewHomeAdapter(getContext(), home);


        listhome.setAdapter(listAdapter);
        return myFragmentView;
    }
}
