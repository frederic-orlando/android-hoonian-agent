package com.example.hoonianAgent.model.response.project;

import com.example.hoonianAgent.model.content.property.Block;
import com.example.hoonianAgent.model.content.property.Status;
import com.example.hoonianAgent.model.content.property.Unit;
import com.example.hoonianAgent.model.response.BaseResponsePagination;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ModelDataGetFloorPlan extends BaseResponsePagination {
    @SerializedName("project_block")
    private Block block;
    @SerializedName("project_units")
    private ArrayList<Unit> units;
    @SerializedName("project_unit_status")
    private ArrayList<Status> listStatus;
}
