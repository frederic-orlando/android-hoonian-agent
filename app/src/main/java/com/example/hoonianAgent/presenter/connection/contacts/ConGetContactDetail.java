package com.example.hoonianAgent.presenter.connection.contacts;

import android.content.Context;

import com.example.hoonianAgent.model.response.contacts.ResponseGetContactDetail;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetContactDetail extends HttpRequest<Objects, ResponseGetContactDetail> {
    public ConGetContactDetail(String id, Context context) {
        super(context, ResponseGetContactDetail.class, URL.getContactDetail(id), HttpMethod.GET);
    }
}
