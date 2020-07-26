package com.example.hoonianAgent.view.fragment.project.referred;

import com.example.hoonianAgent.model.content.referred.Referred;

import java.util.ArrayList;

public interface ReferredListPres {
    void init();
    void search();
    void setDataReferred(ArrayList<Referred> referred);
    void refer();
    void getData(String keyWord);
}
