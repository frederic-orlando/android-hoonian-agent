package com.example.hoonianAgent.view.fragment.project.referred.form;

import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;
import com.example.hoonianAgent.view.fragment.base.BaseFragmentFromMore;
import com.example.hoonianAgent.view.fragment.project.ProjectImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_referred_form)
public class ReferredFormFragment extends BaseFragmentFromMore implements ReferredFormView {
    public static final int FRAGMENT_ID = 19;
    @Bean
    protected ReferredFormImpl impl;
    @ViewById
    protected RecyclerView recycler;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setProject((Project) baseSerializableObject);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public RecyclerView recycler() {
        return recycler;
    }

    @Click(R.id.sendBtn)
    protected void send() {impl.send();}
    @Click(R.id.addBtn)
    protected void addFromContact() {impl.addFromContact();}
}
