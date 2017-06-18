package com.example.hongruzh.jupigowork.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hongruzh.jupigowork.MainActivity;
import com.example.hongruzh.jupigowork.R;
import com.example.hongruzh.jupigowork.Tab1Fragment;
import com.example.hongruzh.jupigowork.adpter.MyWheelAdpter;
import com.example.hongruzh.jupigowork.global.MyApplication;
import com.wx.wheelview.common.WheelData;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;

/**
 * Created by hongruzh on 6/15/17.
 */

public class WheelFragment extends Fragment {

    private WheelView myWheelView;
    private String color;
    private Button button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.wheel_view, container, false);

//        Log.i("WheelFragment.onCreate", "enter onCreate");
        myWheelView = (WheelView) view.findViewById(R.id.my_wheelview);
        myWheelView.setWheelAdapter(new MyWheelAdpter(getActivity()));
        myWheelView.setWheelSize(5);
        myWheelView.setWheelData(createArrays());
        myWheelView.setSelection(2);
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        style.selectedTextColor = Color.RED;
        myWheelView.setStyle(style);
        myWheelView.setWheelClickable(false);

        button = (Button)view.findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                color = (String)myWheelView.getSelectionItem();
                ((MyApplication) getActivity().getApplication()).setSomeVariable(color);
                System.out.println("this is test"+((MyApplication) getActivity().getApplication()).getSomeVariable());
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.hide(WheelFragment.this);
                Tab1Fragment.setButtonText(color);
                ft.addToBackStack("hide fragment3").commit();
                Tab1Fragment.toggleSubmitButtonVisibilty();
            }
        });

        return view;
    }

    private ArrayList<String> createArrays() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("red");
        list.add("orange");
        list.add("yellow");
        list.add("green");
        list.add("blue");
        list.add("purple");
        return list;
    }

}
