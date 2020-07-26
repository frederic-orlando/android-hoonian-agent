package com.example.hoonianAgent.presenter.connection.purchase;

import android.content.Context;

import com.example.hoonianAgent.model.response.purchase.ResponseGetPurchaseList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetPurchasedList extends HttpRequest<Objects, ResponseGetPurchaseList> {
    public ConGetPurchasedList(String id, Context context) {
        super(context, ResponseGetPurchaseList.class, URL.getPurchaseList(id), HttpMethod.GET);
    }
}
