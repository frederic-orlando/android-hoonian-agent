package com.example.hoonianAgent.view.viewholder.base;

import android.view.View;

import com.example.hoonianAgent.presenter.callback.RecyclerListener;

public class BaseViewHolderPos<T> extends BaseViewHolder<T> {
    public BaseViewHolderPos(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
    }

    public void setData(T data, int position) {
        itemView.setTag(data);
    }
}
