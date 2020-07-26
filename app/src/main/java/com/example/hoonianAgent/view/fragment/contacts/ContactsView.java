package com.example.hoonianAgent.view.fragment.contacts;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;

public interface ContactsView {
    EditText search();
    RecyclerView recycler();
}
