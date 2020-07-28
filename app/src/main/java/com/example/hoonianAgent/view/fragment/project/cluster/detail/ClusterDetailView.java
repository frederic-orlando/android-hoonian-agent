package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;

public interface ClusterDetailView {
    TextView clusterName();
    TextView total();
    ImageView image();
    RecyclerView facilities();
    LinearLayout galleryLayout();
    CarouselView gallery();
    LinearLayout vrLayout();
    ImageView vr();
    LinearLayout videoLayout();
    ImageView video();

    TextView floorLbl();
    TableLayout unitCountTable();
    LinearLayout floorButtonLayout();
    ImageButton prevFloorBtn();
    ImageButton nextFloorBtn();

    FrameLayout floorLayout();
    ImageView floor();
}
