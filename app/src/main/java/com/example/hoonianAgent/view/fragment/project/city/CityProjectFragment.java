package com.example.hoonianAgent.view.fragment.project.city;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_city_project)
public class CityProjectFragment extends BaseFragmentFromMore implements CityProjectView {
    public static final int FRAGMENT_ID = 11;
    @Bean
    protected CityProjectImpl impl;
    @ViewById
    protected ImageButton apartmentBtn;
    @ViewById
    protected ImageButton landedBtn;
    @ViewById
    protected ImageButton warehouseBtn;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setLayoutFragment(R.id.fragmentHolder);
        impl.setCity((City) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public ImageButton apartment() {
        return apartmentBtn;
    }

    @Override
    public ImageButton landed() {
        return landedBtn;
    }

    @Override
    public ImageButton warehouse() {
        return warehouseBtn;
    }
}
