package com.example.hongruzh.jupigowork;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.hongruzh.jupigowork.Tab.ListTabView;
import com.example.hongruzh.jupigowork.fragments.WheelFragment;
import com.example.hongruzh.jupigowork.global.MyApplication;

import static com.example.hongruzh.jupigowork.R.id.tab1_frag;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";
    public String select;
    private static Button btnTEST;
    private Button colorBtn;
    EditText editName,editCode,editColor;
    private Button button2;
    DataBaseHelper myDb;
    public Context mContext;
    public FragmentManager fm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        myDb = new DataBaseHelper(getContext());

        editName = (EditText) view.findViewById(R.id.editText);
        editCode = (EditText) view.findViewById(R.id.editText2);
        //Test here actually did not write the color
        editColor = (EditText) view.findViewById(R.id.editText2);
        button2 =(Button) view.findViewById(R.id.button2);


        fm = getFragmentManager();

        addData();
        btnTEST = (Button) view.findViewById(R.id.testBt);

        select = ((MyApplication) getActivity().getApplication()).getSomeVariable();
        System.out.println("select"+ select);

        return view;
    }

    // Static method to change the button text,call in WheelView when the done button was pressed
    public static void setButtonText(String select){
        btnTEST.setText(select);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnTEST = (Button) view.findViewById(R.id.testBt);


        try{
            if(select!=null||!select.equals("")) {
                btnTEST.setText(select);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addData() {
            //button2 is submit button
            button2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if ((!editName.getText().toString().equals("")) && (!btnTEST.getText().toString().equals("SELECT COLOR")) && (!editCode.getText().toString().equals(""))) {
                        //insert the data
                        boolean isInserted = myDb.insertData(editName.getText().toString(), editCode.getText().toString(), btnTEST.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                        FragmentManager fm = getFragmentManager();
                        ListTabView listFragment = new ListTabView();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(tab1_frag, new ListTabView()).commit();
                    }
                    else{
                        Toast.makeText(getContext(), "Please Fill The Blank", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        public void changeBtn(View view){
            btnTEST = (Button) view.findViewById(R.id.testBt);
            btnTEST.setText(((MyApplication) getActivity().getApplication()).getSomeVariable());
        }
    }

