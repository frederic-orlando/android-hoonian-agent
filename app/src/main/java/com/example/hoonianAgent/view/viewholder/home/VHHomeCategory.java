package com.example.hoonianAgent.view.viewholder.home;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.example.hoonianAgent.model.content.property.Category;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.HomeCategoryListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.adapter.recycler.AdapterHomeProject;
import com.example.hoonianAgent.view.adapter.recycler.itemDecoration.ItemDecorationHorizontal;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHHomeCategory extends BaseViewHolder<Category> {
    private TextView categoryLbl;
    private TextView moreBtn;
    private RecyclerView recycler;

    public VHHomeCategory(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        categoryLbl = findView(R.id.categoryLbl);
        moreBtn = findView(R.id.moreBtn);
        recycler = findView(R.id.recycler);
    }

    @Override
    public void setData(Category data) {
        super.setData(data);
        Activity activity = ((BaseImpl) getRecyclerListener()).getActivity();

        categoryLbl.setText(data.getName());

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HomeCategoryListener) getRecyclerListener()).onMoreClick(data);
            }
        });

        recycler.addItemDecoration(new ItemDecorationHorizontal(activity, R.dimen.padding_default, R.dimen.padding_xmsmall));
        AdapterHomeProject adapter = new AdapterHomeProject(data.getProjects(), getRecyclerListener());
        recycler.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(manager);
    }
}

