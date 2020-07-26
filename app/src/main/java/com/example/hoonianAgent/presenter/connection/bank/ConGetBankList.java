package com.example.hoonianAgent.presenter.connection.bank;

import android.content.Context;

import com.example.hoonianAgent.model.response.bank.ResponseGetBankList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetBankList extends HttpRequest<Objects, ResponseGetBankList> {
    public ConGetBankList(Context context) {
        super(context, ResponseGetBankList.class, URL.getBankList(), HttpMethod.GET);
    }
}
