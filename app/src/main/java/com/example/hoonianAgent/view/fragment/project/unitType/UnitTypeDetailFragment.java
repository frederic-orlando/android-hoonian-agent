package com.example.hoonianAgent.view.fragment.project.unitType;

import android.widget.ImageView;
import android.widget.TextView;

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

@EFragment(R.layout.fragment_unit_type_detail)
public class UnitTypeDetailFragment extends BaseFragmentFromMore<ClusterListImpl> implements UnitTypeDetailView {
    public static final int FRAGMENT_ID = 17;
    @Bean
    protected UnitTypeDetailImpl impl;
    @ViewById
    protected TextView typeNameLbl;
    @ViewById
    protected ImageView image;
    @ViewById
    protected TextView sizeLbl;
    @ViewById
    protected TextView priceLbl;
    @ViewById
    protected TextView totalUnitLbl;
    @ViewById
    protected TextView availableLbl;
    @ViewById
    protected CarouselView carousel;
    @ViewById
    protected ImageView vrImage;
    @ViewById
    protected ImageView videoThumbnail;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setUnitType((UnitType) baseSerializableObject);
//        impl.setUnitType(callback.getProject());
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public TextView typeName() {
        return typeNameLbl;
    }

    @Override
    public ImageView image() {
        return image;
    }

    @Override
    public TextView size() {
        return sizeLbl;
    }

    @Override
    public TextView price() {
        return priceLbl;
    }

    @Override
    public TextView total() {
        return totalUnitLbl;
    }

    @Override
    public TextView available() {
        return availableLbl;
    }

    @Override
    public CarouselView carousel() {
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

    @Click(R.id.playBtn)
    protected void playVideo() {impl.playVideo();}
}
