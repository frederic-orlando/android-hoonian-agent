package com.example.hoonianAgent.view.fragment.project.unitType.floorPlan;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.UnitType;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.example.hoonianAgent.view.fragment.project.cluster.list.ClusterListImpl;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_unit_type_floor_plan)
public class UnitTypeFloorPlanFragment extends BaseFragmentFromMore implements UnitTypeFloorPlanView {
    public static final int FRAGMENT_ID = 24;
    @Bean
    protected UnitTypeFloorPlanImpl impl;
    @ViewById
    protected TextView floorNameLbl;
    @ViewById
    protected TableLayout unitCountTable;
    @ViewById
    protected FrameLayout floorLayout;
    @ViewById
    protected ImageView floorImage;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setUnitType((UnitType) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
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
    public FrameLayout floorLayout() {
        return floorLayout;
    }

    @Override
    public ImageView floor() {
        return floorImage;
    }

    @Click(R.id.prevBtn)
    protected void prevFloor() {impl.prevFloor();}

    @Click(R.id.nextBtn)
    protected void nextFloor() {impl.nextFloor();}
}
