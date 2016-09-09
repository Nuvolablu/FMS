package com.example.nuvolablu.labollettav2;

import android.app.Activity;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityNazioni extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabLayout tabLayout2;
    private ViewPager viewPager;
    private int k;
    private int[] tabIcons = {
            R.drawable.tifo,
            R.drawable.news,
            R.drawable.fsmguru
    };

    private String nazione_selezionata;

    private ArrayList<Nazione> array_nazioni = new ArrayList();
    private ArrayList<Campionato> array_campionato = new ArrayList();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nazioni);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //instazio database ed effettuo le query
        final DataBaseHelper dbh = new DataBaseHelper(getApplicationContext());
        try {
            dbh.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbh.openDataBase();

        array_nazioni = dbh.getNazioni();
        //fine operazioni database

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setOffscreenPageLimit(11);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout2 = (TabLayout) findViewById(R.id.tabs2);

        for(int i = 0 ; i <array_nazioni.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(array_nazioni.get(i).getNome()));
        }
        //setupTabIcons();

        nazione_selezionata = array_nazioni.get(0).getNome();
        array_campionato = dbh.getCampionatoFromNazione(nazione_selezionata);
        loadTab(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                nazione_selezionata = array_nazioni.get(position).getNome();
                array_campionato = dbh.getCampionatoFromNazione(nazione_selezionata);
                loadTab(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void loadTab(int p) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        for (int i = 0; i< array_campionato.size(); i++){
            tabLayout2.addTab(tabLayout2.newTab().setText("A"));
            System.out.println(array_campionato.get(i).getNome());
            adapter.addFragment(new SquadreFragment(), array_campionato.get(i).getNome());
        }

        /*
        switch(p) {
            case 0:


                tabLayout2.addTab(tabLayout2.newTab().setText("A"));
                tabLayout2.addTab(tabLayout2.newTab().setText("B"));
                tabLayout2.addTab(tabLayout2.newTab().setText("C"));

                for (int i = 0; i< array_campionato.size(); i++){
                    tabLayout2.addTab(tabLayout2.newTab().setText("A"));
                    adapter.addFragment(new OneFragment(), array_campionato.get(i).getNome());
                }

                adapter.addFragment(new OneFragment(), "PREDIZIONI");
                adapter.addFragment(new TwoFragment(), "CAZZO");
                adapter.addFragment(new ThreeFragment(), "CULO");

                break;
            case 1:
                tabLayout2.addTab(tabLayout2.newTab().setText("B"));
                tabLayout2.addTab(tabLayout2.newTab().setText("C"));
                tabLayout2.addTab(tabLayout2.newTab().setText("D"));

                adapter.addFragment(new FourFragment(), "TETTE");
                adapter.addFragment(new OneFragment(), "PREDIZIONI");
                adapter.addFragment(new TwoFragment(), "CAZZO");
                break;
            case 2:
                tabLayout2.addTab(tabLayout2.newTab().setText("E"));
                tabLayout2.addTab(tabLayout2.newTab().setText("F"));
                tabLayout2.addTab(tabLayout2.newTab().setText("D"));

                adapter.addFragment(new ThreeFragment(), "CULO");
                adapter.addFragment(new FourFragment(), "TETTE");
                adapter.addFragment(new OneFragment(), "PREDIZIONI");

                break;
        }
        */
        viewPager.setAdapter(adapter);
        tabLayout2.setupWithViewPager(viewPager);
    }





    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }







    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }



        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            notifyDataSetChanged();
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);
        }

        @Override
        public int getItemPosition(Object object){
            return PagerAdapter.POSITION_NONE;
        }

    }
}
