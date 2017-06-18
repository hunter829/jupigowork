package com.example.hongruzh.jupigowork;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.hongruzh.jupigowork.adpter.MyBaseExpandableListAdapter;
import com.example.hongruzh.jupigowork.bean.DataWrapper;
import com.example.hongruzh.jupigowork.bean.Group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";

    private Button btnTEST;
    DataBaseHelper myDb;
    private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<DataWrapper.Item>> iData = null;
    private ArrayList<DataWrapper.Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab3_fragment, container, false);
        myDb = new DataBaseHelper(getContext());

        //get all the data from the database;
        Cursor res = myDb.getAllData();
        if(res.getCount()==0){
           return view;
        }
        //DataWrapper is the wrapper data class including the id,name,color and code
        List<DataWrapper> list = new ArrayList<DataWrapper>();
        while(res.moveToNext()){
            //insert id Name COlOR and CODE
            list.add(new DataWrapper(res.getString(0),res.getString(2),res.getString(3),res.getString(1)));
        }
        mContext = getContext();
        exlist_lol = (ExpandableListView) view.findViewById(R.id.expandableListView);

        //prepare the data for expandable list view
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<DataWrapper.Item>>();

        Collections.reverse(list);
        for(DataWrapper daWr:list){
            gData.add(new Group(daWr.NAME));
            lData = new ArrayList<DataWrapper.Item>();
            lData.add(new DataWrapper.Item("Color: "+daWr.COLOR,"Code: "+ daWr.CODE));
            iData.add(lData);
        }

        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        exlist_lol.setAdapter(myAdapter);


        //set onclick event for items
        exlist_lol.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(mContext, "You Clicked：" + iData.get(groupPosition).get(childPosition).getColor(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });



        return view;
}


}
