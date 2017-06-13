package com.example.hongruzh.jupigowork;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        addData();



        return view;
    }

    public void addData(){
        //button2 is submit button
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                boolean isInserted = myDb.insertData(editName.getText().toString(),editCode.getText().toString(),null);

                if(isInserted==true){
                    Toast.makeText(getContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
