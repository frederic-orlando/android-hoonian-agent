package com.example.hoonianAgent.model.request.auth;

import com.google.gson.annotations.SerializedName;

public class RequestChangePassword {
    @SerializedName("old_password")
    private String oldPass;
    @SerializedName("new_password")
    private String newPass;
    @SerializedName("confirm_password")
    private String confirmPass;
    @SerializedName("agent_id")
    private String agentId;

    public RequestChangePassword(String oldPass, String newPass, String confirmPass, String agentId) {
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.confirmPass = confirmPass;
        this.agentId = agentId;
    }
}
