package com.example.hongruzh.jupigowork.listTab;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hongruzh.jupigowork.DataBaseHelper;
import com.example.hongruzh.jupigowork.R;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hongruzh on 6/13/17.
 */
public class ListTabView extends Fragment {

    //get the data from the database
    DataBaseHelper myDb;
    Cursor res;
    List<String> list;
    HashMap<String,ArrayList<String>> nameMap;
    private String[] mStrs;
    private ListView lv;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myDb = new DataBaseHelper(getContext());
        res = myDb.getAllData();
        list = new ArrayList<String>();
        nameMap = new HashMap<>();
        while (res.moveToNext()) {
            //get the Name
            //insert id Name COlOR and CODE
            //list.add(new DataWrapper(res.getString(0),res.getString(2),res.getString(3),res.getString(1)));
            String Name = res.getString(2);
            String CODE = res.getString(1);
            String COLOR = res.getString(3);
            ArrayList<String> resList = new ArrayList<>();
            resList.add(CODE);
            resList.add(COLOR);
            list.add(Name);
            nameMap.put(Name,resList);
        }
        mStrs = new String[list.size()];
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            mStrs[j++] = list.get(i);
        }

        View view = inflater.inflate(R.layout.list_view, container, false);
        lv = (ListView) view.findViewById(R.id.listView);
        try {
            lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mStrs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        lv = (ListView) view.findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String name = ((TextView) view).getText().toString();
                SingleView singleFragment = new SingleView();
                Bundle bundle = new Bundle();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //name has it's code and color get from the nameMap
                singleFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.test1,singleFragment);
                bundle.putStringArrayList(name,nameMap.get(name));
                bundle.putString("name",name);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}



