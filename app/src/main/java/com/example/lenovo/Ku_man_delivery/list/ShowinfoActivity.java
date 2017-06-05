package com.example.lenovo.Ku_man_delivery.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.Ku_man_delivery.R;
import com.example.lenovo.Ku_man_delivery.data.customer.CustomerAdapter;

import static com.example.lenovo.Ku_man_delivery.list.CustomerActivity.customers;

/**
 * Created by thanawan on 6/5/2017 AD.
 */

public class ShowinfoActivity extends AppCompatActivity {

    private TextView fname;
    private TextView lname;
    private TextView loca ;

    String first ;
    String last ;
    String location ;

    ListView customerList ;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showinfo);


        Log.d("CAT" ,customers.size()+"");
        customerList = (ListView) findViewById(R.id.cus);
        CustomerAdapter cartAdapt = new CustomerAdapter(customers, ShowinfoActivity.this);
        customerList.setAdapter(cartAdapt);




    }


    public void BackToMain(View view) {

            Intent cartIntent = new Intent(this,MainActivity.class);
            this.startActivity(cartIntent);
            customers.clear();


    }
}
