package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Category extends BaseSerializableObject {
    @SerializedName(value = "id", alternate = "category_id")
    private String id;
    private String name;
    private ArrayList<Project> projects;

    public Category(String name, Category category) {
        this.id = category.id;
        this.name = name;
        this.projects = category.projects;
    }

    public Category(String name, ArrayList<Project> projects) {
        this.name = name;
        this.projects = projects;
    }
}
