package com.example.hongruzh.jupigowork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
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

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";

    private Button btnTEST;
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
//        btnTEST = (Button) view.findViewById(R.id.btnTEST);
//
//        btnTEST.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show();
//            }
//        });

        editName = (EditText) view.findViewById(R.id.editText);
        editCode = (EditText) view.findViewById(R.id.editText2);
        //Test here actually did not write the color
        editColor = (EditText) view.findViewById(R.id.editText2);
        button2 =(Button) view.findViewById(R.id.button2);
        Spinner spinner = (Spinner)view.findViewById(R.id.spinner);

        fm = getFragmentManager();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        addData();




        return view;
    }



    public void addData() {
        //button2 is submit button



            button2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
////                Fragment tab_fragment2 = new Tab2Fragment();
////                Bundle bundle = new Bundle();
////                FragmentTransaction transection = getFragmentManager().beginTransaction();
////                bundle.putString("Name", editName.getText().toString());
////                bundle.putString("Code",editCode.getText().toString());
////                bundle.putString("Color","green");
////                tab_fragment2.setArguments(bundle);
////
////                transection.replace(R.id.tab1_frag, tab_fragment2);
////                transection.isAddToBackStackAllowed();
////                transection.addToBackStack(null);
////                transection.commit();
//
////                Intent intent = new Intent();
////                intent.putExtra("Name",editName.getText().toString());
////                intent.putExtra("Code",editCode.getText().toString());
////                intent.putExtra("Color","green");
////                //send the data from Tab1 to Tab2
////                intent.setClass(mContext,Tab2Fragment.class);
////                startActivity(intent);
//
////                Fragment fragment = new Tab2Fragment();
////                FragmentManager fm = getActivity().getSupportFragmentManager();
////                FragmentTransaction ft = fm.beginTransaction();
////                ft.replace(R.id.content_frame, fragment);
////                ft.commit();
//
//
//
                    if ((!editName.getText().toString().equals("")) && (!editColor.getText().toString().equals("")) && (!editCode.getText().toString().equals(""))) {
                        button2.setBackgroundColor(Color.BLACK);
                        boolean isInserted = myDb.insertData(editName.getText().toString(), editCode.getText().toString(), null);

                        if (isInserted == true) {
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                        FragmentManager fm = getFragmentManager();
//                Fragment listTabView = new ListTabView();
                        ListTabView listFragment = new ListTabView();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.tab1_frag, new ListTabView()).commit();
                    }
                    else{
                        Toast.makeText(getContext(), "Please Fill The Blank", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

