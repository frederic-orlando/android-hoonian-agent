package com.example.hoonianAgent.view.viewholder.project;

import android.view.View;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.referred.Referred;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.callback.ReferredRecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHReferred extends BaseViewHolder<Referred> {
    private TextView nameLbl;
    private TextView typeLbl;
    private TextView callBtn;
    private TextView statusLbl;
    private TextView commissionLbl;

    public VHReferred(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        nameLbl = findView(R.id.nameLbl);
        typeLbl = findView(R.id.typeLbl);
        callBtn = findView(R.id.callBtn);
        statusLbl = findView(R.id.statusLbl);
        commissionLbl = findView(R.id.commissionLbl);
    }

    @Override
    public void setData(Referred data) {
        super.setData(data);
        nameLbl.setText(data.getContact().getName());

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ReferredRecyclerListener) getRecyclerListener()).call(data.getContact().getPhone());
            }
        });

        statusLbl.setText(data.getStatus().getName());
    }
}
