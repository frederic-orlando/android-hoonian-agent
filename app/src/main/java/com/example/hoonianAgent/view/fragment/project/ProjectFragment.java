package com.example.hoonianAgent.view.fragment.project;

import androidx.viewpager.widget.ViewPager;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.google.android.material.tabs.TabLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_project)
public class ProjectFragment extends BaseFragmentFromMore implements ProjectView {
    public static final int FRAGMENT_ID = 15;
    @Bean
    protected ProjectImpl impl;
    @ViewById
    protected TabLayout tab;
    @ViewById
    protected ViewPager pager;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setProject((Project) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public TabLayout tab() {
        return tab;
    }

    @Override
    public ViewPager pager() {
        return pager;
    }
}
