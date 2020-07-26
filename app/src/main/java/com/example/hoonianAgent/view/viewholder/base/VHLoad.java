package com.example.hoonianAgent.view.viewholder.base;

import android.view.View;
import android.widget.ProgressBar;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;

/**
 * Created by faizf on 4/4/2017.
 */

public class VHLoad extends BaseViewHolder<Object> {

    private ProgressBar progressBar;


    public VHLoad(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        progressBar = findView(R.id.load);
    }

}

