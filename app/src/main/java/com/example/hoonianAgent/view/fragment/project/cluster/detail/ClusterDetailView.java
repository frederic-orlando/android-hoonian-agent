package com.example.hoonianAgent.view.fragment.project.cluster.detail;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;

public interface ClusterDetailView {
    TextView clusterName();
    TextView total();
    ImageView image();
    RecyclerView facilities();
    CarouselView gallery();
    ImageView vr();
    ImageView video();
}
