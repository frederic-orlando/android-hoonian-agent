package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Block extends BaseSerializableObject {
    private String id;
    private String name;
    @SerializedName("total_unit")
    private int totalUnit;
    @SerializedName("available_unit")
    private int availableUnit;
    @SerializedName("sold_unit")
    private int soldUnit;
    @SerializedName("image_floor_plan")
    private String floorImage;
    @SerializedName("image_floor_plan_size")
    private String floorPlanSize;
}
