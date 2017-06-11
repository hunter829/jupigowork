package com.example.hongruzh.jupigowork;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab1Fragment extends Fragment {

    private static final String TAG = "Tab1Fragment";

    private Button btnTEST;
    private Button colorBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTEST);
        colorBtn = (Button) view.findViewById(R.id.colorBtn);//R.id..colorBtn);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
            }
        });

        colorBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                showColorTypes(view);

            }
        });


        return view;
    }

    public void showColorTypes(View v){

        FragmentManager manager = getFragmentManager();
        colorFragment colorDialog = new colorFragment();
        colorDialog.show(manager, "myDialog");
    }

}
