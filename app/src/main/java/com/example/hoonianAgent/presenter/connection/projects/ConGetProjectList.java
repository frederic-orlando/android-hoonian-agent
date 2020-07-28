package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.request.project.RequestProjectList;
import com.example.hoonianAgent.model.response.project.ResponseGetProjectList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetProjectList extends HttpRequest<Objects, ResponseGetProjectList> {
    public ConGetProjectList(RequestProjectList request, Context context) {
        super(context, ResponseGetProjectList.class, URL.getProjectList(request), HttpMethod.GET);
    }
}
