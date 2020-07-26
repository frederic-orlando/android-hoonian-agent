package com.example.hoonianAgent.presenter.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.example.hoonianAgent.model.content.login.ModelDataLogin;
import com.google.gson.Gson;

public class SessionUser {
    private final String sessionName = "user";
    private final String key = "data";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionUser(Context context) {
        sharedPreferences = context.getSharedPreferences(sessionName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public Agent getData() {
        String json = sharedPreferences.getString(key, null);
        Agent data = new Gson().fromJson(json, Agent.class);

        return data;
    }

    public void setData(ModelDataLogin data) {
        editor.putString(key, new Gson().toJson(data.getAgent()));
        editor.commit();
    }

    public void setData(Agent data) {
        editor.putString(key, new Gson().toJson(data));
        editor.commit();
    }

    public void clearData() {
        editor.clear();
        editor.commit();
    }
}
