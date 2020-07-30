package com.example.hoonianAgent.view.viewholder.purchase;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.presenter.base.impl.BaseImpl;
import com.example.hoonianAgent.presenter.callback.PurchaseRecyclerListener;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.presenter.utils.UtilsCurrency;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHPurchaseList extends BaseViewHolder<PurchasedProject> {
    private ImageView image;
    private Button detailBtn;
    private TextView nameLbl;
    private TextView typeLbl;
    private TextView priceLbl;
    private TextView buyerLbl;
    private TextView statusLbl;
    private TextView commissionLbl;


    public VHPurchaseList(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        image = findView(R.id.image);
        nameLbl = findView(R.id.nameLbl);
        detailBtn = findView(R.id.detailBtn);
        typeLbl = findView(R.id.typeLbl);
        priceLbl = findView(R.id.priceLbl);
        buyerLbl = findView(R.id.buyerLbl);
        statusLbl = findView(R.id.statusLbl);
        commissionLbl = findView(R.id.commissionLbl);
    }

    @Override
    public void setData(PurchasedProject data) {
        super.setData(data);
        loadImage(data.getProject().getImage(), image);
        nameLbl.setText(data.getProject().getName());
        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PurchaseRecyclerListener) getRecyclerListener()).openDetail(data);
            }
        });
        typeLbl.setText(data.getUnit().getType().getName());
        priceLbl.setText(UtilsCurrency.toCurrency(data.getPrice()));
        buyerLbl.setText(data.getClient().getName());
        statusLbl.setText(data.getStatus().getName());
//        statusLbl.setTextColor(Color.parseColor(data.getStatus().getColor()));
        commissionLbl.setText(data.getCommission());
    }
}
