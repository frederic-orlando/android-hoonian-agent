package com.example.hoonianAgent.view.fragment.purchase;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.view.fragment.base.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_purchase)
public class PurchaseFragment extends BaseFragment implements PurchaseView {
    @Bean
    protected PurchaseImpl impl;
    @ViewById
    protected RecyclerView recycler;

    @AfterViews
    protected void init() {
        impl.setViewAct(this);
        impl.setFragmentManager(getFragmentManager(), getClass().getName());
        impl.init();
    }

    @Override
    public RecyclerView recycler() {
        return recycler;
    }

    @Click(R.id.noticeBtn)
    protected void showNotice() {impl.showNotice();}
}
