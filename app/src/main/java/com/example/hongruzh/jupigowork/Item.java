package com.example.hongruzh.jupigowork;

/**
 * Created by Jay on 2015/9/25 0025.
 */
public class Item {

    private String code;
    private String color;


    public Item() {
    }

    public Item(String code,String color) {

        this.color = color;
        this.code = code;
    }

    public String getCode() {
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
