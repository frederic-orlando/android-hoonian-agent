package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.BaseHomeItem;
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
    private String city;
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

    @SerializedName("purchase_status")
    //Todo: Remove later
    private String purchaseStatus;

    // Todo: Add from api
    private Boolean isFavorite;

    public Project() {
        this.isFavorite = false;
    }
}
