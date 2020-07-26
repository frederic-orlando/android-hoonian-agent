package com.example.hoonianAgent.presenter.connection.auth;

import android.content.Context;

import com.example.hoonianAgent.model.request.auth.RequestLogin;
import com.example.hoonianAgent.model.response.login.ResponseLogin;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConLogin extends HttpRequest<RequestLogin, ResponseLogin> {
    public ConLogin(RequestLogin requestLogin, Context context) {
        super(requestLogin, context, ResponseLogin.class, URL.LOGIN, HttpMethod.POST);
    }
}
