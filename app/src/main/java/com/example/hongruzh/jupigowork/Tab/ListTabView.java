package com.example.hongruzh.jupigowork.Tab;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hongruzh.jupigowork.R;

/**
 * Created by hongruzh on 6/13/17.
 */
public class ListTabView extends Fragment {

    private String[] strs = new String[] {
        "first", "second", "third", "fourth", "fifth"
    };

    private ListView lv;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);
        lv = (ListView) view.findViewById(R.id.listView);;
        try {
            lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return view;
    }
}



