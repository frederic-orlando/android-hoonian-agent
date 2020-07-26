package com.example.hoonianAgent.model.content.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Token {
    @Expose
    @SerializedName("user_id")
    private String userId;

    @Expose
    @SerializedName("access_token")
    private String token;
}
