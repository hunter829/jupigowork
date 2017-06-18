package com.example.hongruzh.jupigowork.bean;

/**
 * Created by hongruzh on 6/12/17.
 */
public class DataWrapper {

    public String id;
    public String NAME;
    public String COLOR;
    public String CODE;

    public DataWrapper(String id,String NAME,String COLOR,String CODE){
        this.id = id;
        this.NAME = NAME;
        this.COLOR = COLOR;
        this.CODE = CODE;
    }

    public static class Item {

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
}
