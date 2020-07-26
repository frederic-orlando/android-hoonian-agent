package com.example.hoonianAgent.view.viewholder.city;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHCity extends BaseViewHolder<City> {
    private ImageView image;
    private TextView nameLbl;

    public VHCity(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        image = findView(R.id.image);
        nameLbl = findView(R.id.nameLbl);
    }

    @Override
    public void setData(City data) {
        super.setData(data);
        loadImage(data.getImage(), image);
        nameLbl.setText(data.getName());
    }
}
