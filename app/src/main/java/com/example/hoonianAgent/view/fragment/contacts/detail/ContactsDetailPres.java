package com.example.hoonianAgent.view.fragment.contacts.detail;

import com.example.hoonianAgent.model.content.CustomContent;
import com.example.hoonianAgent.model.content.property.Project;

import java.util.ArrayList;

public interface ContactsDetailPres {
    void init();
    void initData();
    void editProfile();
    void setDataReferred(ArrayList<Project> listReferred);
    void setDataPurchased(ArrayList<Project> listPurchased);
}
