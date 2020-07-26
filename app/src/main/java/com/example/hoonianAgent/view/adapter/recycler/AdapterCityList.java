package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.city.VHCity;

import java.util.ArrayList;

public class AdapterCityList extends BaseAdapter<City>{
    public AdapterCityList(ArrayList<City> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHCity(createView(parent, R.layout.cell_cities), recyclerListener);
    }
}
