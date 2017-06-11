package com.example.hongruzh.jupigowork;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hongruzh on 6/11/17.
 */
public class colorFragment extends DialogFragment {

        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){

            return inflater.inflate(R.layout.color_dialog,null);
        }
}
