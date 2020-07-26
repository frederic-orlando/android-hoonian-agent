package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.presenter.callback.ClusterRecyclerListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.project.VHCluster;

import java.util.ArrayList;

public class AdapterCluster extends BaseAdapter<Cluster>{
    public AdapterCluster(ArrayList<Cluster> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHCluster(createView(parent, R.layout.row_cluster), recyclerListener, (ClusterRecyclerListener) recyclerListener);
    }
}
