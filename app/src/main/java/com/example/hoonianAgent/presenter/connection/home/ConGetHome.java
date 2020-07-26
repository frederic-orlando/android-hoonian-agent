package com.example.hoonianAgent.presenter.connection.home;

import android.content.Context;

import com.example.hoonianAgent.model.response.home.ResponseHome;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetHome extends HttpRequest<Objects, ResponseHome> {
    public ConGetHome(String id, Context context) {
        super(context, ResponseHome.class, URL.getHome(id), HttpMethod.GET);
    }
}
