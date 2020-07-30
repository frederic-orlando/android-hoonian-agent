package com.example.hoonianAgent.model.request.auth;

import com.example.hoonianAgent.model.content.agent.Agent;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestRegister extends Agent {
    @SerializedName("country_code")
    private String countryCode;
    private String password;

    public RequestRegister(String name, String password, String phone, String idCardNo, String bankId, String accountNo) {
        super(name, phone, idCardNo, bankId, accountNo);
        this.countryCode = "62";
        this.password = password;
    }
}
