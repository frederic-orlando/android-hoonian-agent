package com.example.hoonianAgent.model.response.bank;

import com.example.hoonianAgent.model.content.bank.Bank;
import com.example.hoonianAgent.model.response.BaseResponse;

import java.util.ArrayList;

public class ResponseGetBankList extends BaseResponse<ResponseGetBankList.ModelData> {
    public class ModelData {
        private ArrayList<Bank> banks;
    }

    public ArrayList<Bank> getBanks() {
        return getData().banks;
    }
}
