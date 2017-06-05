package com.example.lenovo.Ku_man_delivery.data.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.Ku_man_delivery.R;

import java.util.ArrayList;

/**
 * Created by thanawan on 6/5/2017 AD.
 */

public class CustomerAdapter extends BaseAdapter implements CustomerView {

    private ArrayList<Customer> customer ;
    private LayoutInflater inflater ;
    private Context con ;


    private TextView first ;
    private TextView last;
    private TextView locate;

    public CustomerAdapter(ArrayList<Customer> customer , Context context){
        this.customer = customer ;
        this.con = context ;
    }


    @Override
    public int getCount() {
        return customer.size();
    }

    @Override
    public Object getItem(int position) {
        return customer.get(position);
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
            layout = inflater.inflate(R.layout.show,null);
        }


        first =(TextView) layout.findViewById(R.id.name_user);
        last = (TextView) layout.findViewById(R.id.lastname_user);
        locate = (TextView) layout.findViewById(R.id.locate_user);


        setCusName(position);
        setCusLastName(position);
        setCusLocation(position);


        return layout ;

    }

    @Override
    public void setCusName(int local) {
        first.setText(customer.get(local).getName());
    }

    @Override
    public void setCusLastName(int local) {
        last.setText(customer.get(local).getLastname());
    }

    @Override
    public void setCusLocation(int locall) {
     locate.setText(customer.get(locall).getLocation());
    }
}
