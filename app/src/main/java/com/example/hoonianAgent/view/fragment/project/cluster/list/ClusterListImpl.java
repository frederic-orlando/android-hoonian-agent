package com.example.hoonianAgent.view.fragment.project.cluster.list;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.File;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.model.response.project.ResponseGetClusterList;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.ClusterRecyclerListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.UnitTypeRecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsMenuFragment;
import com.example.hoonianAgent.view.adapter.recycler.AdapterCluster;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationVertical;
import com.example.hoonianAgent.view.fragment.project.cluster.detail.ClusterDetailFragment;
import com.example.hoonianAgent.view.fragment.project.unitType.UnitTypeDetailFragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import lombok.Setter;

@EBean
public class ClusterListImpl extends BaseImpl<ClusterListView> implements ClusterListPres, RecyclerListener, ClusterRecyclerListener, UnitTypeRecyclerListener {
    @Bean
    protected UtilsMenuFragment utilsMenuFragment;
    @Setter
    private Project project;

    @Override
    public void init() {
        serviceManager.getClusterList(project.getId());
    }

    @Override
    public void setDataCluster(ArrayList<Cluster> listCluster) {
        RecyclerView recycler = viewAct.recycler();
        if (recycler != null) {
            AdapterCluster adapter = new AdapterCluster(listCluster, this);
            recycler.setAdapter(adapter);
            recycler.setLayoutManager(new LinearLayoutManager(activity));
            recycler.addItemDecoration(new ItemDecorationVertical(activity, R.dimen.padding_smlarge, R.dimen.padding_smlarge));
        }
    }

    @Override
    public void onSuccessWithData(Object o) {
        super.onSuccessWithData(o);
        if (o instanceof ResponseGetClusterList) {
            setDataCluster(((ResponseGetClusterList) o).getCluster());
        }
    }

    @Override
    public void onItemClick(Object o) {
        if (o instanceof UnitType) {
            UnitType unitType = (UnitType) o;
            intentManager.moveToNext(unitType.getName(), UnitTypeDetailFragment.FRAGMENT_ID, unitType);
        }
    }

    @Override
    public void openClusterDetail(Cluster cluster) {
        intentManager.moveToNext(cluster.getName(), ClusterDetailFragment.FRAGMENT_ID, cluster);
    }

    @Override
    public void openFloorPlan(String clusterId, String unitTypeId) {
        // Todo: Floor Plan
        Toast.makeText(activity, "Floor Plan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openPriceList(File priceList) {
        // Todo: Price List
        Toast.makeText(activity, "Price List", Toast.LENGTH_SHORT).show();
    }
}
