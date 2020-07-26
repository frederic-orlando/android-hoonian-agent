package com.example.hoonianAgent.view.fragment.project.referred;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.project.ProjectImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_contacts)
public class ReferredListFragment extends BaseFragment<ProjectImpl> implements ReferredListView {
    @Bean
    protected ReferredListImpl impl;
    @ViewById
    protected EditText searchTxt;
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
    public TextView search() {
        return searchTxt;
    }

    @Override
    public RecyclerView recycler() {
        return recycler;
    }

    @Click(R.id.addBtn)
    protected void refer() {
        impl.refer();
    }
}
