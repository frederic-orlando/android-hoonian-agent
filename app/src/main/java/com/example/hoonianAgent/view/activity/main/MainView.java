package com.example.hoonianAgent.view.activity.main;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public interface MainView {
    ViewPager pager();
    TabLayout menu();
    void setTitleToolbar(String title);
    void showHideBackPressed(boolean show);
    void backDefault();
}
