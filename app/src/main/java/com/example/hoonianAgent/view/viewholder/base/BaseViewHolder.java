package com.example.hoonianAgent.view.viewholder.base;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hoonianAgent.R;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.ImageLoader;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;

import lombok.Getter;

/**
 * Created by AndreHF on 6/19/2017.
 */

public class BaseViewHolder<T> extends RecyclerView.ViewHolder implements ImageLoader {
    @Getter
    private final RecyclerListener recyclerListener;
    @Getter
    private final Activity activity;

    public BaseViewHolder(View itemView, RecyclerListener recyclerListener) {
        super(itemView);
        this.recyclerListener = recyclerListener;
        this.activity = ((BaseImpl) recyclerListener).getActivity();
        itemView.setOnClickListener((View view) -> this.recyclerListener.onItemClick(itemView.getTag()));
    }

    public void setData(T data) {
        itemView.setTag(data);
    }


    protected <K extends View> K findView(int id) {
        return (K) itemView.findViewById(id);
    }

    protected T getData(){
        return (T) itemView.getTag();
    }

    @Override
    public void loadImage(String url, ImageView view) {
        int placeholder = R.drawable.ic_launcher_background;
        Glide.with(activity).load(url)
                .placeholder(placeholder)
                .into(view);
    }
}
