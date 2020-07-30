package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.BaseHomeItem;
import com.example.hoonianAgent.model.content.City;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.home.HomeItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Project extends  BaseHomeItem {
    private String name;
    @SerializedName("description")
    private String desc;
    private City city;
    private String category;
    @SerializedName("available_unit")
    private int availableUnit;
    @SerializedName("start_from")
    private int startFrom;
    private String latlng;
    private String address;
    private ArrayList<Facility> facilities;
    @SerializedName("commision_rate")
    private float commissionRate;
    private ArrayList<Media> gallery;
    private ArrayList<Media> videos;

    // Todo: Add isFavorite from api
    private Boolean isFavorite;

    @SerializedName("warehouse_operation_hours")
    private String operationHour;
    @SerializedName("warehouse_size")
    private int size;
    @SerializedName("warehouse_price_meter")
    private int pricePerMeter;
    @SerializedName("warehouse_minimum_rent")
    private int minimumRent;
    @SerializedName("warehouse_type")
    private String type;

    public Project() {
        this.isFavorite = false;
    }
}
