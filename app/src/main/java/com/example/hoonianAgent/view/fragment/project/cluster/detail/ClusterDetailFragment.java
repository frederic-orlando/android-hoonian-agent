package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_project_cluster_detail)
public class ClusterDetailFragment extends BaseFragmentFromMore implements ClusterDetailView {
    public static final int FRAGMENT_ID = 18;

    @Bean
    protected ClusterDetailImpl impl;
    @ViewById
    protected TextView clusterNameLbl;
    @ViewById
    protected TextView totalUnitLbl;
    @ViewById
    protected ImageView image;
    @ViewById
    protected RecyclerView facilityRecycler;
    @ViewById
    protected CarouselView carousel;
    @ViewById
    protected ImageView vrImage;
    @ViewById
    protected ImageView videoThumbnail;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setCluster((Cluster) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public TextView clusterName() {
        return clusterNameLbl;
    }

    @Override
    public TextView total() {
        return totalUnitLbl;
    }

    @Override
    public ImageView image() {
        return image;
    }

    @Override
    public RecyclerView facilities() {
        return facilityRecycler;
    }

    @Override
    public CarouselView gallery() {
        return carousel;
    }

    @Override
    public ImageView vr() {
        return vrImage;
    }

    @Override
    public ImageView video() {
        return videoThumbnail;
    }
}
