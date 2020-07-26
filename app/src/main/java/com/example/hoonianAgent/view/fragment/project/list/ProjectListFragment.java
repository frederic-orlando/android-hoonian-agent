package com.example.hoonianAgent.view.fragment.project.list;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.response.project.ModelDataProjectList;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_project_list)
public class ProjectListFragment extends BaseFragmentFromMore implements ProjectListView {
    @Bean
    protected ProjectListImpl impl;
    @ViewById
    protected RecyclerView recycler;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setData((ModelDataProjectList) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public RecyclerView recycler() {
        return recycler;
    }
}
