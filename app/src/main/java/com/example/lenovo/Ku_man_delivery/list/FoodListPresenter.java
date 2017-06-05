package com.example.lenovo.Ku_man_delivery.list;


import com.example.lenovo.Ku_man_delivery.data.food.FoodRepository;
import com.example.lenovo.Ku_man_delivery.data.food.Food;
import com.example.lenovo.Ku_man_delivery.data.food.FoodRepository;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by lenovo on 6/1/2017.
 */

public class FoodListPresenter implements Observer {

    private FoodListView view;
    private FoodRepository repository;

    ArrayList<Food> food;

    public FoodListPresenter(FoodRepository repo, FoodListView view) {
        this.repository = repo;
        this.view = view;
        food = new ArrayList<>();
    }

    public void initialize() {
        repository.addObserver(this);
        repository.fetchAllFoods();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == repository) {
            food = new ArrayList<Food>(repository.getAllFoods());
            view.updateFood(food);

        }
    }
}
