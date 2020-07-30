package com.example.hoonianAgent.model.content.login;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Menu {
    @SerializedName("mobile_menu_id")
    private String id;
    @SerializedName("mobile_menu_name")
    private String name;
}