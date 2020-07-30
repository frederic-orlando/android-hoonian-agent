package com.example.hoonianAgent.view.viewholder.contacts;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.base.BaseViewHolder;

public class VHContact extends BaseViewHolder<Contacts> {
    private TextView avatar;
    private TextView nameLbl;
    private TextView recommendLbl;
    private TextView purchaseLbl;
    private LinearLayout recommendLayout;
    private LinearLayout purchaseLayout;

    public VHContact(View itemView, RecyclerListener recyclerListener) {
        super(itemView, recyclerListener);
        avatar = findView(R.id.avatar);
        nameLbl = findView(R.id.nameLbl);
        recommendLbl = findView(R.id.recommendLbl);
        purchaseLbl = findView(R.id.purchaseLbl);
        recommendLayout = findView(R.id.recommendLayout);
        purchaseLayout = findView(R.id.purchaseLayout);
    }

    @Override
    public void setData(Contacts data) {
        super.setData(data);
        avatar.setText(data.getName().substring(0,1));
        nameLbl.setText(data.getName());
        int referred = data.getReferred();
        if (referred > 0) {
            recommendLbl.setText("" + referred);
        }
        else {
            recommendLayout.setVisibility(View.INVISIBLE);
        }
        int purchase = data.getPurchase();
        if (purchase > 0) {
            purchaseLbl.setText("" + purchase);
        }
        else {
            purchaseLayout.setVisibility(View.INVISIBLE);
        }

    }
}
