package com.example.hoonianAgent.model.content.home;

import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.news.News;
import com.example.hoonianAgent.model.content.property.Category;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class ModelDataHome extends BaseSerializableObject implements Serializable {
    private ArrayList<News> news;
    private ArrayList<City> cities;
    private Category apartment;
    @SerializedName("landed_property")
    private Category landedProperty;
    private Category warehouse;
}
