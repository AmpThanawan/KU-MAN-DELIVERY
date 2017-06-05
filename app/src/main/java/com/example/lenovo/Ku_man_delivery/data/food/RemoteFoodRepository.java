package com.example.lenovo.Ku_man_delivery.data.food;


import android.content.res.Resources;

import com.example.lenovo.Ku_man_delivery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 6/1/2017.
 */

public class RemoteFoodRepository extends FoodRepository {

    private List<Food> food;

    private static RemoteFoodRepository instance = null;

    public static RemoteFoodRepository getInstance() {
        if (instance == null) {
            instance = new RemoteFoodRepository();
        }
        return instance;
    }

    private RemoteFoodRepository() {
        food = new ArrayList<Food>();
        Resources res = Resources.getSystem();
        food.add(new Food("Noodle",40,"IUP Noodle","IUP 1st floor",R.drawable.noodle));
        food.add(new Food("Tomyumgoog",60,"Thaistyle@KU","Central Canteen",R.drawable.tomyumgoog));
        food.add(new Food("Fired Chicken",70,"Bonchon","IUP 1st floor",R.drawable.chicken));
        food.add(new Food("Pork roast shot",100,"Kamoo IUP","Science Canteen",R.drawable.porkroastshot));
        food.add(new Food("Ribeye Steak",150,"Steak house","Central Canteen",R.drawable.steak));
    }

    @Override
    public void fetchAllFoods() {
        setChanged();
        notifyObservers();
     }

    @Override
    public List<Food> getAllFoods() {
        return food;
    }



}
