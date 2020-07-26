package com.example.hoonianAgent.view.fragment.project.referred.form;

import com.example.hoonianAgent.model.content.referred.Referred;

import java.util.ArrayList;

public interface ReferredFormPres {
    void init();
    void setDataReferred(ArrayList<Referred> referred);
    void send();
    void addFromContact();
}
