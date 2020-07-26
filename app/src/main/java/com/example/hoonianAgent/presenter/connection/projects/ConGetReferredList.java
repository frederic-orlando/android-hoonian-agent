package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.response.project.ResponseGetReferredList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetReferredList extends HttpRequest<Objects, ResponseGetReferredList> {
    public ConGetReferredList(String agentId, String projectId, Context context) {
        super(context, ResponseGetReferredList.class, URL.getReferredList(agentId, projectId), HttpMethod.GET);
    }
}
