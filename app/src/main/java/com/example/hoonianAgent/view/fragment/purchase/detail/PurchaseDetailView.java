package com.example.hoonianAgent.view.fragment.purchase.detail;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.hoonianAgent.model.custom.FloorPlanConstraint;
import com.synnapps.carouselview.CarouselView;

public interface PurchaseDetailView {
    TextView type();
    CarouselView carousel();
    TextView sizeLbl();
    TextView priceLbl();
    TextView unitNameLbl();
    FrameLayout floorLayout();
    ImageView floor();
    ImageView ar();
    ImageView vr();
}
