package com.example.hongruzh.jupigowork.Tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongruzh.jupigowork.R;

import java.util.ArrayList;

/**
 * Created by hongruzh on 6/13/17.
 */
public class SingleView extends Fragment {
    private String color;
    private String code;
    private TextView nameText;
    private TextView codeText;
    private TextView colorText;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.single_view, container, false);
        Bundle bundle = getArguments();

        String name = (String) bundle.get("name");
        ArrayList<String> list = (ArrayList<String>) bundle.get(name);


        for(int i=0;i<list.size();i++){
            code= list.get(0);
            color = list.get(1);
        }

        TextView myNameView = (TextView) view.findViewById(R.id.nameView);
        TextView myCodeView = (TextView) view.findViewById(R.id.codeView);
        TextView myColorView = (TextView) view.findViewById(R.id.colorView);

        myNameView.setText("Name: "+name);
        myCodeView.setText("Code: " + code);
        myColorView.setText("Color: "+ color);

        return view;
    }
}
