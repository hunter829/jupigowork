package com.example.hongruzh.jupigowork;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hongruzh.jupigowork.bean.MyTabItem;
import com.example.hongruzh.jupigowork.extra.SlidingTabLayout;
import com.example.hongruzh.jupigowork.fragments.Fragment1A;
import com.example.hongruzh.jupigowork.fragments.Fragment1B;

import java.util.ArrayList;

/**
 * Created by hongruzh on 6/10/17.
 */
public class Tab2Fragment extends Fragment {

    private static final String TAG = "Tab2Fragment";
    View view;
    private Button btnTEST;
    TextView nameView;
    TextView codeView;
    TextView colorView;

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private ArrayList<MyTabItem> items;
    private SectionsPageAdapter adapter;


    public Tab2Fragment(){
        items = new ArrayList<>();
        items.add(new MyTabItem("SUB  TAB  ONE", Fragment1A.class));
        items.add(new MyTabItem("SUB  TAB  TWO", Fragment1B.class));
        items.add(new MyTabItem("SUB  TAB  THREE", Fragment1B.class));
        items.add(new MyTabItem("SUB  TAB  FOUR", Fragment1B.class));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab2_fragment, container, false);

        slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.f1slidingTabLayout);
        slidingTabLayout.setDistributeEvenly(true);
        viewPager = (ViewPager) view.findViewById(R.id.f1viewPager);

        viewPager.setAdapter(new TabsAdapter(getChildFragmentManager(), items));
        slidingTabLayout.setViewPager(viewPager);
//        btnTEST = (Button) view.findViewById(R.id.btnTEST2);
//
//        btnTEST.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 2",Toast.LENGTH_SHORT).show();
//            }
//        });
//        Bundle bundle = getArguments();
//        if(bundle!=null)
//        System.out.println(bundle);

//
//        nameView = bundle.getString("NAME");
//        codeView = bundle.getString("CODE");
//        colorView = bundle.getString("COLOR");
//
//        TextView name = (TextView)view.findViewById(R.id.nameView);
//        TextView code = (TextView)view.findViewById(R.id.CodeView);
//        TextView color = (TextView)view.findViewById(R.id.colorView);
//
//        name.setText(nameView);
//        code.setText(codeView);
//        color.setText(colorView);



        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//
//        nameView =  (TextView) view.findViewById(R.id.nameView);
//        String name = ((EditText)getActivity().findViewById(R.id.editText)).getText().toString();
//        nameView.setText(name);
//
//
//    }
}
