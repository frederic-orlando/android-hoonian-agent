package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.Media;
import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Cluster extends BaseSerializableObject {
    private String id;
    @SerializedName("project_id")
    private String projectId;
    private String name;
    @SerializedName("sold_percentage")
    private String soldPercentage;
    @SerializedName("total_unit")
    private String totalUnit;
    private String image;
    private ArrayList<Facility> facilities;
    @SerializedName("project_unit_types")
    private ArrayList<UnitType> unitTypes;

    private ArrayList<Media> gallery;
    private ArrayList<Media> videos;
    @SerializedName("virtual_tour")
    private ArrayList<Media> vr;
}
