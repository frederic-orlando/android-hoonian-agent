package com.example.hoonianAgent.model.content.bank;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;

import lombok.Data;

@Data
public class Bank extends BaseSerializableObject {
    private String id;
    private String name;
    private String code;

    @Override
    public String toString() {
        return name;
    }
}
