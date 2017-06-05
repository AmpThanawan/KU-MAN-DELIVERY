package com.example.lenovo.Ku_man_delivery.data.food;

import android.graphics.drawable.Drawable;

/**
 * Created by lenovo on 6/1/2017.
 */

public class Food {


    private String title;
    private double price;
    private String restuarant ;
    private String location ;
    private int d ;


    public Food(String title, double price, String restuarant, String location, int d ) {

        this.title = title;
        this.price = price;
        this.restuarant = restuarant;
        this.location = location ;
        this.d = d ;



    }

    public String getRestuarant() {
        return restuarant;
    }

    public String getLocation() {
        return location;
    }

    public int getImgURL() {
        return d;
    }



    public String toString() {
        return title + " (" + price + ")" ;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }




}
