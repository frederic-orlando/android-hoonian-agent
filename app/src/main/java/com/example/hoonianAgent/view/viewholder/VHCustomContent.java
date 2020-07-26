package com.example.hoonianAgent.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.CustomContent;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHCustomContent extends BaseViewHolder<CustomContent> {
    private TextView titleLbl;
    private TextView bodyLbl;

    public VHCustomContent(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        titleLbl = findView(R.id.titleLbl);
        bodyLbl = findView(R.id.bodyLbl);
    }

    @Override
    public void setData(CustomContent data) {
        super.setData(data);
        if (data.getTitle() == null) {
            titleLbl.setVisibility(View.GONE);
        }
        else {
            titleLbl.setText(data.getTitle());
        }
        bodyLbl.setText(data.getBody());
    }
}
