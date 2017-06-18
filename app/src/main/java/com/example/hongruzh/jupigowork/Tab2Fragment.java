package com.example.hongruzh.jupigowork;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hongruzh.jupigowork.adpter.SectionsPageAdapter;
import com.example.hongruzh.jupigowork.adpter.TabsAdapter;
import com.example.hongruzh.jupigowork.bean.MyTabItem;
import com.example.hongruzh.jupigowork.extra.SlidingTabLayout;
import com.example.hongruzh.jupigowork.fragments.FragmentA;
import com.example.hongruzh.jupigowork.fragments.FragmentB;
import com.example.hongruzh.jupigowork.fragments.FragmentC;

import java.util.ArrayList;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab2Fragment extends Fragment {

    private static final String TAG = "Tab2Fragment";
    View view;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private ArrayList<MyTabItem> mItems;
    private SectionsPageAdapter adapter;


    public Tab2Fragment(){
        mItems = new ArrayList<>();
        mItems.add(new MyTabItem("SUB TAB ONE", FragmentA.class));
        mItems.add(new MyTabItem("SUB TAB TWO", FragmentB.class));
        mItems.add(new MyTabItem("SUB TAB THREE", FragmentC.class));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab2_fragment, container, false);

        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.f1slidingTabLayout);
        slidingTabLayout.setDistributeEvenly(true);
        viewPager = (ViewPager) view.findViewById(R.id.f1viewPager);

        viewPager.setAdapter(new TabsAdapter(getChildFragmentManager(), mItems));
        slidingTabLayout.setViewPager(viewPager);
        return view;
    }
}
