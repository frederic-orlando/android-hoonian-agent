package com.example.hoonianAgent.presenter.connection.contacts;

import android.content.Context;

import com.example.hoonianAgent.model.response.BaseResponse;
import com.example.hoonianAgent.model.response.contacts.ResponseGetContactEditForm;
import com.example.hoonianAgent.presenter.connection.URL;

import java.util.Objects;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConGetEditContactForm extends HttpRequest<Objects, ResponseGetContactEditForm> {
    public ConGetEditContactForm(String agentId, String contactId, Context context) {
        super(context, ResponseGetContactEditForm.class, URL.getContactForm(agentId, contactId), HttpMethod.GET);
    }
}
