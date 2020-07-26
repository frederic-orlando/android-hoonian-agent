package com.example.hoonianAgent.view.fragment.home;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.home.ModelDataHome;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.synnapps.carouselview.CarouselView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends BaseFragmentFromMore implements HomeView {
    @Bean
    protected HomeImpl impl;
    @ViewById
    protected SwipeRefreshLayout swipe;
    @ViewById
    protected TextView userNameLbl;
    @ViewById
    protected CarouselView carousel;
    @ViewById
    protected RecyclerView recycler;
    @ViewById
    protected RecyclerView propertyRecycler;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public SwipeRefreshLayout swipe() {
        return swipe;
    }

    @Override
    public TextView name() { return userNameLbl; }
    @Override
    public CarouselView carousel() { return carousel; }

    @Override
    public RecyclerView locations() {
        return recycler;
    }

    @Override
    public RecyclerView properties() { return propertyRecycler; }

    @Click(R.id.moreBtn)
    protected void seeMoreLocation() {impl.seeMoreLocation();}
}
