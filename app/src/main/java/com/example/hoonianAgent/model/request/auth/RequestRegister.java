package com.example.hoonianAgent.model.request.auth;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestRegister extends Agent {
    private String password;
    @SerializedName("")
    private String bankId;

    public RequestRegister(String name, String password, String phone, String idCardNo, String bankId, String accountNo) {
        super(name, phone, idCardNo, accountNo);
        this.password = password;
        this.bankId = bankId;
    }
}
