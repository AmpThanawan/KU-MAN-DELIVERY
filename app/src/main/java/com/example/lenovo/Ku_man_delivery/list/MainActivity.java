package com.example.lenovo.Ku_man_delivery.list;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Menu;
import com.example.lenovo.Ku_man_delivery.R;

import com.example.lenovo.Ku_man_delivery.data.food.FoodRepository;
import com.example.lenovo.Ku_man_delivery.data.food.RemoteFoodRepository;
import com.example.lenovo.Ku_man_delivery.data.food.Food;
import com.example.lenovo.Ku_man_delivery.data.food.FoodAdapter;

import android.content.Intent;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FoodListView {

    FoodListPresenter presenter;
    public static FoodAdapter book;

    private ListView bookListView;

    public static ArrayList<Food> myCart = new ArrayList<Food>();

    EditText text;

    public MainActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodRepository repository = RemoteFoodRepository.getInstance();

        bookListView = (ListView) findViewById(R.id.book_grid);
        presenter = new FoodListPresenter(repository, this);
        presenter.initialize();

        bookListView.setOnItemClickListener(onItemClickListener);
        search();

    }

    public void updateFood(ArrayList<Food> books) {
        book = new FoodAdapter(books, MainActivity.this);
        bookListView.setAdapter(book);
        Log.d("aaaa","ampamp");
    }


        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);

                builder.setTitle("Confirm Add to Cart...");

                builder.setMessage("Are you sure you want to this food in your cart?");

                builder.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "Complete", Toast.LENGTH_SHORT)
                                        .show();
                                myCart.add((Food) bookListView.getItemAtPosition(position));
                            }
                        });
                builder.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "Cancel", Toast.LENGTH_SHORT)
                                        .show();
                                dialog.cancel();
                            }
                        });

                builder.show();
            }
        };

    public void search() {

        text = (EditText) findViewById(R.id.search);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s == null) {
                    presenter.initialize();
                } else {
                    searchTextTitle(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void searchTextTitle(String text) {
        ArrayList<Food> foods = new ArrayList<Food>();
        for (Food food : presenter.food) {
            if ((food.getTitle().toLowerCase().contains(text.toLowerCase())) || food.getRestuarant().toLowerCase().contains(text)) {
                foods.add(food);
            }
        }
        updateFood(foods);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cart_menu:
                Intent cartIntent = new Intent(this, CartActivity.class);
                this.startActivity(cartIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
