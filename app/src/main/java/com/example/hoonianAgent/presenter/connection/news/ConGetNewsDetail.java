package com.example.hoonianAgent.presenter.connection.news;

import android.content.Context;

import com.example.hoonianAgent.model.response.news.ResponseGetNewsDetail;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetNewsDetail extends HttpRequest<Objects, ResponseGetNewsDetail> {
    public ConGetNewsDetail(String id, Context context) {
        super(context, ResponseGetNewsDetail.class, URL.getNewsDetail(id), HttpMethod.GET);
    }
}