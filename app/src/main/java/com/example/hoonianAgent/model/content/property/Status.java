package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Status extends BaseSerializableObject {
    @SerializedName("status")
    private String name;
    @SerializedName("color_code")
    private String color;

    // Todo: remove, dummy constructor
    public Status(String color) {
        this.color = color;
    }
}
