package com.example.cristi.firstcegeka;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] price;
    String[] descrtiption;

    public ItemAdapter(Context c , String[] i , String[] p , String[] d)
    {
        items = i;
        price = p;
        descrtiption = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_list,null);

        TextView NameTextView = v.findViewById(R.id.NameTextView);
        TextView PriceTextView = v.findViewById(R.id.PriceTextView);
        TextView DescriptionTextView = v.findViewById(R.id.DescriptionTextView);

        String name = items[position];
        String desc = descrtiption[position];
        String cost = price[position];

        NameTextView.setText(name);
        PriceTextView.setText((cost));
        DescriptionTextView.setText(desc);

        return v;
    }
}
