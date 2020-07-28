package com.example.hoonianAgent.view.fragment.purchase.detail;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.model.custom.FloorPlanConstraint;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_purchase_detail)
public class PurchaseDetailFragment extends BaseFragmentFromMore implements PurchaseDetailView {
    public static final int FRAGMENT_ID = 14;
    @Bean
    protected PurchaseDetailImpl impl;
    @ViewById
    protected TextView typeLbl;
    @ViewById
    protected CarouselView carousel;
    @ViewById
    protected TextView sizeLbl;
    @ViewById
    protected TextView priceLbl;
    @ViewById
    protected TextView unitNameLbl;
    @ViewById
    protected FrameLayout floorLayout;
    @ViewById
    protected ImageView floorImage;
    @ViewById
    protected LinearLayout model3dLayout;
    @ViewById
    protected LinearLayout vrLayout;
    @ViewById
    protected ImageView arImage;
    @ViewById
    protected ImageView vrImage;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setPurchased((PurchasedProject) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public TextView type() {
        return typeLbl;
    }

    @Override
    public CarouselView carousel() {
        return carousel;
    }

    @Override
    public TextView sizeLbl() {
        return sizeLbl;
    }

    @Override
    public TextView priceLbl() {
        return priceLbl;
    }

    @Override
    public TextView unitNameLbl() {
        return unitNameLbl;
    }

    @Override
    public FrameLayout floorLayout() {
        return floorLayout;
    }

    @Override
    public ImageView floor() {
        return floorImage;
    }

    @Override
    public LinearLayout model3dLayout() {
        return model3dLayout;
    }

    @Override
    public LinearLayout vrLayout() {
        return vrLayout;
    }

    @Override
    public ImageView ar() {
        return arImage;
    }

    @Override
    public ImageView vr() {
        return vrImage;
    }
}
