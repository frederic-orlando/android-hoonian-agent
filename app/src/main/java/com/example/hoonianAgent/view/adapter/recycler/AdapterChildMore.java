package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.acl.ModelMenu;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.VHChildMore;

import java.util.ArrayList;

public class AdapterChildMore extends BaseAdapter<ModelMenu> {
    public AdapterChildMore(ArrayList<ModelMenu> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHChildMore(createView(parent, R.layout.adapter_child_more), recyclerListener);
    }
}
