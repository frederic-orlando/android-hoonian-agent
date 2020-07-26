package com.example.hoonianAgent.view.fragment.news;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.io.Serializable;

@EFragment(R.layout.fragment_news_detail)
public class NewsDetailFragment extends BaseFragmentFromMore implements NewsDetailView {
    public static final int FRAGMENT_ID = 9;
    @Bean
    protected NewsDetailImpl impl;
    @ViewById
    protected ImageView image;
    @ViewById
    protected TextView titleLbl;
    @ViewById
    protected RecyclerView contentRecycler;
    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setNewsItem((HomeItem) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public ImageView image() {
        return image;
    }
    @Override
    public TextView titleLbl() {
        return titleLbl;
    }
    @Override
    public RecyclerView content() {
        return contentRecycler;
    }
}
