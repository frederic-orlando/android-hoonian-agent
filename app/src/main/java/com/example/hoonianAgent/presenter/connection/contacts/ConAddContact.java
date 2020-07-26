package com.example.hoonianAgent.presenter.connection.contacts;

import android.content.Context;

import com.example.hoonianAgent.model.content.contacts.Contacts;
import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.presenter.connection.URL;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConAddContact extends HttpRequest<Contacts, BaseResponse> {
    public ConAddContact(Contacts request, Context context) {
        super(request, context, BaseResponse.class, URL.BASE_URL_CONTACT, HttpMethod.POST);
    }
}
