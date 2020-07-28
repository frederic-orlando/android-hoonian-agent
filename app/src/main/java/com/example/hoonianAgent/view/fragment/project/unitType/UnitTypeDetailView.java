package com.example.hoonianAgent.view.fragment.project.unitType;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;

public interface UnitTypeDetailView {
    TextView typeName();
    ImageView image();
    TextView size();
    TextView price();
    TextView total();
    TextView available();

    LinearLayout galleryLayout();
    LinearLayout vrLayout();
    LinearLayout videoLayout();

    CarouselView carousel();
    ImageView vr();
    ImageView video();
}
