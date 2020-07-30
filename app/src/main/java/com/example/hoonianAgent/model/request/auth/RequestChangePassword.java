package com.example.hoonianAgent.model.request.auth;

import com.google.gson.annotations.SerializedName;

public class RequestChangePassword {
    @SerializedName("old_password")
    private String oldPass;
    @SerializedName("new_password")
    private String newPass;
    @SerializedName("confirm_password")
    private String confirmPass;
    @SerializedName("phone_number")
    private String phone;
    private String id;

    public RequestChangePassword(String oldPass, String newPass, String confirmPass, String phone, String agentId) {
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.confirmPass = confirmPass;
        this.phone = phone;
        this.id = agentId;
    }
}
