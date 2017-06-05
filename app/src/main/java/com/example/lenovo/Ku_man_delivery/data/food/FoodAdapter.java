package com.example.lenovo.Ku_man_delivery.data.food;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.Ku_man_delivery.R;
import com.example.lenovo.Ku_man_delivery.list.MainActivity;

import java.util.ArrayList;



/**
 * Created by thanawan on 6/4/2017 AD.
 */

public class FoodAdapter extends BaseAdapter implements FoodView{

    private ArrayList<Food> foodInfo ;
    private LayoutInflater inflater ;
    private Context con ;

    private ImageView foodImg ;
    private TextView foodName ;
    private TextView Restaurant ;
    private TextView price ;
    private TextView Location ;

    public FoodAdapter(ArrayList<Food> foodInfo ,Context context){
        this.foodInfo = foodInfo ;
        this.con = context ;
    }

    @Override
    public int getCount() {
        return foodInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return foodInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if(convertView == null){
            inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.food,null);
        }

        foodImg =(ImageView) layout.findViewById(R.id.food_img);
        foodName =(TextView) layout.findViewById(R.id.food_name);
        price = (TextView) layout.findViewById(R.id.food_pirce);
        Restaurant = (TextView) layout.findViewById(R.id.food_res);
        Location = (TextView) layout.findViewById(R.id.food_Location);

        setFoodImg(position);
        setFoodName(position);
        setFoodPrice(position);
        setFoodRestaurant(position);
        setLocation(position);

        return layout ;
    }


    @Override
    public void setFoodImg(int local) {

        foodImg.setImageResource(foodInfo.get(local).getImgURL());

    }

    @Override
    public void setFoodName(int local) {

        foodName.setText(foodInfo.get(local).getTitle());
    }

    @Override
    public void setFoodPrice(int local) {

        price.setText(foodInfo.get(local).getPrice()+"");
    }

    @Override
    public void setFoodRestaurant(int locall) {
        Restaurant.setText(foodInfo.get(locall).getRestuarant());
    }

    @Override
    public void setLocation(int locall) {

        Location.setText(foodInfo.get(locall).getLocation());
    }
}
