package com.example.hoonianAgent.model.content;

import lombok.Data;

@Data
public class City extends BaseHomeItem {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
