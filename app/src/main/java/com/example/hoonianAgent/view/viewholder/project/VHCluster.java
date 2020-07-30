package com.example.hoonianAgent.view.viewholder.project;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.ClusterRecyclerListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.UnitTypeRecyclerListener;
import com.example.hoonianAgent.view.adapter.recycler.AdapterUnitType;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationVertical;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHCluster extends BaseViewHolder<Cluster> {
    private ClusterRecyclerListener clusterListener;
    private TextView clusterNameLbl;
    private TextView totalUnitLbl;
    private TextView soldLbl;
    private RecyclerView recycler;

    public VHCluster(View itemView, RecyclerListener recyclerListener, ClusterRecyclerListener clusterListener) {
        super(itemView, recyclerListener);
        this.clusterListener = clusterListener;
        clusterNameLbl = findView(R.id.clusterNameLbl);
        totalUnitLbl = findView(R.id.totalUnitLbl);
        soldLbl = findView(R.id.soldLbl);
        recycler = findView(R.id.recycler);
    }

    @Override
    public void setData(Cluster data) {
        super.setData(data);
        RecyclerListener listener = getRecyclerListener();
        Activity activity = ((BaseImpl) listener).getActivity();
        clusterNameLbl.setText(data.getName());
        clusterNameLbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clusterListener.openClusterDetail(data);
            }
        });
        totalUnitLbl.setText("Total " + data.getTotalUnit() + " units");
        soldLbl.setText("Sold " + data.getSoldPercentage() + "%");

        AdapterUnitType adapter = new AdapterUnitType(data.getUnitTypes(), listener, (UnitTypeRecyclerListener) listener);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(new ItemDecorationVertical(activity, R.dimen.padding_slarge));
        recycler.setLayoutManager(new LinearLayoutManager(activity));
    }
}
