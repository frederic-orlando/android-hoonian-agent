package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.referred.Referred;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.project.VHReferred;

import java.util.ArrayList;

public class AdapterReferred extends BaseAdapter<Referred>{
    public AdapterReferred(ArrayList<Referred> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHReferred(createView(parent, R.layout.row_referred), recyclerListener);
    }
}
