package com.example.hoonianAgent.view.viewholder.base;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.acl.ModelMore;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.adapter.recycler.AdapterChildMore;

public class VHMore extends BaseViewHolder<ModelMore> {
    private TextView title;
    private RecyclerView child;

    public VHMore(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        title = findView(R.id.title);
        child = findView(R.id.child);
        child.setLayoutManager(new GridLayoutManager(itemView.getContext(), 4));
    }

    @Override
    public void setData(ModelMore data) {
        super.setData(data);
        title.setText(data.getTitle());
        child.setAdapter(new AdapterChildMore(data.getChild(), getRecyclerListener()));
    }
}
