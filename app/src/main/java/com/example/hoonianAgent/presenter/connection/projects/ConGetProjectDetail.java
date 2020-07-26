package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.response.project.ResponseGetProjectDetail;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetProjectDetail extends HttpRequest<Objects, ResponseGetProjectDetail> {
    public ConGetProjectDetail(String id, Context context) {
        super(context, ResponseGetProjectDetail.class, URL.getProjectDetail(id), HttpMethod.GET);
    }
}
