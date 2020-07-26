package com.example.hoonianAgent.view.fragment.purchase;

import com.example.hoonianAgent.model.content.property.PurchasedProject;

import java.util.ArrayList;

public interface PurchasePres {
    void init();
    void setDataPurchase(ArrayList<PurchasedProject> listPurchase);
    void showNotice();
}
