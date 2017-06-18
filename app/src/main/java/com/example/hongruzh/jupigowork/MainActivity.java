package com.example.hongruzh.jupigowork;


import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.View;

import android.util.Log;


import com.example.hongruzh.jupigowork.listTab.ListTabView;
import com.example.hongruzh.jupigowork.adpter.SectionsPageAdapter;

import static com.example.hongruzh.jupigowork.R.id.tab1_frag;
import static com.example.hongruzh.jupigowork.R.id.tab_container;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private static TabLayout mTablayout;
    private Tab2Fragment fragment2;
    private ViewPager mViewPager;
    DataBaseHelper myDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create the database
        myDb = new DataBaseHelper(this);

        //Create the fragment Manager
        Log.d(TAG, "onCreate: Starting.");
        fragment2 = new Tab2Fragment();


        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        ListTabView listTabView = new ListTabView();
        setupViewPager(mViewPager);
        mTablayout = (TabLayout) findViewById(R.id.tabs);
        mTablayout.setupWithViewPager(mViewPager);

    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB1");
        adapter.addFragment(new Tab2Fragment(), "TAB2");
        adapter.addFragment(new Tab3Fragment(), "TAB3");
        viewPager.setAdapter(adapter);

    }

    public static void toggleTabBar() {
        if (mTablayout.getVisibility() == View.GONE) {
            mTablayout.setVisibility(View.VISIBLE);
        } else {
            mTablayout.setVisibility(View.GONE);
        }
    }


    public void tab1OnClickListener(View view) {
        //click submit button get all of the list data
        ListTabView listFragment = new ListTabView();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(tab_container, listFragment).commit();
        fragmentManager.beginTransaction().addToBackStack(null);
    }

}
