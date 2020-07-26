package com.example.hoonianAgent.model.request.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestLogin {
    @SerializedName("phone_number")
    private String phone;
    private String password;
    @SerializedName("user_agent")
    private String userAgent;

    public RequestLogin() {
        this.userAgent = "Android";
    }
}
