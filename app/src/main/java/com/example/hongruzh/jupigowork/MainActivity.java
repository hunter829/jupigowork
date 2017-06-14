package com.example.hongruzh.jupigowork;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.hongruzh.jupigowork.Tab.ListTabView;

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
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//                FragmentManager fm = getSupportFragmentManager();
//                //listTabView is a fragment
//                ListTabView listTabView = new ListTabView();
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fm.beginTransaction().replace(R.id.tab1_frag,listTabView);
//
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();




    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB1");
        adapter.addFragment(new Tab2Fragment(), "TAB2");
        adapter.addFragment(new Tab3Fragment(), "TAB3");
        viewPager.setAdapter(adapter);
    }


}
