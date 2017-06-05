package com.example.lenovo.Ku_man_delivery.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.lenovo.Ku_man_delivery.R;
import com.example.lenovo.Ku_man_delivery.data.customer.Customer;

import java.util.ArrayList;

/**
 * Created by thanawan on 6/5/2017 AD.
 */

public class CustomerActivity extends AppCompatActivity {




    public static ArrayList<Customer> customers = new ArrayList<Customer>();;
    private EditText fname;
    private EditText lname;
    private EditText loca ;

    String first ;
    String last ;
    String location ;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);








    }




    public void submitCustomer(View view) {

        fname = (EditText)findViewById(R.id.fill_first);
        first = fname.getText().toString();
        lname = (EditText)findViewById(R.id.fill_last);
        last = lname.getText().toString();
        loca = (EditText)findViewById(R.id.fill_locate);
        location = loca.getText().toString();

        customers.add(new Customer(first,last,location));
        Log.d("check",customers.get(0).getName()+"");
        Intent cartIntent = new Intent(this,ShowinfoActivity.class);
        this.startActivity(cartIntent);
    }
}
