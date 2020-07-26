package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.response.project.ResponseGetClusterDetail;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetClusterDetail extends HttpRequest<Objects, ResponseGetClusterDetail> {
    public ConGetClusterDetail(String id, Context context) {
        super(context, ResponseGetClusterDetail.class, URL.getClusterDetail(id), HttpMethod.GET);
    }
}
