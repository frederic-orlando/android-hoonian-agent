package com.example.hoonianAgent.view.fragment.news;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public interface NewsDetailView {
    ImageView image();
    TextView titleLbl();
    RecyclerView content();
}
