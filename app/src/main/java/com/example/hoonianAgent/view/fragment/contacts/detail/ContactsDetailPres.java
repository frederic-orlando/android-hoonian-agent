package com.example.hoonianAgent.view.fragment.contacts.detail;

import com.example.hoonianAgent.model.content.CustomContent;
import com.example.hoonianAgent.model.content.property.Project;
import com.example.hoonianAgent.model.content.property.ReferredProject;

import java.util.ArrayList;

public interface ContactsDetailPres {
    void init();
    void initData();
    void editProfile();
    void setDataReferred(ArrayList<ReferredProject> listReferred);
    void setDataPurchased(ArrayList<ReferredProject> listPurchased);
}
