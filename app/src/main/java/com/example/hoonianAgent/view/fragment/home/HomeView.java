package com.example.hoonianAgent.view.fragment.home;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.synnapps.carouselview.CarouselView;

public interface HomeView {
    SwipeRefreshLayout swipe();
    TextView name();
    CarouselView carousel();
    RecyclerView locations();
    RecyclerView properties();
}
