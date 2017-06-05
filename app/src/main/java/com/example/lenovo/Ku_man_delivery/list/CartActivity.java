package com.example.lenovo.Ku_man_delivery.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.Ku_man_delivery.R;

import com.example.lenovo.Ku_man_delivery.data.user.User;
import com.example.lenovo.Ku_man_delivery.data.food.Food;
import com.example.lenovo.Ku_man_delivery.data.food.FoodAdapter;

import java.util.ArrayList;

import static com.example.lenovo.Ku_man_delivery.list.MainActivity.myCart;

/**
 * Created by lenovo on 6/4/2017.
 */

public class CartActivity extends AppCompatActivity {
    private TextView totalPriceText;
    double total;



    User user = new User();

    EditText fund;
    Button purchase;
    ListView cartListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        totalPriceText = (TextView) findViewById(R.id.num_total_price);
        totalPriceText.setText("" + setTotalPrice(MainActivity.myCart));


        cartListView = (ListView) findViewById(R.id.cart_list);
        FoodAdapter cartAdapt = new FoodAdapter(myCart, CartActivity.this);
        cartListView.setAdapter(cartAdapt);





    }



    public double setTotalPrice(ArrayList<Food> cartList) {
        for (Food book : cartList) {
            total += book.getPrice();
        }
        return total;
    }


    public void Payment(View view) {
        Log.d("KUMAN","wowowow");
        Intent cartIntent = new Intent(this,CustomerActivity.class);
        this.startActivity(cartIntent);
    }
}
