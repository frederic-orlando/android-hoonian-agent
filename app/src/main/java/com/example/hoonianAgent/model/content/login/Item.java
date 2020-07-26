package com.example.hoonianAgent.model.content.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Item {
    @SerializedName("menu_name")
    private String name;
    @SerializedName("menu_id")
    private int id;

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
