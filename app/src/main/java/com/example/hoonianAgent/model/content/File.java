package com.example.hoonianAgent.model.content;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class File extends BaseSerializableObject {
    private String id;
    @SerializedName("file")
    private String link;
}
