package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.request.project.RequestFloorPlan;
import com.example.hoonianAgent.model.response.project.ResponseGetFloorPlan;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetFloorPlan extends HttpRequest<Objects, ResponseGetFloorPlan> {
    public ConGetFloorPlan(RequestFloorPlan request, Context context) {
        super(context, ResponseGetFloorPlan.class, URL.getFloorPlan(request), HttpMethod.GET);
    }
}