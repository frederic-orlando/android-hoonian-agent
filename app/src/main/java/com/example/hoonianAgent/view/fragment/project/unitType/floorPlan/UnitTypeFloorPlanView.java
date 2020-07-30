package com.example.hoonianAgent.view.fragment.project.unitType.floorPlan;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.synnapps.carouselview.CarouselView;

public interface UnitTypeFloorPlanView {
    TextView floorLbl();
    TableLayout unitCountTable();
    FrameLayout floorLayout();
    ImageView floor();
}
