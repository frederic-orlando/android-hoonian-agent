package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.request.project.RequestFloorPlan;
import com.example.hoonianAgent.model.response.project.ResponseGetUnitTable;
import com.example.hoonianAgent.model.response.project.ResponseGetUnitTypeDetail;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetUnitTable extends HttpRequest<Objects, ResponseGetUnitTable> {
    public ConGetUnitTable(RequestFloorPlan request, Context context) {
        super(context, ResponseGetUnitTable.class, URL.getProjectUnitTable(request), HttpMethod.GET);
    }
}