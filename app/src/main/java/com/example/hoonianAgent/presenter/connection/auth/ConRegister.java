package com.example.hoonianAgent.presenter.connection.auth;

import android.content.Context;

import com.example.hoonianAgent.model.request.auth.RequestRegister;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConRegister extends HttpRequest<RequestRegister, BaseResponse> {
    public ConRegister(RequestRegister request, Context context) {
        super(request, context, BaseResponse.class, URL.REGISTER, HttpMethod.POST);
    }
}
