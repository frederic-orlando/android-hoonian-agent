package com.example.hoonianAgent.view.fragment.auth.register;

import com.example.hoonianAgent.model.content.bank.Bank;

import java.util.ArrayList;

public interface RegisterPres {
    void init();
    void initDataBank(ArrayList<Bank> listBank);
    void register();
}
