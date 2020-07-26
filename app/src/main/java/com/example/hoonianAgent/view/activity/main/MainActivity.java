package com.example.hoonianAgent.view.activity.main;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.home.ModelDataHome;
import com.example.hoonianAgent.view.activity.base.BaseActivityToolBar;
import com.google.android.material.tabs.TabLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivityToolBar implements MainView {
    @ViewById
    protected ViewPager pager;
    @ViewById
    protected TabLayout menu;
    @Bean
    protected MainImpl impl;
    @Extra
    protected boolean isFromMore;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getSupportFragmentManager(), getClass().getName());
        impl.setFromMore(isFromMore);
        impl.init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        impl.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected boolean display() {
        return false;
    }

    @Override
    public ViewPager pager() { return pager; }

    @Override
    public TabLayout menu() {
        return menu;
    }

    @Override
    public void setTitleToolbar(String title) {
        titleApp.setText(title);
    }

    @Override
    public void showHideBackPressed(boolean show) {

    }

    @Override
    public void backDefault() {

    }

    @Click(R.id.notificationBtn)
    protected void notification() {impl.notification();}
    @Click(R.id.profileBtn)
    protected void profile() {impl.profile();}
}