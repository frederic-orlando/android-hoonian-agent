package com.example.hoonianAgent.view.adapter.recycler;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hoonianAgent.R;
import com.example.hoonianAgent.model.content.property.PurchasedProject;
import com.example.hoonianAgent.presenter.callback.RecyclerListener;
import com.example.hoonianAgent.view.viewholder.purchase.VHPurchaseList;

import java.util.ArrayList;

public class AdapterPurchase extends BaseAdapter<PurchasedProject>{
    public AdapterPurchase(ArrayList<PurchasedProject> listItem, RecyclerListener recyclerListener) {
        super(listItem, recyclerListener);
    }

    @Override
    protected RecyclerView.ViewHolder createHolder(ViewGroup parent, int viewType) {
        return new VHPurchaseList(createView(parent, R.layout.row_purchased), recyclerListener);
    }
}
