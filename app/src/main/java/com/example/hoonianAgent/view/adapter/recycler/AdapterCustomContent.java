package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.CustomContent;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.VHCustomContent;

import java.util.ArrayList;

public class AdapterCustomContent extends BaseAdapter<CustomContent>{
    public AdapterCustomContent(ArrayList<CustomContent> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHCustomContent(createView(parent, R.layout.row_custom_content), recyclerListener);
    }
}
