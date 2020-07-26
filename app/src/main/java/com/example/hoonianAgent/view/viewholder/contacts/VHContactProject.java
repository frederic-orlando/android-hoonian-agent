package com.example.hoonianAgent.view.viewholder.contacts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHContactProject extends BaseViewHolder<Project> {
    private ImageView image;
    private TextView nameLbl;
    private TextView locationLbl;
    private TextView statusLbl;

    public VHContactProject(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        image = findView(R.id.image);
        nameLbl = findView(R.id.nameLbl);
        locationLbl = findView(R.id.locationLbl);
        statusLbl = findView(R.id.statusLbl);
    }

    @Override
    public void setData(Project data) {
        super.setData(data);
        loadImage(data.getImage(), image);
        nameLbl.setText(data.getName());
        locationLbl.setText(data.getCity());

        String purchaseStatus = data.getPurchaseStatus();
        if (purchaseStatus == null) {
            statusLbl.setVisibility(View.GONE);
        }
        statusLbl.setText(purchaseStatus);
    }
}
