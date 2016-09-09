package com.example.nuvolablu.labollettav2;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nuvolablu.labollettav2.dummy.DummyContent;
import com.example.nuvolablu.labollettav2.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class SquadreFragment extends Fragment {

    private View myFragmentView;

    private ArrayList<HomeList> home = new ArrayList<HomeList>();


    public SquadreFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_squadre, container, false);




        // Inflate the layout for this fragment
        return myFragmentView;
    }


}
