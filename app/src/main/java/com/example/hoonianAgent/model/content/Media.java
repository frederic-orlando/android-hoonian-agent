package com.example.hoonianAgent.model.content;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;

import lombok.Data;

@Data
public class Media extends BaseSerializableObject {
    private String id;
    private String link;
}
