package com.example.lenovo.Ku_man_delivery.data.food;

import java.util.List;
import java.util.Observable;

/**
 * Created by lenovo on 6/1/2017.
 */

public abstract class FoodRepository extends Observable {
    public abstract void fetchAllFoods();
    public abstract List<Food> getAllFoods();
}
