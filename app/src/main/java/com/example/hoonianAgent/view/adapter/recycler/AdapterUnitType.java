package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.UnitTypeRecyclerListener;
import com.example.hoonianAgent.view.viewholder.project.VHUnitType;

import java.util.ArrayList;

public class AdapterUnitType extends BaseAdapter<UnitType>{
    private UnitTypeRecyclerListener unitListener;
    public AdapterUnitType(ArrayList<UnitType> listItem, RecyclerListener recyclerListener, UnitTypeRecyclerListener unitListener) {
        super(listItem, recyclerListener);
        this.unitListener = unitListener;
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHUnitType(createView(parent, R.layout.row_unit_type), recyclerListener, unitListener);
    }
}
