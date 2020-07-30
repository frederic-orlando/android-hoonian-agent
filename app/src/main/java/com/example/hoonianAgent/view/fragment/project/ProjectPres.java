package com.example.hoonianAgent.view.fragment.project;

import com.example.hoonianAgent.model.content.acl.ModelTab;

import java.util.ArrayList;

public interface ProjectPres {
    void init();
    void initTab(ArrayList<ModelTab> dataTabs);
    void removeUnitPriceTab();
}
