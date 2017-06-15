package com.example.hongruzh.jupigowork.Tab;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hongruzh.jupigowork.DataBaseHelper;
import com.example.hongruzh.jupigowork.DataWrapper;
import com.example.hongruzh.jupigowork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongruzh on 6/13/17.
 */
public class ListTabView extends Fragment {

    //get the data from the database
    DataBaseHelper myDb;
    Cursor res;
    List<String> list;
//  23456
//    public ListTabView(){
//        myDb = new DataBaseHelper(getContext());
//        res = myDb.getAllData();
//        list = new ArrayList<String>();
//        while(res.moveToNext()){
//            list.add(res.getString(0));
//        }
//        strs = (String[])list.toArray(new String[list.size()]);
//    }

//    while(res.moveToNext()){
//        list.add(new DataWrapper(res.getString(0),res.getString(1),res.getString(2),res.getString(3)));
////            .append("Id :" + res.getString(0) + "\n");
////            buffer.append("Name :"+ res.getString(1)+"\n");
////            buffer.append("Color :"+ res.getString(2)+"\n");
////            buffer.append("Code :"+ res.getString(3)+"\n\n");
//    }

//    private String[] strs = new String[] {
//        "first", "second", "third", "fourth", "fifth"
//    };
    private String[] strs;
    private ListView lv;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myDb = new DataBaseHelper(getContext());
        res = myDb.getAllData();
        list = new ArrayList<String>();
        while(res.moveToNext()){
            //get the Name
            list.add(res.getString(2));
        }
        strs = new String[list.size()];
        int j = 0;
        for(int i=list.size()-1;i>=0;i--){
            strs[j++] = list.get(i);
//
        }

        View view = inflater.inflate(R.layout.list_view, container, false);
        lv = (ListView) view.findViewById(R.id.listView);;
        try {
            lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strs));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}



