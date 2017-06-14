package com.example.hongruzh.jupigowork.Tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hongruzh.jupigowork.R;

/**
 * Created by hongruzh on 6/13/17.
 */
public class SingleView extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.single_view, container, false);

        return view;
    }
}
