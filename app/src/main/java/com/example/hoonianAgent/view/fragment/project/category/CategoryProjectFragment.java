package com.example.hoonianAgent.view.fragment.project.category;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.content.property.Category;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.example.hoonianAgent.view.fragment.project.city.CityProjectImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_category_project)
public class CategoryProjectFragment extends BaseFragmentFromMore implements CategoryProjectView {
    public static final int FRAGMENT_ID = 13;
    @Bean
    protected CategoryProjectImpl impl;
    @ViewById
    protected EditText searchTxt;
    @ViewById
    protected CheckBox favoriteCheck;
    @ViewById
    protected CheckBox recommendCheck;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setLayoutFragment(R.id.fragmentHolder);
        impl.setCategory((Category) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public EditText searchTxt() {
        return searchTxt;
    }

    @Override
    public CheckBox favorite() {
        return favoriteCheck;
    }

    @Override
    public CheckBox recommended() {
        return recommendCheck;
    }
}
