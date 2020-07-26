package com.example.hoonianAgent.presenter.connection.auth;

import android.content.Context;

import com.example.hoonianAgent.model.request.auth.RequestChangePassword;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConChangePassword extends HttpRequest<RequestChangePassword, BaseResponse> {
    public ConChangePassword(RequestChangePassword request, Context context) {
        super(request, context, BaseResponse.class, URL.PASSWORD, HttpMethod.PUT);
    }
}
