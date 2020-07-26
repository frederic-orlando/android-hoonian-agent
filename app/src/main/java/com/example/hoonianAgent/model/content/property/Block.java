package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Block extends BaseSerializableObject {
    @SerializedName("image_floor_plan")
    private String floorImage;
    @SerializedName("image_floor_plan_size")
    private String floorPlanSize;
}
