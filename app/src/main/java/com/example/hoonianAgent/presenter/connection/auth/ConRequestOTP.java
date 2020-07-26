package com.example.hoonianAgent.presenter.connection.auth;

import android.content.Context;

import com.example.hoonianAgent.model.request.auth.RequestOTP;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConRequestOTP extends HttpRequest<RequestOTP, BaseResponse> {
    public ConRequestOTP(RequestOTP request, Context context) {
        super(request, context, BaseResponse.class, URL.FORGET_PASSWORD, HttpMethod.POST);
    }
}
