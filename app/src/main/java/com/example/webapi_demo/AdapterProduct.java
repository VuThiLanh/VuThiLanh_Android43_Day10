package com.example.webapi_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterProduct extends BaseAdapter {
    List<Product> products ;

    public AdapterProduct(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_product,parent,false);
        TextView tvID = view.findViewById(R.id.tvID);
        TextView tvPublisherID = view.findViewById(R.id.tvPublisherID);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvID.setText(String.valueOf(products.get(position).getId()));
        tvPublisherID.setText(String.valueOf(products.get(position).getPublisherID()));
        tvTitle.setText(products.get(position).getTitle());
        return view;
    }
}
