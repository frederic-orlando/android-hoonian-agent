package com.example.hoonianAgent.model.content.home;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;

import java.io.Serializable;

import lombok.Data;

@Data
public class HomeItem extends BaseSerializableObject implements Serializable {
    private String id;
    private String image;
    private String name;
    private String city;

    @Override
    public String toString() {
        return name;
    }
}
