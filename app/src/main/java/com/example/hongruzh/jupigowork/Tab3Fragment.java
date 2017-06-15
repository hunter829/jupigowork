package com.example.hongruzh.jupigowork;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab3Fragment extends Fragment {

    private static final String TAG = "Tab3Fragment";

    private Button btnTEST;
    DataBaseHelper myDb;
    private ArrayList<Group> gData = null;
    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> lData = null;
    private Context mContext;
    private ExpandableListView exlist_lol;
    private MyBaseExpandableListAdapter myAdapter = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab3_fragment, container, false);
//        btnTEST = (Button) view.findViewById(R.id.btnTEST3);
//
//        btnTEST.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 3", Toast.LENGTH_SHORT).show();
//            }
//        });
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
//            System.out.println("res.getString(1)"+res.getString(1));
//            .append("Id :" + res.getString(0) + "\n");
//            buffer.append("Code :"+ res.getString(1)+"\n");
//            buffer.append("NAME :"+ res.getString(2)+"\n");
//            buffer.append("Color :"+ res.getString(3)+"\n\n");
        }
        mContext = getContext();
        exlist_lol = (ExpandableListView) view.findViewById(R.id.expandableListView);

        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();


        for(DataWrapper daWr:list){
//            System.out.println("daWrname"+ daWr.NAME);
            gData.add(new Group(daWr.NAME));
            lData = new ArrayList<Item>();
            lData.add(new Item(Integer.parseInt(daWr.CODE),"TEST COLOR"));
            iData.add(lData);
        }

        myAdapter = new MyBaseExpandableListAdapter(gData,iData,mContext);
        exlist_lol.setAdapter(myAdapter);


        //为列表设置点击事件
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
