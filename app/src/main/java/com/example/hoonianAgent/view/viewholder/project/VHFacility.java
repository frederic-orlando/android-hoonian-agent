package com.example.hoonianAgent.view.viewholder.project;

import android.view.View;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.Facility;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolderPos;

public class VHFacility extends BaseViewHolderPos<Facility> {
    private TextView noLbl;
    private TextView facilityLbl;

    public VHFacility(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        noLbl = findView(R.id.noLbl);
        facilityLbl = findView(R.id.facilityLbl);
    }

    @Override
    public void setData(Facility data, int position) {
        super.setData(data, position);
        noLbl.setText("" + (position + 1));
        facilityLbl.setText(data.getName());
    }
}
