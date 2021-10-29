package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridviewnangcao_k194111633.R;
import com.example.model.Beer;

import java.util.List;

public class BeerAdapter extends BaseAdapter {

    Activity context;
    int item_layout;
    List<Beer> beerList;

    public BeerAdapter(Activity context, int item_layout, List<Beer> beerList) {
        this.context = context;
        this.item_layout = item_layout;
        this.beerList = beerList;
    }

    @Override
    public int getCount() {
        return beerList.size();
    }

    @Override
    public Beer getItem(int i) {
        return beerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            //Link view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvThumb= view.findViewById(R.id.imvThumb);
            holder.txtName=view.findViewById(R.id.txtName);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        Beer b = beerList.get(i);
        holder.imvThumb.setImageResource(b.getProductThumb());
        holder.txtName.setText(b.getProductName());
        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName;
    }
}