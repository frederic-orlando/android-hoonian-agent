package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.response.purchase.ResponseGetPurchaseDetail;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetPurchaseDetail extends HttpRequest<Objects, ResponseGetPurchaseDetail> {
    public ConGetPurchaseDetail(String id, Context context) {
        super(context, ResponseGetPurchaseDetail.class, URL.getPurchaseDetail(id), HttpMethod.GET);
    }
}
