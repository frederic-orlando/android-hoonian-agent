package com.example.hoonianAgent.presenter.connection.contacts;

import android.content.Context;

import com.example.hoonianAgent.model.response.contacts.ResponseGetContactList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetContactList extends HttpRequest<Objects, ResponseGetContactList> {
    public ConGetContactList(String id, Context context) {
        super(context, ResponseGetContactList.class, URL.getContactList(id), HttpMethod.GET);
    }
}
