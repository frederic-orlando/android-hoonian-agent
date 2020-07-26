package com.example.hoonianAgent.presenter.connection.profile;

import android.content.Context;

import com.example.hoonianAgent.model.response.profile.ResponseGetProfile;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetProfile  extends HttpRequest<Objects, ResponseGetProfile> {
    public ConGetProfile(String id, Context context) {
        super(context, ResponseGetProfile.class, URL.getProfile(id), HttpMethod.GET);
    }
}
