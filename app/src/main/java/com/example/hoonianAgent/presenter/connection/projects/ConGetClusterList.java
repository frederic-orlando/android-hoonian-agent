package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.response.project.ResponseGetClusterList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetClusterList extends HttpRequest<Objects, ResponseGetClusterList> {
    public ConGetClusterList(String id, Context context) {
        super(context, ResponseGetClusterList.class, URL.getClusterList(id), HttpMethod.GET);
    }
}
