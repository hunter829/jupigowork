package com.example.hongruzh.jupigowork;


import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.View;

import android.util.Log;


import com.example.hongruzh.jupigowork.Tab.ListTabView;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

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
//        rtyui
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

         // 数据集合

//        mViewPager.addView(listTabView.getView());

//                FragmentManager fm = getSupportFragmentManager();
//                //listTabView is a fragment
//                ListTabView listTabView = new ListTabView();
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fm.beginTransaction().replace(R.id.tab1_frag,listTabView);
//
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit()

    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB1");
        adapter.addFragment(new Tab2Fragment(), "TAB2");
        adapter.addFragment(new Tab3Fragment(), "TAB3");


        viewPager.setAdapter(adapter);

    }


//    public void tab1OnClickListener(View view) {
//        boolean isInserted = myDb.insertData(editName.getText().toString(),
//        ListTabView listFragment = new ListTabView();
//        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.tab1_frag, listFragment).commit();
//        fragmentManager.beginTransaction().addToBackStack(null);
//
//    }



}
