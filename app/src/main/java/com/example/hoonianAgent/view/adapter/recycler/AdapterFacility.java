package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.project.VHFacility;

import java.util.ArrayList;

public class AdapterFacility extends BaseAdapter<Facility>{
    public AdapterFacility(ArrayList<Facility> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHFacility(createView(parent, R.layout.row_facility), recyclerListener);
    }
}
