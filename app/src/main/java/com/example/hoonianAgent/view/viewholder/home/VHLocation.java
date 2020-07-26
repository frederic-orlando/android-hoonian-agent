package com.example.hoonianAgent.view.viewholder.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHLocation extends BaseViewHolder<City> {
    private ImageView image;
    private TextView primaryLbl;
    private TextView secondaryLbl;

    public VHLocation(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        image = findView(R.id.image);
        primaryLbl = findView(R.id.primaryLbl);
        secondaryLbl = findView(R.id.secondaryLbl);
    }

    @Override
    public void setData(City data) {
        super.setData(data);

        loadImage(data.getImage(), image);

        primaryLbl.setText(data.getName());
        secondaryLbl.setVisibility(View.GONE);
    }
}
