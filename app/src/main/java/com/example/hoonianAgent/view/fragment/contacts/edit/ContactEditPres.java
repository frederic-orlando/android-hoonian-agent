package com.example.hoonianAgent.view.fragment.contacts.edit;

import com.example.hoonianAgent.model.content.home.HomeItem;

import java.util.ArrayList;

public interface ContactEditPres {
    void init();
    void initData();
    void setDataSpinner(ArrayList<HomeItem> cities);
    void save();
}
