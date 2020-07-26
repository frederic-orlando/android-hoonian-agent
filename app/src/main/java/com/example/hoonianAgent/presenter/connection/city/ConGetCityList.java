package com.example.hoonianAgent.presenter.connection.city;

import android.content.Context;

import com.example.hoonianAgent.model.response.city.ResponseGetCityList;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetCityList extends HttpRequest<Objects, ResponseGetCityList> {
    public ConGetCityList(Context context) {
        super(context, ResponseGetCityList.class, URL.getCityList(), HttpMethod.GET);
    }
}
