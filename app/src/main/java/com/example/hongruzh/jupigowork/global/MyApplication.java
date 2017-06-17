package com.example.hongruzh.jupigowork.global;

import android.app.Application;

/**
 * Created by hongruzh on 6/16/17.
 */

public class MyApplication extends Application {

    private String someVariable;

    public String getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(String someVariable) {
        this.someVariable = someVariable;
    }

}
