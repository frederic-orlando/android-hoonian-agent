package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.response.contacts.ResponseGetContactList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetReferredForm  extends HttpRequest<Objects, ResponseGetContactList> {
    public ConGetReferredForm(String agentId, String projectId, Context context) {
        super(context, ResponseGetContactList.class, URL.getReferredForm(agentId, projectId), HttpMethod.GET);
    }
}
