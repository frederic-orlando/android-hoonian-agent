package com.example.hoonianAgent.presenter.connection.profile;

import android.content.Context;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConEditProfile extends HttpRequest<Agent, BaseResponse> {
    public ConEditProfile(Agent request, Context context) {
        super(request, context, BaseResponse.class, URL.UPDATE_PROFILE, HttpMethod.PUT);
    }
}