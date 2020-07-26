package com.example.hoonianAgent.presenter.connection.projects;

import android.content.Context;

import com.example.hoonianAgent.model.request.project.RequestFavorite;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConUnfavorite extends HttpRequest<RequestFavorite, BaseResponse> {
    public ConUnfavorite(RequestFavorite request, Context context) {
        super(request, context, BaseResponse.class, URL.FAVORITE, HttpMethod.DELETE);
    }
}
