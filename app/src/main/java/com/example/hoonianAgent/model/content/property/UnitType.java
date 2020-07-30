package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.File;
import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class UnitType extends BaseSerializableObject {
    private String id;
    private String projectId;
    @SerializedName("cluster_id")
    private String clusterId;
    private String name;
    private String size;
    private String image;
    private ArrayList<Media> gallery;
    @SerializedName("augmented_reality")
    private ArrayList<Media> ar;
    private ArrayList<Media> videos;
    @SerializedName("virtual_tour")
    private ArrayList<Media> vr;
    @SerializedName("price_list")
    private File priceList;
    @SerializedName("total_unit")
    private int totalUnit;
    @SerializedName("total_available")
    private int availableUnit;
    @SerializedName("start_price")
    private int startPrice;
    @SerializedName("project_unit")
    private Unit unit;
}
