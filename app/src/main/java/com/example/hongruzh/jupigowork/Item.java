package com.example.hongruzh.jupigowork;

/**
 * Created by Jay on 2015/9/25 0025.
 */
public class Item {

    private int code;
    private String color;


    public Item() {
    }

    public Item(int code,String color) {

        this.color = color;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }

    public void setiId(int iId) {
        this.code = code;
    }

    public void setColor(String Color) {
        this.color = Color;
    }
}
