package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Cluster;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
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
    protected LinearLayout galleryLayout;
    @ViewById
    protected CarouselView carousel;
    @ViewById
    protected LinearLayout vrLayout;
    @ViewById
    protected ImageView vrImage;
    @ViewById
    protected LinearLayout videoLayout;
    @ViewById
    protected ImageView videoThumbnail;
    @ViewById
    protected TextView floorNameLbl;
    @ViewById
    protected TableLayout unitCountTable;
    @ViewById
    protected LinearLayout blackPrevNextBtn;
    @ViewById
    protected FrameLayout floorLayout;
    @ViewById
    protected ImageView floorImage;

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
    public LinearLayout galleryLayout() {
        return galleryLayout;
    }

    @Override
    public CarouselView gallery() {
        return carousel;
    }

    @Override
    public LinearLayout vrLayout() {
        return vrLayout;
    }

    @Override
    public ImageView vr() {
        return vrImage;
    }

    @Override
    public LinearLayout videoLayout() {
        return videoLayout;
    }

    @Override
    public ImageView video() {
        return videoThumbnail;
    }

    @Override
    public TextView floorLbl() {
        return floorNameLbl;
    }

    @Override
    public TableLayout unitCountTable() {
        return unitCountTable;
    }

    @Override
    public LinearLayout floorButtonLayout() {
        return blackPrevNextBtn;
    }

    @Override
    public ImageButton prevFloorBtn() {
        return blackPrevNextBtn.findViewById(R.id.prevBtn);
    }

    @Override
    public ImageButton nextFloorBtn() {
        return blackPrevNextBtn.findViewById(R.id.nextBtn);
    }

    @Override
    public FrameLayout floorLayout() {
        return floorLayout;
    }

    @Override
    public ImageView floor() {
        return floorImage;
    }

    @Click(R.id.prevBtn)
    protected void prevVideo() {impl.prevVideo();}

    @Click(R.id.nextBtn)
    protected void nextVideo() {impl.nextVideo();}
}
