package com.example.hoonianAgent.view.fragment.profile.edit;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.bank.Bank;

import java.util.ArrayList;

public interface ProfileEditPres {
    void init();
    void initData();
    void setDataBank(ArrayList<Bank> banks);
    void uploadProfile();
    void uploadIdCard();
    void pickImage(int requestCode);
    void save();
}
