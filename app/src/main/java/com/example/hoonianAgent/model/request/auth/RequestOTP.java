package com.example.hoonianAgent.model.request.auth;

import com.google.gson.annotations.SerializedName;

public class RequestOTP {
    private String email;
    @SerializedName("phone_number")
    private String phone;

    public RequestOTP(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}
