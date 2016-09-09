package com.example.nuvolablu.labollettav2;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Finestra2 extends AppCompatActivity {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        moveTaskToBack(true);
        return true;
    }
    // POTATO 
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finestra2);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(), "PREDIZIONI");
        adapter.addFragment(new TwoFragment(), "CAMPIONATI");
        adapter.addFragment(new ThreeFragment(), "ULTRAS");
        adapter.addFragment(new FourFragment(), "NEWS & TIPS");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
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
