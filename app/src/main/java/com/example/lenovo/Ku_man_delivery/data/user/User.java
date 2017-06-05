package com.example.lenovo.Ku_man_delivery.data.user;


import com.example.lenovo.Ku_man_delivery.data.food.Food;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/4/2017.
 */

public class User {

    private ArrayList<Food> cart;
    private ArrayList<Food> myFoodList;

    public User() {

        cart = new ArrayList<Food>();
        myFoodList = new ArrayList<Food>();
    }



    public ArrayList<Food> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Food> cart) { this.cart = cart; }

    public ArrayList<Food> getMyBookList() {
        return myFoodList;
    }

    public void addFood(Food food) {
        cart.add(food);
    }

    public double getTotalPrice() {
        double price = 0;
        for(Food food : cart) {
            price += food.getPrice();
        }
        return price;
    }

    public boolean clearCart() {

            myFoodList.addAll(cart);
            cart.clear();
            return true;

    }
}
