package com.example.hoonianAgent.model.request.auth;

import com.google.gson.annotations.SerializedName;

public class RequestForgetPassword {
    @SerializedName("new_password")
    private String newPass;
    @SerializedName("confirm_password")
    private String confirmPass;

    public RequestForgetPassword(String newPass, String confirmPass) {
        this.newPass = newPass;
        this.confirmPass = confirmPass;
    }
}
