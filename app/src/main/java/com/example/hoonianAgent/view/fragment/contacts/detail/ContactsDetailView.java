package com.example.hoonianAgent.view.fragment.contacts.detail;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public interface ContactsDetailView {
    TextView name();
    TextView phone();
    TextView idNo();
    TextView position();
    TextView relation();
    RecyclerView referred();
    RecyclerView purchased();
}
