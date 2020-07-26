package com.example.hoonianAgent.view.fragment.project.detail;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.synnapps.carouselview.CarouselView;

public interface ProjectDetailView {
    ImageView image();
    ImageButton favoriteBtn();
    TextView location();
    TextView available();
    TextView startPrice();
    TextView address();
    TextView desc();
    RecyclerView facilities();
    CarouselView gallery();
    ImageView video();
}
