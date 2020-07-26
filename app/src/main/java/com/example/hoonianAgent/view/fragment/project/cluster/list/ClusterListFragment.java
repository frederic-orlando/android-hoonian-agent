package com.example.hoonianAgent.view.fragment.project.cluster.list;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.project.ProjectImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_recycler)
public class ClusterListFragment extends BaseFragment<ProjectImpl> implements ClusterListView {
    @Bean
    protected ClusterListImpl impl;
    @ViewById
    protected RecyclerView recycler;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setProject(callback.getProject());
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public RecyclerView recycler() {
        return recycler;
    }
}
