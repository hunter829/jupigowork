package com.example.hongruzh.jupigowork;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.hongruzh.jupigowork.listTab.ListTabView;
import com.example.hongruzh.jupigowork.fragments.WheelFragment;
import com.example.hongruzh.jupigowork.global.MyApplication;

import static android.R.color.black;
import static com.example.hongruzh.jupigowork.R.id.tab1_frag;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";
    public String select;
    private static Button mColorSelectButton;
    EditText mEditName;
    EditText mEditCode;
    private static Button mSubmitButton;
    DataBaseHelper myDb;
    public Context mContext;
    public FragmentManager fm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        myDb = new DataBaseHelper(getContext());

        mEditName = (EditText) view.findViewById(R.id.editText);
        mEditCode = (EditText) view.findViewById(R.id.editText2);
        //Test here actually did not write the color
        mSubmitButton =(Button) view.findViewById(R.id.submitBtn);
        mColorSelectButton = (Button) view.findViewById(R.id.testBt);
        mSubmitButton.setEnabled(false);

        mSubmitButton.setVisibility(View.VISIBLE);
        mColorSelectButton.setVisibility(View.VISIBLE);

        System.out.println("hahahahh");
        System.out.println(mSubmitButton.getText().toString().equals("SELECT COLOR"));


        fm = getFragmentManager();

        addData();
        select = ((MyApplication) getActivity().getApplication()).getSomeVariable();

        mEditCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0&&!mEditName.getText().toString().equals(""))
                    mSubmitButton.setEnabled(true);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEditName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(s.length() != 0&&!mEditCode.getText().toString().equals(""))
                        mSubmitButton.setEnabled(true);

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    // Static method to change the button text,call in WheelView when the done button was pressed
    public static void setButtonText(String select){
        mColorSelectButton.setText(select);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mColorSelectButton = (Button) view.findViewById(R.id.testBt);

        //mSubmitButton is submit button
        mSubmitButton = (Button) view.findViewById(R.id.submitBtn);

        //select color
        mColorSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Test Wheel view", Toast.LENGTH_LONG).show();
                android.support.v4.app.FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                final WheelFragment wheelFragment = new WheelFragment();
                ft.replace(tab1_frag,wheelFragment);

                ft.addToBackStack(null).commit();

                toggleSubmitButtonVisibilty();


            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Tab1Fragment.onResume","onResume");
        System.out.println("hahahhah"+mSubmitButton.getText().toString());
    }

    @Override
    public void onStop() {
        super.onStop();
        mColorSelectButton.setVisibility(View.INVISIBLE);
        Log.i("Tab1Fragment.onStop()","onStop()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mColorSelectButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Tab1Fragment.onPause()","onPause()");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i("Tab1Fragment.onStart()","onStart()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Tab1Fragment.onCreate","onCreate");
    }




    public void addData() {
            //mSubmitButton is submit button
            //insert the data
            mSubmitButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if ((!mEditName.getText().toString().equals("")) && (!mColorSelectButton.getText().toString().equals("SELECT COLOR")) && (!mEditCode.getText().toString().equals(""))) {
                        //insert the data

                        boolean isInserted = myDb.insertData(mEditName.getText().toString(), mEditCode.getText().toString(), mColorSelectButton.getText().toString());
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
                        mSubmitButton.setVisibility(View.INVISIBLE);
                        mColorSelectButton.setVisibility(View.INVISIBLE);

                    }
                    else{
                        Toast.makeText(getContext(), "Please Fill The Blank", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        public void changeBtn(View view){
            mColorSelectButton = (Button) view.findViewById(R.id.testBt);
            mColorSelectButton.setText(((MyApplication) getActivity().getApplication()).getSomeVariable());
        }

        public static void toggleSubmitButtonVisibilty() {
            if (mSubmitButton.getVisibility() == View.GONE) {
                mSubmitButton.setVisibility(View.VISIBLE);
            } else {
                mSubmitButton.setVisibility(View.GONE);
            }
        }
    }

