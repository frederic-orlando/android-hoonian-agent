package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.request.project.RequestRefer;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConRefer extends HttpRequest<RequestRefer, BaseResponse> {
    public ConRefer(RequestRefer request, Context context) {
        super(request, context, BaseResponse.class, URL.REFER, HttpMethod.POST);
    }
}
